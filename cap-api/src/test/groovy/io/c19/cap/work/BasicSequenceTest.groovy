/*
 * Copyright (c) 2018 - 2018, Chris Kelly, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 */

package io.c19.cap.work

import spock.lang.Shared
import spock.lang.Specification

class BasicSequenceTest extends Specification
{
    @Shared Sequence instance

    def setup()
    {
        instance = new BasicSequence()
    }

    def "Initially contains no operations in the sequence."()
    {
        expect:
        instance.getOperations() == Collections.emptyList()
    }

    def "Add operation is stored."()
    {
        given:
        Operation o = new BasicOperation()

        when:
        instance.addOperation( o )
        List<Operation> actual = instance.getOperations()

        then:
        actual.size() == 1
        actual.get( 0 ) == o
    }

    def "Add two operations they are stored in order."()
    {
        given:
        Operation o1 = new BasicOperation()
        o1.setName( "Operation1" )
        Operation o2 = new BasicOperation()
        o2.setName( "Operation2" )

        when:
        instance.addOperation( o1 )
        instance.addOperation( o2 )
        List<Operation> actual = instance.getOperations()

        then:
        actual.size() == 2
        actual.get( 0 ) == o1
        actual.get( 1 ) == o2
    }

    def "Add null operation, throws NullPointerException."()
    {
        when:
        instance.addOperation( null )

        then:
        thrown NullPointerException
    }

}
