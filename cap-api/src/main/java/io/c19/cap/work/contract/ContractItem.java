/*
 * Copyright (c) 2018 - 2018, C19, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 *
 */

package io.c19.cap.work.contract;

/**
 * Defines expected items within a {@link Contract}.
 */
public interface ContractItem
{
    /**
     * Expected type/ location of the item.
     */
    enum Type
    {
        INPUT,
        OUTPUT,
        CONTEXT
    }
    /**
     * Named key for expected item.
     *
     * @return name of the key
     */
    String getName();

    /**
     * Type of key, determines where key will be located.
     *
     * @return type of key
     */
    Type getType();

    /**
     * Description of the use of this key.
     *
     * @return description of the key.
     */
    String getDescription();
}
