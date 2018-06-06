package io.cap.monitor;

/**
 * Receives notifications of events
 * these events are processed as appropriate.
 */
public interface EventObserver
{
    /**
     * Receive notification of an event.
     *
     * @param event that has occured.
     */
    void observe( Event event );
}
