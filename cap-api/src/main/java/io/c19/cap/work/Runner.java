/*
 * Copyright (c) 2018 - 2018, C19, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 *
 */

package io.c19.cap.work;

import io.c19.cap.Contextual;
import io.c19.cap.monitor.Monitored;
import io.c19.cap.work.contract.Input;
import io.c19.cap.work.contract.Output;

/**
 * Responsible for create and persisting runtime context.<br/>
 */
public interface Runner extends Contextual, Monitored
{
    /**
     * Run the operation.
     *
     * @param operation to run.
     * @param input to the operation.
     * @return output from the operation.
     */
    Output run(Operation operation, Input input );

    /**
     * Run the sequence.
     *
     * @param sequence to run.
     * @param input to the sequence.
     * @return output from the operation.
     */
    Output run(Sequence sequence, Input input );
}
