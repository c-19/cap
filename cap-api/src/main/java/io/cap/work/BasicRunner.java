package io.cap.work;

import io.cap.monitor.Event;

import java.time.LocalDateTime;

/**
 * Basic runner.
 */
public class BasicRunner extends AbstractRunner
{

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

    private void doInit( Operation operation )
    {
        record(operation, "init.start", LocalDateTime.now() );

        operation.init();

        record(operation, "run.end", LocalDateTime.now() );

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
