package com.giri.validity

import groovy.util.logging.Log4j
import org.apache.commons.codec.language.Metaphone
import org.springframework.beans.factory.annotation.Value

/**
 * A concrete implementation of {@link AlgorithmTrait} using {@Metaphone}
 *
 * @author gpottepalem* Created on Feb 24, 2019
 */
@Log4j
class MetaPhoneAlgorithm implements AlgorithmTrait {

    final static Metaphone metaphone = new Metaphone()

    @Value('${maxCodecLength:3}')
    int maxCodecLength

    @Override
    String computePhoneticPhrase(Customer customer) {
        log.debug "maxCodecLength: $maxCodecLength"
        metaphone.setMaxCodeLen(maxCodecLength ?: 3)
        customer.phoneticPhrase = metaphone.metaphone(customer?.firstName) + metaphone.metaphone(customer?.lastName)
        customer.phoneticPhrase
    }

    @Override
    CustomerMatchResults processCustomers(List<Customer> customers) {
        CustomerMatchResults results = new CustomerMatchResults()
        results.groupedCustomers = customers.groupBy{ computePhoneticPhrase(it) }

        return results
    }

}
