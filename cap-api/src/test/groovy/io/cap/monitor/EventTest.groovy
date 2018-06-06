package io.cap.monitor

import io.cap.Context
import io.cap.Contextual
import io.cap.work.BasicOperation
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
