package io.cap.work;

import io.cap.Contextual;
import io.cap.Named;
import io.cap.monitor.Monitored;

/**
 * Responsible for create and persisting runtime context.<br/>
 */
public interface Runner extends Contextual, Monitored
{
    /**
     * Run the operation.
     * @param operation to run.
     */
    Output run(Operation operation, Input input );
}
