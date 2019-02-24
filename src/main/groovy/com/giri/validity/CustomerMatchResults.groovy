package com.giri.validity

import com.giri.validity.Customer

/**
 * Holds results of processed customer records
 *
 * @author gpottepalem
 * Created on Feb 24, 2019
 */
class CustomerMatchResults {
    /**
     * Map of grouped {@link com.giri.validity.Customer}s with {@link com.giri.validity.Customer#phoneticPhrase} key, and list of customers with the same
     * {@link com.giri.validity.Customer#phoneticPhrase} as value
     * */
    Map<String, List<Customer>> groupedCustomers = [:].withDefault { [] }

    /**
     * Returns all potential duplicate customers found, returns only the first of each pair of potential duplicates
     * @return list of potential duplicate customers
     */
    List<Customer> getPotentialDuplicateCustomers() {
        groupedCustomers.findAll{ it.value.size() > 1 }.values()*.first()
    }

    /**
     * Returns all non-duplicate customers found
     * @return list of non-duplicate customers
     */
    List<Customer> getNonDuplicates() {
        groupedCustomers.findAll{ it.value.size() == 1 }.values()*.first()
    }
}
