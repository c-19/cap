package io.cap.monitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Recieve events and dispatch to all listeners.
 */
public class Monitor
{
    List<EventObserver> observers = new ArrayList<>();


    public final void register( Event event )
    {
        for( EventObserver e: observers )
        {
            e.observe( event );
        }
    }

    public void addObserver(EventObserver observer)
    {
        this.observers.add( observer );
    }

    public void removeObserver( EventObserver observer )
    {
        this.observers.remove( observer );
    }

    public int getObserverSize( )
    {
        return this.observers.size();
    }
}
