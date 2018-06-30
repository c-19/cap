/*
 * Copyright (c) 2018 - 2018, C19, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 *
 */

package io.c19.cap.work.contract

import spock.lang.Shared
import spock.lang.Specification

class ContextContractItemTest extends Specification
{
    @Shared ContextContractItem instance
    @Shared String name = "name"
    @Shared String description = "description"

    def setup()
    {
        instance = new ContextContractItem( name, description )
    }

    def "type is Context"()
    {
        expect:
        instance.getType() == ContractItem.Type.CONTEXT
    }
}
