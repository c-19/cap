/*
 * Copyright (c) 2018 - 2018, Chris Kelly, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 */

package io.c19.cap.work;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractSequence extends ContextualMonitorBase implements Sequence
{
    List<Operation> operations = new ArrayList<>();

    @Override
    public void addOperation(Operation operation)
    {
        Objects.requireNonNull( operation, "Operation is null." );

        operations.add( operation );
    }

    @Override
    public List<Operation> getOperations()
    {
        return new ArrayList<>( operations );
    }
}
