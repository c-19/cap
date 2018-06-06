package io.cap;

import java.io.Serializable;

public abstract class AbstractRunner implements Runner, Serializable
{
    private static final long serialVersionUID = 1L;

    private Context context;
    private String parentName = "ROOT";
    private String name = this.getClass().getName();

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
}
