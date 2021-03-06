/*
 * Copyright (c) 2018 - 2018, C19, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 *
 */

package io.c19.cap.work;

import io.c19.cap.Context;
import io.c19.cap.Contextual;
import io.c19.cap.monitor.Monitored;
import io.c19.cap.work.contract.Input;
import io.c19.cap.work.contract.Output;
import io.c19.cap.work.contract.Contractual;

/**
 * A discrete unit of activity.<br/>
 *
 * Should perform a single action only.</br>
 *
 * Can be called in a chain with other operations
 * to perform a sequence of actions.<br/>
 *
 * Lifecycle of an operation will follow:
 *
 * <ol>
 *     <li>new - operation is created.</li>
 *     <li>{@link #setContext(Context)} - initialise runtime context.</li>
 *     <li>{@link #init()} - perform necessary setup.</li>
 *     <li>{@link #run(Input)} - perform operation return result.</li>
 *     <li>{@link #cleanup()} - perform necessary teardown</li>
 *     <li>{@link #getContext()} - retrieve runtime context.</li>
 * </ol>
 *
 */
public interface Operation extends Contextual, Monitored, Contractual
{
    /**
     * Initialise the operation for running.
     * Use this method to perform any setup
     * activities prior to calling {@link #run(Input)}
     */
    void init();

    /**
     * Perform the operation.
     *
     * @param input paramaters
     * @return result
     */
    Output run(Input input );

    /**
     * Clean up after running the operation.
     * Use this method to perform any tearDown
     * activities after calling {@link #run(Input)}
     */
    void cleanup();

}
