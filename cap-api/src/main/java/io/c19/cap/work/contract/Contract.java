/*
 * Copyright (c) 2018 - 2018, Chris Kelly, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 */

package io.c19.cap.work.contract;

import io.c19.cap.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Immutable definition of expected items in the {@link Input}, {@link Output} and {@link Context}.
 */
public final class Contract
{
    private final List<ContractItem> inputs;
    private final List<ContractItem> outputs;
    private final List<ContractItem> contexts;

    private Contract( List<ContractItem> inputs, List<ContractItem> outputs, List<ContractItem> contexts )
    {
        this.inputs = inputs;
        this.outputs = outputs;
        this.contexts = contexts;
    }

    /**
     * Builder to create Contract instance.
     *
     * @return empty builder instance.
     */
    public static Builder newBuilder()
    {
        return new Builder();
    }

    /**
     * Get all defined input items.
     *
     * @return input contract items.
     */
    public List<ContractItem> getInput()
    {
        return new ArrayList<>( inputs );
    }

    /**
     * Get all defined output items.
     *
     * @return output contract items.
     */
    public List<ContractItem> getOutput()
    {
        return new ArrayList<>( outputs );
    }

    /**
     * Get all defined context items.
     *
     * @return context contract items.
     */
    public List<ContractItem> getContext()
    {
        return new ArrayList<>( contexts );
    }

    public static class Builder
    {
        private List<ContractItem> input = new ArrayList<>();
        private List<ContractItem> output = new ArrayList<>();
        private List<ContractItem> context = new ArrayList<>();

        public Builder input(ContractItem...inputs )
        {
            this.input.addAll( Arrays.asList( inputs ) );
            return this;
        }

        public Builder output(ContractItem...outputs )
        {
            this.output.addAll( Arrays.asList( outputs ) );
            return this;
        }

        public Builder context( ContractItem...inputs )
        {
            this.context.addAll( Arrays.asList( inputs ) );
            return this;
        }

        public Contract build()
        {
            return new Contract( input, output, context );
        }
    }
}
