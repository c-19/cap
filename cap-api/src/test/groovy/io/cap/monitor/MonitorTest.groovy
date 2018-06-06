package io.cap.monitor

import io.cap.work.BasicOperation
import spock.lang.Shared
import spock.lang.Specification

class MonitorTest extends Specification
{
    @Shared Monitor instance
    @Shared BasicObserver observer

    def setup()
    {
        observer = new BasicObserver()
        instance = new Monitor()
        instance.addObserver( observer )
    }

    def "Get observer size"()
    {
        instance.getObserverSize() == 1
    }

    def "Remove observer"()
    {
        when:
        instance.removeObserver( observer )

        then:
        instance.getObserverSize() == 0
    }

    def "Register event is sent to observers"()
    {
        given:
        Event e = Event.of( new BasicOperation(), "hello" )

        when:
        instance.register( e )

        then:
        observer.event == e
    }


    class BasicObserver implements EventObserver
    {
        Event event

        @Override
        void observe(Event event)
        {
            this.event = event
        }
    }
}
