package io.cap;

import java.time.LocalDateTime;

/**
 * Basic operation with no init or setup, save context
 * so that it is available within run operations.
 */
public class BasicOperation extends AbstractOperation
{
    private static final long serialVersionUID = 1L;

    @Override
    public void init()
    {
        //Do nothing
    }

    @Override
    public Output run( Input input )
    {
        String runKey = getParentName() + "." + getName() + ".run";
        getContext().put( runKey, LocalDateTime.now() );
        return new Output();
    }

    @Override
    public void cleanup()
    {
        String initKey = getParentName() + "." + getName() + ".cleanup";
        getContext().put( initKey, LocalDateTime.now() );
    }
}
