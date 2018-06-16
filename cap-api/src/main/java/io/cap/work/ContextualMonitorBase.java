/*
 * Copyright (c) 2018 - 2018, Chris Kelly, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 */

package io.cap.work;

import io.cap.Context;
import io.cap.Contextual;
import io.cap.monitor.Event;
import io.cap.monitor.Monitor;
import io.cap.monitor.Monitored;

public abstract class ContextualMonitorBase implements Contextual, Monitored
{
    private Context context = new Context();
    private String parentName = "ROOT";
    private String name = this.getClass().getName();
    private Monitor monitor;

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
    public String getParentName()
    {
        return this.parentName;
    }

    @Override
    public void setParentName(String name)
    {
        this.parentName = name;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String getFullyQualifiedName()
    {
        return getParentName() + "." + getName();
    }

    @Override
    public Monitor getMonitor()
    {
        return this.monitor;
    }

    @Override
    public void setMonitor(Monitor monitor)
    {
        this.monitor = monitor;
    }

    @Override
    public void register( Event event )
    {
        if( getMonitor() == null )
        {
            return;
        }

        getMonitor().register( event );
    }
}
