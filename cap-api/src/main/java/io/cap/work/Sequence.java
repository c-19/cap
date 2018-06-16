/*
 * Copyright (c) 2018 - 2018, Chris Kelly, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 */

package io.cap.work;

import io.cap.Contextual;
import io.cap.monitor.Monitored;

import java.util.List;

/**
 * Grouping of {@link Operation}s that can be chained together.<br/>
 *
 * The {@link Output} from each {@link Operation} becomes the {@link Input} to the next.<br/>
 *
 * To adapt {@link Output} from one {@link Operation} to the nexts {@link Input} an
 * intermediate {@link Operation} could be used.
 */
public interface Sequence extends Contextual, Monitored
{

    /**
     * Add an {@link Operation} to the end of the group chain.
     *
     * @param operation to add.
     */
    void addOperation( Operation operation );

    /**
     * Retrieve the ordered list of {@link Operation}s in the sequence.
     * @return list of {@link Operation}s.
     */
    List<Operation> getOperations();
}
