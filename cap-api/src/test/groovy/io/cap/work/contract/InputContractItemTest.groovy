/*
 * Copyright (c) 2018 - 2018, Chris Kelly, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 */

package io.cap.work.contract

import spock.lang.Shared
import spock.lang.Specification

class InputContractItemTest extends Specification
{
    @Shared InputContractItem instance
    @Shared String name = "name"
    @Shared String description = "description"

    def setup()
    {
        instance = new InputContractItem( name, description )
    }

    def "type is Context"()
    {
        expect:
        instance.getType() == ContractItem.Type.INPUT
    }
}
