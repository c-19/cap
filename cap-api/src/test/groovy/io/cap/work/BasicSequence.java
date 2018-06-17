/*
 * Copyright (c) 2018 - 2018, Chris Kelly, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 */

package io.cap.work;

import io.cap.work.contract.Contract;

/**
 * Basic Sequence.
 */
public class BasicSequence extends AbstractSequence
{

    @Override
    public Contract getContract()
    {
        return Contract.newBuilder().build();
    }
}
