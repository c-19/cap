/*
 * Copyright (c) 2018 - 2018, Chris Kelly, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 */

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
