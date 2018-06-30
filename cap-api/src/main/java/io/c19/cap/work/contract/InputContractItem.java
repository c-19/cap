/*
 * Copyright (c) 2018 - 2018, C19, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 *
 */

package io.c19.cap.work.contract;

/**
 * {@link ContractItem} that is defined within the {@link Input}.
 */
public final class InputContractItem extends AbstractContractItem
{
    public InputContractItem(String name, String description )
    {
        super( name, Type.INPUT, description );
    }
}
