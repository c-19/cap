package io.cap.monitor;

/**
 * Accessor for monitor.
 */
public interface Monitored
{
    /**
     * Get the monitor of the object.
     * @return monitor or null if none registered.
     */
    Monitor getMonitor();

    /**
     * Set the monitor of the object.
     * @param monitor monitor to associate.
     */
    void setMonitor( Monitor monitor );

    /**
     * Register an event with the associated monitor.
     * If none is present, then this is a no op.
     * @param event to register with the monitor.
     */
    void register( Event event );
}
