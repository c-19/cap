/*
 * Copyright (c) 2018 - 2018, Chris Kelly, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 */

package io.cap.work.contract;

/**
 * {@link ContractItem} that is defined within the {@link Output}.
 */
public final class OutputContractItem extends AbstractContractItem
{
    public OutputContractItem(String name, String description )
    {
        super( name, Type.OUTPUT, description );
    }
}
