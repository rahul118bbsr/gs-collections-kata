/*
 * Copyright 2011 Goldman Sachs.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gs.collections.kata;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;

import org.junit.Assert;
import org.junit.Test;

import static java.util.stream.Collectors.toList;

public class Exercise6Test extends CompanyDomainForKata
{
    @Test
    public void filterOrderValues()
    {
        List<Order> orders = this.company.getMostRecentCustomer().getOrders();
        /**
         * Same exercise but don't use static utility - refactor the type of orders and {@link Customer#getOrders()}
         * instead.
         * Get the order values that are greater than 1.5.
         */
        DoubleStream filteredValues = orders.stream().map(Order::getValue).filter(x -> x > 1.5);
        Assert.assertTrue(filteredValues.allMatch(value -> {
            long longValue = Double.doubleToLongBits(value);
            return longValue == Double.doubleToLongBits(372.5) || longValue == Double.doubleToLongBits(1.75);
        }));
    }

    @Test
    public void filterOrders()
    {
        List<Order> orders = this.company.getMostRecentCustomer().getOrders();
        /**
         * Same exercise but don't use static utility - refactor the type of orders and {@link Customer#getOrders()}
         * instead.
         * Get the actual orders (not their double values) where those orders have a value greater than 2.0.
         */
        List<Order> filtered = orders.stream().filter(order -> order.getValue() > 2.0).collect(toList());
        Assert.assertEquals(Arrays.asList(this.company.getMostRecentCustomer().getOrders().stream().findFirst().get()), filtered);
    }
}
