/*
 * Copyright (c) 2018 - 2018, Chris Kelly, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 */

package io.cap.work.contract;

/**
 * {@link ContractItem} that is defined within the {@link io.cap.Context}.
 */
public final class ContextContractItem extends AbstractContractItem
{
    public ContextContractItem(String name, String description )
    {
        super( name, Type.CONTEXT, description );
    }
}
