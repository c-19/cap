/*
 * Copyright (c) 2018 - 2018, C19, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 *
 */

package io.c19.cap.work;

public abstract class AbstractOperation extends ContextualMonitorBase implements Operation
{
    @Override
    public void init()
    {
        //Do nothing
    }

    @Override
    public void cleanup()
    {
        //Do nothing
    }
}
