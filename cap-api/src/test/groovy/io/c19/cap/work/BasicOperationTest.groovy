/*
 * Copyright (c) 2018 - 2018, C19, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 *
 */

package io.c19.cap.work

import io.c19.cap.Context
import io.c19.cap.monitor.BasicObserver
import io.c19.cap.monitor.Event
import io.c19.cap.monitor.Monitor
import io.c19.cap.work.contract.Input
import io.c19.cap.work.contract.Output
import spock.lang.Shared
import spock.lang.Specification

class BasicOperationTest extends Specification
{
    @Shared Operation instance

    def setup()
    {
        instance = new BasicOperation()
    }

    def "Setting and Retrieving Context"()
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

    def "Run operation as expected."()
    {
        given:
        Context initialContext = new Context()

        when:
        instance.setContext( initialContext )
        instance.init()
        Output actual = instance.run( new Input() )
        instance.cleanup()
        Context actualContext = instance.getContext()

        then:
        actual != null
        actualContext == initialContext
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
}
