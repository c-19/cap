/*
 * Copyright (c) 2018 - 2018, Chris Kelly, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 */

package io.c19.cap.work.contract

import spock.lang.Specification

class InputTest extends Specification
{
    def "Copy constructor"()
    {
        given:
        Input instance = new Input()
        instance.put( "key", "value" )

        when:
        Input actual = new Input( instance )

        then:
        actual == instance

        when:
        instance.put( "key", "value2" )

        then:
        actual != instance
    }
}
