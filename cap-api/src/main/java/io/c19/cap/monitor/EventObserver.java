/*
 * Copyright (c) 2018 - 2018, C19, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 *
 */

package io.c19.cap.monitor;

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
