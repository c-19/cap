/*
 * Copyright (c) 2018 - 2018, C19, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 *
 */

package io.c19.cap.test.example;

import io.c19.cap.test.example.service.FactorialService;
import io.c19.cap.work.AbstractOperation;
import io.c19.cap.work.contract.Contract;
import io.c19.cap.work.contract.ContractItem;
import io.c19.cap.work.contract.Input;
import io.c19.cap.work.contract.InputContractItem;
import io.c19.cap.work.contract.Output;
import io.c19.cap.work.contract.OutputContractItem;

/**
 * Example of a simple operation that calls another service.
 * This example calls a factorial java class.
 */
public class CallFactorialService extends AbstractOperation
{
    public static final ContractItem N = new InputContractItem( "n", "Positive integer to calculate factorial - n!");
    public static final ContractItem RESULT = new OutputContractItem( "result", "Result of factorial calculation." );

    private static final Contract contract = Contract.newBuilder()
            .input( N )
            .output( RESULT )
            .build();

    private FactorialService factorialService;
    @Override
    public void init()
    {
        factorialService = new FactorialService();
    }

    @Override
    public Output run(Input input)
    {
        Long n = input.get( N );
        Output output = new Output();
        long result = factorialService.calculate( n );
        output.put( RESULT, result );
        return output;
    }

    @Override
    public void cleanup()
    {
        factorialService = null;
    }

    @Override
    public Contract getContract()
    {
        return contract;
    }
}
