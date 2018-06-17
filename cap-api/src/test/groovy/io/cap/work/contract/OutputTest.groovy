/*
 * Copyright (c) 2018 - 2018, Chris Kelly, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 */

package io.cap.work.contract

import spock.lang.Specification

class OutputTest extends Specification
{
    def "Copy constructor"()
    {
        given:
        Output instance = new Output()
        instance.put( "key", "value" )

        when:
        Output actual = new Output( instance )

        then:
        actual == instance

        when:
        instance.put( "key", "value2" )

        then:
        actual != instance
    }
}
