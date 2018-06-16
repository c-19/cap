/*
 * Copyright (c) 2018 - 2018, Chris Kelly, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 */

package io.cap.test.example;

import io.cap.test.example.service.FactorialService;
import io.cap.work.AbstractOperation;
import io.cap.work.Input;
import io.cap.work.Output;

/**
 * Example of a simple operation that calls another service.
 * This example calls a factorial java class.
 */
public class CallFactorialService extends AbstractOperation
{
    private FactorialService factorialService;
    @Override
    public void init()
    {
        factorialService = new FactorialService();
    }

    @Override
    public Output run(Input input)
    {
        Long n = input.get( "n" );
        Output output = new Output();
        long result = factorialService.calculate( n );
        output.put( "result", result );
        return output;
    }

    @Override
    public void cleanup()
    {
        factorialService = null;
    }
}
