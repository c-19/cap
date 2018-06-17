/*
 * Copyright (c) 2018 - 2018, Chris Kelly, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 */

package io.cap.work.contract

import spock.lang.Shared
import spock.lang.Specification

class ContractTest extends Specification
{
    @Shared Contract instance

    def setup()
    {
        instance = Contract.newBuilder().build()
    }

    def "Initially everything is empty."()
    {
        expect:
        instance.getContext() == Collections.emptyList()
        instance.getInput() == Collections.emptyList()
        instance.getOutput() == Collections.emptyList()
    }

    def "Add Input Items"()
    {
        given:
        ContractItem c = new InputContractItem( "name1", "desc1" )
        instance = Contract.newBuilder().input( c ).build()

        expect:
        instance.getContext() == Collections.emptyList()
        instance.getInput() == [c]
        instance.getOutput() == Collections.emptyList()
    }

    def "Add Two Input Items"()
    {
        given:
        ContractItem c = new InputContractItem( "name1", "desc1" )
        ContractItem c2 = new InputContractItem( "name2", "desc2" )
        instance = Contract.newBuilder().input( c, c2 ).build()

        expect:
        instance.getContext() == Collections.emptyList()
        instance.getInput() == [c, c2]
        instance.getOutput() == Collections.emptyList()
    }

    def "Add Output Items"()
    {
        given:
        ContractItem c = new OutputContractItem( "name1", "desc1" )
        instance = Contract.newBuilder().output( c ).build()

        expect:
        instance.getContext() == Collections.emptyList()
        instance.getInput() == Collections.emptyList()
        instance.getOutput() == [c]
    }

    def "Add Two Output Items"()
    {
        given:
        ContractItem c = new OutputContractItem( "name1", "desc1" )
        ContractItem c2 = new OutputContractItem( "name2", "desc2" )
        instance = Contract.newBuilder().output( c, c2 ).build()

        expect:
        instance.getContext() == Collections.emptyList()
        instance.getInput() == Collections.emptyList()
        instance.getOutput() == [c,c2]
    }

    def "Add Context Items"()
    {
        given:
        ContractItem c = new ContextContractItem( "name1", "desc1" )
        instance = Contract.newBuilder().context( c ).build()

        expect:
        instance.getContext() == [c]
        instance.getInput() == Collections.emptyList()
        instance.getOutput() == Collections.emptyList()
    }

    def "Add Two Context Items"()
    {
        given:
        ContractItem c = new OutputContractItem( "name1", "desc1" )
        ContractItem c2 = new ContextContractItem( "name1", "desc1" )
        instance = Contract.newBuilder().context( c, c2 ).build()

        expect:
        instance.getContext() == [c, c2]
        instance.getInput() == Collections.emptyList()
        instance.getOutput() == Collections.emptyList()
    }
}
