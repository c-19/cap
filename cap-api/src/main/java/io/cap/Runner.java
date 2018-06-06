package io.cap;

/**
 * Responsible for create and persisting runtime context.<br/>
 */
public interface Runner extends Contextual, Named
{
    /**
     * Run the operation.
     * @param operation to run.
     */
    Output run( Operation operation, Input input );
}
