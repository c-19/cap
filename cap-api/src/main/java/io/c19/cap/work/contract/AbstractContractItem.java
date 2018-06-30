/*
 * Copyright (c) 2018 - 2018, C19, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 *
 */

package io.c19.cap.work.contract;

import java.util.Objects;

public abstract class AbstractContractItem implements ContractItem
{
    private final String name;
    private final Type type;
    private final String description;

    public AbstractContractItem(String name, Type type, String description )
    {
        this.name = name;
        this.type = type;
        this.description = description;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public Type getType()
    {
        return type;
    }

    @Override
    public String getDescription()
    {
        return description;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        AbstractContractItem that = (AbstractContractItem) o;
        return Objects.equals(name, that.name) &&
                type == that.type &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(name, type, description);
    }

    @Override
    public String toString()
    {
        return "ContractItem{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", description='" + description + '\'' +
                '}';
    }
}
