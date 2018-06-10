/*
 * Copyright (c) 2018 - 2018, Chris Kelly, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 */

package io.cap.work;

import java.time.LocalDateTime;

/**
 * Basic operation with no init or setup, save context
 * so that it is available within run operations.
 */
public class BasicOperation extends AbstractOperation
{

    @Override
    public void init()
    {
        //Do nothing
    }

    @Override
    public Output run(Input input )
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
