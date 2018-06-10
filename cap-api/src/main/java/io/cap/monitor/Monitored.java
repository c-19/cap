/*
 * Copyright (c) 2018 - 2018, Chris Kelly, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 */

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
