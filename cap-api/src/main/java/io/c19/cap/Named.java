/*
 * Copyright (c) 2018 - 2018, Chris Kelly, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 */

package io.c19.cap;

/**
 * Naming heirarchy for objects.
 */
public interface Named
{
    /**
     * Name of the parent to this object.
     * @return parent name
     */
    String getParentName();

    /**
     * Set the name of the parent to this object.
     * @param name parent name
     */
    void setParentName( String name );

    /**
     * Name of this object.
     * @return name
     */
    String getName();

    /**
     * Set the name of this object.
     * @param name object name
     */
    void setName( String name );

    /**
     * Return the qualified name as
     * parent.name
     * @return fully qualified name.
     */
    String getFullyQualifiedName();
}
