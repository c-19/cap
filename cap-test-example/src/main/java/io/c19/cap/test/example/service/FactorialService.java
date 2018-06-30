/*
 * Copyright (c) 2018 - 2018, C19, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 *
 */

package io.c19.cap.test.example.service;

/**
 * Factorial calculating service.
 */
public class FactorialService
{
    /**
     * Calculate the factorial of the given
     * positive integer.
     *
     * @param n to calculate factorial for.
     * @return n!
     */
    public long calculate( final long n )
    {
        if( n < 0 )
        {
            throw new IllegalArgumentException( "Factorial cannot be calculated for negative numbers." );
        }
        long result = 1;
        long current = n;
        while( current > 0 )
        {
            result *= current;
            current--;
        }
        return result;
    }
}
