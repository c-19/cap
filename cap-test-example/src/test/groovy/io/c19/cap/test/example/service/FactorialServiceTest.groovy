/*
 * Copyright (c) 2018 - 2018, C19, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 *
 */

package io.c19.cap.test.example.service

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class FactorialServiceTest extends Specification
{
    @Shared FactorialService factorialService = new FactorialService()

    @Unroll
    def "Calculate #n!"()
    {
        when:
        long actual = factorialService.calculate( n )

        then:
        actual == expected

        where:
        n  || expected
        0  || 1
        1  || 1
        2  || 2
        3  || 6
        4  || 24
        5  || 120
        6  || 720
        15 || 1307674368000
        20 || 2432902008176640000
    }

    def "Calculate negative throws IllegalArgumentException"()
    {
        given:
        long n = -1

        when:
        factorialService.calculate( n )

        then:
        thrown IllegalArgumentException
    }
}
