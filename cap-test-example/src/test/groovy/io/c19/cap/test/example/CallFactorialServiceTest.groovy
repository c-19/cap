/*
 * Copyright (c) 2018 - 2018, Chris Kelly, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 */

package io.c19.cap.test.example

import io.c19.cap.work.AbstractSequence
import io.c19.cap.work.BasicRunner
import io.c19.cap.work.Operation
import io.c19.cap.work.Runner
import io.c19.cap.work.Sequence
import io.c19.cap.work.contract.Contract
import io.c19.cap.work.contract.Input
import io.c19.cap.work.contract.Output
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class CallFactorialServiceTest extends Specification
{
    @Shared Runner runner = new BasicRunner()

    @Unroll
    def "Run sequence with input returns expected output #n!."()
    {
        given:
        Sequence sequence = new BasicSequence()
        Operation callFactorialService = new CallFactorialService()
        sequence.setName( "VerifyFactorialService" )
        callFactorialService.setName( "CallFactorialService" )

        sequence.addOperation( callFactorialService )
        Input input = new Input()
        input.put( CallFactorialService.N, n )

        when:
        Output output = runner.run( sequence, input )

        then:
        output.get( CallFactorialService.RESULT ) == expected

        where:
        n  || expected
        0L  || 1L
        1L  || 1L
        2L  || 2L
        3L  || 6L
        4L  || 24L
        5L  || 120L
        6L  || 720L
        15L || 1307674368000L
        20L || 2432902008176640000L
    }

    def "Check contract is as expected."()
    {
        when:
        Contract c = new CallFactorialService().getContract()

        then:
        c != null
        c.getInput().size() == 1
        c.getOutput().size() == 1
    }

    class BasicSequence extends AbstractSequence
    {
        @Override
        Contract getContract()
        {
            return Contract.newBuilder().build()
        }
    }

}
