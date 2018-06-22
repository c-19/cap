/*
 * Copyright (c) 2018 - 2018, Chris Kelly, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 */

package io.c19.cap;

/**
 * Allow contextual information access.
 */
public interface Contextual extends Named
{
    /**
     * Retrieve the context information.
     */
    Context getContext( );

    /**
     * Update the context with the provided
     * context information.
     * @param context information
     */
    void setContext( Context context );
}
