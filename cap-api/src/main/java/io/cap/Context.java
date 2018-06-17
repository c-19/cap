/*
 * Copyright (c) 2018 - 2018, Chris Kelly, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 */

package io.cap;

import io.cap.work.contract.ContractItem;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;


/**
 * Store for contextual information stored as key value pairs.
 *
 * Only allows for addition and retrieval, no removal.
 */
public class Context implements Serializable
{
    private static final long serialVersionUID = 1L;

    HashMap<String,Object> map = new HashMap<>();

    public Context()
    {

    }

    /**
     * Copy Constructor.
     *
     * @param source initialise context from this source context.
     */
    public Context( Context source )
    {
        super();
        this.merge( source );
    }

    /**
     * Add the key value pair to the context.
     * Overwrites already existing keys.
     *
     * @param key key to register
     * @param value value to register to key
     */
    public void put(String key, Object value)
    {
        map.put( key, value );
    }

    /**
     * Add the key value pair to the context.
     * Overwrites already existing keys.
     *
     * Uses {@link ContractItem#getName()} as key value.
     *
     * @param key key to register.
     * @param value value to register to key
     */
    public void put(ContractItem key, Object value )
    {
        put( key.getName(), value );
    }

    /**
     * Merge the given context against the current context.
     * If the given context is null, no change occurs.
     * @param c source context to merge.
     */
    public void merge( Context c )
    {
        if( c == null )
        {
            return;
        }
        map.putAll( c.map );
    }

    /**
     * Check if the key is contained in the context.
     * @param key to check for.
     * @return if the key exists.
     */
    public boolean containsKey(String key)
    {
        return map.containsKey( key );
    }

    /**
     * Check if the key is contained in the context.
     *
     * Uses {@link ContractItem#getName()} as key value.
     *
     * @param key to check for.
     * @return if the key exists.
     */
    public boolean containsKey( ContractItem key )
    {
        return containsKey( key.getName() );
    }

    /**
     * Size of the keys.
     * @return
     */
    public int size()
    {
        return map.size();
    }

    /**
     * Get the value for the key.
     * An implicit cast is perform to the desired expect type.
     *
     * @param key to find.
     * @param <T> implicitly cast to this type.
     * @return value associated with key or null if not present.
     */
    @SuppressWarnings("unchecked")
    public <T>T get( String key )
    {
        return (T)map.get(key);
    }

    /**
     * Get the value for the key.
     * An implicit cast is perform to the desired expect type.
     *
     * Uses {@link ContractItem#getName()} as key value.
     *
     * @param key to find.
     * @param <T> implicitly cast to this type.
     * @return value associated with key or null if not present.
     */
    public <T>T get( ContractItem key )
    {
        return get( key.getName() );
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
        Context context = (Context) o;
        return Objects.equals(map, context.map);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(map);
    }

    @Override
    public String toString()
    {
        return "Context"
                 + map;
    }
}
