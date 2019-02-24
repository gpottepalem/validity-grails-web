package com.giri.validity
/**
 * Algorithm trait, defines interface for all supported algorithms
 *
 * @author gpottepalem
 * Created on Feb 24, 2019
 */
trait AlgorithmTrait {
    /**
     * Computes, sets and returns phonetic phrase for a given customer.
     * Default implementation simply uses {@Customer#firstName} and {@link com.giri.validity.Customer#lastName} as phoneticPhrase
     * @param customer
     * @return phonetic phrase
     */
    String computePhoneticPhrase(Customer customer) {
        customer.phoneticPhrase = customer.firstName + customer.lastName
        customer.phoneticPhrase
    }

    /**
     * Given a list of customers, it processes and populates results
     * @param customers list of customers
     * @return the result
     */
    abstract CustomerMatchResults processCustomers(List<Customer> customers)
}
