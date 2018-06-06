package io.cap

import spock.lang.Shared
import spock.lang.Specification

class BasicOperationTest extends Specification
{
    @Shared Operation instance

    def setup()
    {
        instance = new TestOperation()
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


    class TestOperation extends BasicOperation
    {
        Output run( Input input )
        {
            return new Output()
        }
    }
}
