/*
 * Copyright (c) 2018 - 2018, Chris Kelly, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 */

package io.cap.work

import io.cap.Context
import io.cap.monitor.BasicObserver
import io.cap.monitor.Event
import io.cap.monitor.Monitor
import io.cap.work.contract.Contract
import io.cap.work.contract.Input
import io.cap.work.contract.Output
import spock.lang.Shared
import spock.lang.Specification

class BasicRunnerTest extends Specification
{
    @Shared Operation operation
    @Shared Runner instance

    def setup()
    {
        operation = new BasicOperation()
        instance = new BasicRunner()
    }

    def "Setting and retrieving context"()
    {
        given:
        Context c = new Context()
        c.put( "key", "value" )

        when:
        instance.setContext( c )

        then:
        instance.getContext() == c
    }

    def "Get name"()
    {
        given:
        String parent = "p"
        String name = "n"
        instance.setParentName( parent )
        instance.setName( name )

        when:
        String actual = instance.getFullyQualifiedName()

        then:
        actual == parent + "." + name
    }

    def "Run the given operation"()
    {
        given:
        Context c = new Context()
        c.put( "runner", "value" )
        Input input = new Input()
        instance.setContext( c )

        when:
        Output actual = instance.run( operation, input )

        then:
        operation.getContext() == c
        actual != null
    }

    def "Run exceptional operation"()
    {
        given:
        Context c = new Context()
        instance.setContext( c )
        Operation o = new ExceptionalOperation()

        when:
        Output actual = instance.run( o, new Input() )

        then:
        o.getContext() == c
        actual != null
    }

    def "Register without monitor"()
    {
        when:
        instance.register( Event.of( instance, "nothing" ) )

        then:
        noExceptionThrown()
    }

    def "Get set monitor"()
    {
        given:
        Monitor m = new Monitor()
        BasicObserver o = new BasicObserver()
        m.addObserver( o )
        instance.setMonitor( m )
        Event e = Event.of( instance, "hello" )

        when:
        instance.register( e )

        then:
        o.getEvents() == [e]
    }

    def "Run a sequence of operations in order."()
    {
        given:
        Monitor m = new Monitor()
        BasicObserver o = new BasicObserver()
        m.addObserver( o )
        instance.setMonitor( m )

        Sequence s = new BasicSequence()
        s.setName( "s1" )
        Operation o1 = new AddOneOperation()
        o1.setName( "o1" )
        Operation o2 = new AddOneOperation()
        o2.setName( "o2" )
        s.addOperation( o1 )
        s.addOperation( o2 )

        Input input = new Input()
        input.put( "n", 1 )

        when:
        Output output = instance.run( s, input )

        then:
        output.get( "n" ) == 3

    }

    class BasicSequence extends AbstractSequence
    {
        @Override
        Contract getContract()
        {
            return Contract.newBuilder().build()
        }
    }

    class BasicOperation extends AbstractOperation
    {

        @Override
        Output run(Input input)
        {
            return new Output( input )
        }

        @Override
        Contract getContract() {
            return Contract.newBuilder().build()
        }
    }

    class ExceptionalOperation extends BasicOperation
    {
        @Override
        Output run( Input input )
        {
            throw new RuntimeException( "Exceptional." )
        }
    }

    class AddOneOperation extends BasicOperation
    {
        @Override
        Output run( Input input )
        {
            Output output = new Output()
            Integer i = input.get( "n" )
            i++
            output.put( "n", i )
            return output
        }
    }


}
