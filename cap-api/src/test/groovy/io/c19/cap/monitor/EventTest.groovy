/*
 * Copyright (c) 2018 - 2018, C19, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 *
 */

package io.c19.cap.monitor

import io.c19.cap.Context
import io.c19.cap.Contextual
import io.c19.cap.work.BasicOperation
import spock.lang.Shared
import spock.lang.Specification

class EventTest extends Specification
{
    @Shared Event instance
    @Shared Contextual contextual = new BasicOperation()
    @Shared Context context = new Context()
    @Shared String message = "Hello"
    @Shared Object[] args = [1,"two", 3 ]
    @Shared parentName = "parent"
    @Shared name = "name"

    def setup()
    {
        context.put( "key", "value" )
        contextual.setContext( context )
        contextual.setParentName( parentName )
        contextual.setName( name )

        instance = Event.of( contextual, message, args )
    }

    def "GetSourceContext"()
    {
        expect:
        instance.getSourceContext() == context
    }

    def "GetSourceName"()
    {
        expect:
        instance.getSourceName() == parentName + "." + name
    }

    def "GetMessage"()
    {
        expect:
        instance.getMessage() == message
    }

    def "GetArgs"()
    {
        expect:
        instance.getArgs() == args
    }

    def "GetTime"()
    {
        expect:
        instance.getTime() != null
    }

    def "ToString"()
    {
        when:
        String actual = instance.toString()

        then:
        actual.contains( message )
    }
}
