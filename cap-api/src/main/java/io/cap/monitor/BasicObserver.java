package io.cap.monitor;

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
