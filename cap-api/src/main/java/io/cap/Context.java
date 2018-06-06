package io.cap;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


/**
 * Store for contextual information stored as key value pairs.
 *
 * Only allows for addition and retrieval, no removal.
 */
public class Context implements Serializable
{
    private static final long serialVersionUID = 1L;

    Map<String,Object> map = new HashMap<>();

    public void put(String key, Object value)
    {
        map.put( key, value );
    }

    public void merge( Context c )
    {
        map.putAll( c.map );
    }

    public boolean containsKey(String key)
    {
        return map.containsKey( key );
    }

    public int size()
    {
        return map.size();
    }

    @SuppressWarnings("unchecked")
    public <T>T get( String key )
    {
        return (T)map.get(key);
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
