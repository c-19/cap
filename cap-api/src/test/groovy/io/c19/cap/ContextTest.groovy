/*
 * Copyright (c) 2018 - 2018, Chris Kelly, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 */

package io.c19.cap

import io.c19.cap.work.contract.AbstractContractItem
import io.c19.cap.work.contract.ContractItem
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class ContextTest extends Specification
{
    @Shared Context instance


    def setup()
    {
        instance = new Context();
    }

    def "Add String to context."()
    {
        given:
        String key = "key"
        String value = "value"

        when:
        instance.put( key, value )

        then:
        instance.size() == 1
        instance.containsKey( key )
        instance.get( key ) == value
    }

    def "Add Contract key to context"()
    {
        given:
        String keyName = "name"
        ContractItem key = new TestContractItem( keyName, ContractItem.Type.CONTEXT, "" )
        String value = "value"

        when:
        instance.put( key, value )

        then:
        instance.size() == 1
        instance.containsKey( key )
        instance.get( key ) == value

        instance.containsKey( keyName )
        instance.get( keyName ) == value
    }

    def "Equals and hashcode checks simple checks."()
    {
        given:
        Context c1 = new Context()
        Context c2 = new Context()

        expect:
        ! c1.equals( null )
        ! c1.equals( "" )
        c1.equals( c2 )
        c2.equals( c1 )
        c1.equals( c1 )
        c2.equals( c2 )
        c1.hashCode() == c2.hashCode()
    }

    @Unroll
    def "Equals and hashcode checks populated checks."()
    {
        given:
        Context c1 = new Context()
        Context c2 = new Context()

        c1.put( c1_key, c1_value )
        c2.put( c2_key, c2_value )

        expect:
        c1.equals( c2 ) == result
        c2.equals( c1 ) == result
        c1.equals( c1 )
        c2.equals( c2 )
        (c1.hashCode() == c2.hashCode()) == result

        where:
        c1_key | c1_value | c2_key | c2_value || result
        "key"  | "value"  | "key"  | "value"  || true
        "key"  | "value1" | "key"  | "value2" || false
        "key1" | "value"  | "key"  | "value"  || false
        "key"  | 1234567  | "key"  | 1234567  || true
        "key"  | 1234567  | "key"  | 1234568  || false
        "key"  | new Object()  | "key"  | new Object()  || false
    }

    def "toString contains map."()
    {
        given:
        String key = "key"
        String value = "value"
        instance.put( key, value )

        when:
        String actual = instance.toString()

        then:
        actual.contains( key )
        actual.contains( value )
    }

    def "merge context"()
    {
        given:
        Context c1 = new Context()
        Context c2 = new Context()
        Context expected1 = new Context()

        String key1 = "key1"
        String key2 = "key2"

        String value1 = "value1"
        String value2 = "value2"

        c1.put( key1, value1 )
        c2.put( key1, value2 )
        c2.put( key2, value1 )

        expected1.put( key1, value2 )
        expected1.put( key2, value1 )

        when:
        c1.merge( c2 )

        then:
        c1 == expected1
    }

    def "Merge null does nothing"()
    {
        given:
        instance.put( "key", "value" )

        when:
        instance.merge( null )

        then:
        instance.size() == 1
    }

    def "Copy constructor"()
    {
        given:
        instance.put( "key", "value" )

        when:
        Context actual = new Context( instance )

        then:
        actual == instance

        when:
        instance.put( "key", "value2" )

        then:
        actual != instance
    }

    class TestContractItem extends AbstractContractItem
    {
        TestContractItem(String name, Type type, String description )
        {
            super( name, type, description )
        }
    }

}
