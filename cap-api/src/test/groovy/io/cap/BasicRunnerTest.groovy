package io.cap

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

    class ExceptionalOperation extends BasicOperation
    {
        @Override
        Output run( Input input )
        {
            throw new RuntimeException( "Exceptional." );
        }
    }


}
