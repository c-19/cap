/*
 * Copyright (c) 2018 - 2018, Chris Kelly, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 */

package io.c19.cap.work.contract

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class AbstractContractItemTest extends Specification
{
    @Shared AbstractContractItem instance
    @Shared String name = "name"
    @Shared String description = "description"
    @Shared ContractItem.Type type = ContractItem.Type.CONTEXT

    def setup()
    {
        instance = new TestContractItem( name, type, description )
    }

    def "type is Context"()
    {
        expect:
        instance.getType() == type
    }

    def "name is set"()
    {
        expect:
        instance.getName() == name
    }

    def "description is set"()
    {
        expect:
        instance.getDescription() == description
    }

    @Unroll
    def "Equals and Hashcode check"()
    {
        given:
        AbstractContractItem i1 = new TestContractItem( name1, type1, description1 )
        AbstractContractItem i2 = new TestContractItem( name2, type2, description2 )

        expect:
        ! i1.equals( null )
        ! i2.equals( null )
        ! i1.equals( "String" )
        ! i2.equals( "String" )

        i1.equals( i2 ) == result
        i1.equals( i1 )
        i2.equals( i2 )
        (i1.hashCode() == i2.hashCode()) == result

        where:
        name1 | name2 | type1                     | type2                     | description1  | description2  || result
        "n1"  | "n1"  | ContractItem.Type.CONTEXT | ContractItem.Type.CONTEXT | "desc1"       | "desc1"      || true
        "n1"  | "n2"  | ContractItem.Type.CONTEXT | ContractItem.Type.CONTEXT | "desc1"       | "desc1"      || false
        "n1"  | "n1"  | ContractItem.Type.CONTEXT | ContractItem.Type.INPUT   | "desc1"       | "desc1"      || false
        "n1"  | "n1"  | ContractItem.Type.CONTEXT | ContractItem.Type.CONTEXT | "desc1"       | "desc2"      || false
    }

    def "toString Check"()
    {
        when:
        String actual = instance.toString()

        then:
        actual != null
        actual.contains( name )
        actual.contains( description )
        actual.contains( type.toString() )
    }

    class TestContractItem extends AbstractContractItem
    {
        TestContractItem(String name, Type type, String description )
        {
            super( name, type, description )
        }
    }
}
