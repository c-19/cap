/*
 * Copyright (c) 2018 - 2018, Chris Kelly, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 */

package io.c19.cap.monitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple observer that stores events in a list.
 */
public class BasicObserver implements EventObserver
{
    List<Event> events = new ArrayList<>();

    @Override
    public void observe(Event event)
    {
        this.events.add( event );
    }

    /**
     * Retrieve the list of observed events.
     * @return events
     */
    public List<Event> getEvents()
    {
        return this.events;
    }
}
