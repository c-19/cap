/*
 * Copyright (c) 2018 - 2018, C19, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 *
 */

package io.c19.cap.work;

import io.c19.cap.monitor.Event;
import io.c19.cap.work.contract.Input;
import io.c19.cap.work.contract.Output;

import java.time.LocalDateTime;

/**
 * Basic runner.
 */
public class BasicRunner extends AbstractRunner
{
    private static final String SEQUENCE_INPUT = "sequence.input";

    @Override
    public Output run(Operation operation, Input input )
    {
        Output output = new Output();
        operation.setContext( getContext() );
        try
        {
            doInit( operation );
            output = doRun(operation,input);
            getContext().merge( operation.getContext() );
            return output;
        }
        catch( Exception e )
        {
            record(operation, "error", e.getMessage() );
        }
        finally
        {
            doCleanup( operation );
        }
        return output;
    }

    @Override
    public Output run(Sequence sequence, Input input)
    {
        Input operationInput = new Input( input );
        Output output = new Output();

        getContext().put( SEQUENCE_INPUT, input);

        for( Operation o: sequence.getOperations() )
        {
            o.setParentName( sequence.getFullyQualifiedName() );
            output = run( o, operationInput );
            operationInput = new Input( output );
        }

        return output;

    }

    private void doInit( Operation operation )
    {
        record(operation, "init.start", LocalDateTime.now() );

        operation.init();

        record(operation, "init.end", LocalDateTime.now() );

    }

    private Output doRun( Operation operation, Input input )
    {
        record(operation, "run.input", input );

        record(operation, "run.start", LocalDateTime.now() );

        Output output  = operation.run( input );

        record(operation, "run.end", LocalDateTime.now() );

        record(operation, "run.output", output );

        return output;
    }

    private void doCleanup( Operation operation )
    {
        record(operation, "cleanup.start", LocalDateTime.now() );

        operation.cleanup();

        record( operation, "cleanup.end", LocalDateTime.now() );
    }

    private void record( Operation operation, String keyEnd, Object...value )
    {
        register( Event.of( operation, keyEnd, value ) );
    }
}
