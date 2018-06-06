package io.cap.monitor;

import io.cap.Context;
import io.cap.Contextual;

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