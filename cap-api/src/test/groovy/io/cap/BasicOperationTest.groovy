package io.cap

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
}
