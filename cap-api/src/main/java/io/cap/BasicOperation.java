package io.cap;

import java.io.Serializable;

/**
 * Basic operation with no init or setup, save context
 * so that it is available within run operations.
 */
public abstract class BasicOperation implements Operation, Serializable
{
    private static final long serialVersionUID = 1L;

    private Context context;

    @Override
    public Context getContext()
    {
        return context;
    }

    @Override
    public void setContext(Context context)
    {
        this.context = context;
    }

    @Override
    public void init()
    {
        //Do nothing.
    }

    @Override
    public void cleanup()
    {
        //Do nothing
    }
}
