/*
 * Copyright (c) 2018 - 2018, Chris Kelly, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 */

package io.cap.work;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Basic Sequence.
 */
public class BasicSequence extends AbstractSequence
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