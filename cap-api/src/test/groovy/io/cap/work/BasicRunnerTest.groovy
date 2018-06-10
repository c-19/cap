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

    class ExceptionalOperation extends BasicOperation
    {
        @Override
        Output run( Input input )
        {
            throw new RuntimeException( "Exceptional." );
        }
    }


}
