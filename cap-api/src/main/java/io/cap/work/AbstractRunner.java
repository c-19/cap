package io.cap.work;

import io.cap.Context;
import io.cap.monitor.Event;
import io.cap.monitor.Monitor;

import java.io.Serializable;

public abstract class AbstractRunner implements Runner, Serializable
{
    private static final long serialVersionUID = 1L;

    private Context context;
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
