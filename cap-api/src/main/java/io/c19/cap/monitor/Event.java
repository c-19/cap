/*
 * Copyright (c) 2018 - 2018, Chris Kelly, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 */

package io.c19.cap.monitor;

import io.c19.cap.Context;
import io.c19.cap.Contextual;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Event
{

    private final Context sourceContext;
    private final String sourceName;
    private final String message;
    private final Object[] args;
    private final LocalDateTime time;

    private Event(Contextual sourceContext, String message, Object...args )
    {
        Context c = new Context();
        c.merge( sourceContext.getContext() );
        this.sourceContext = c;
        this.sourceName = sourceContext.getFullyQualifiedName();
        this.message = message;
        this.args = args;
        this.time = LocalDateTime.now();
    }

    public static Event of(Contextual source, String message, Object...args )
    {
        return new Event( source, message, args );
    }

    public Context getSourceContext()
    {
        return sourceContext;
    }

    public String getSourceName()
    {
        return sourceName;
    }

    public String getMessage()
    {
        return message;
    }

    public Object[] getArgs()
    {
        return args;
    }

    public LocalDateTime getTime()
    {
        return time;
    }

    @Override
    public String toString()
    {
        return "Event{" +
                "sourceContext=" + sourceContext +
                ", sourceName='" + sourceName + '\'' +
                ", message='" + message + '\'' +
                ", args=" + Arrays.toString(args) +
                ", time=" + time +
                '}';
    }
}
