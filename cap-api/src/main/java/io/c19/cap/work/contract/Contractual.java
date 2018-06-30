/*
 * Copyright (c) 2018 - 2018, C19, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 *
 */

package io.c19.cap.work.contract;

/**
 * Object which implements a defined {@link Contract} for interaction.
 */
public interface Contractual
{
    /**
     * Retrieve the defined {@link Contract}.
     *
     * @return defined contract .
     */
    Contract getContract();
}
