package com.giri.validity

import grails.testing.mixin.integration.Integration
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

/**
 * Specification for {@link CustomerProcessorService}
 *
 * @author gpottepalem
 * Created on Feb 24, 2019
 */
@Integration
class CustomerProcessorServiceSpec extends Specification {

    @Subject
    CustomerProcessorService customerProcessorService

    @Unroll
    void "Existing customer data file:#testFile contains #expectedRecords records"() {
        expect:
        customerProcessorService.loadCustomers(testFile).size() == expectedRecords

        where:
        testFile        || expectedRecords
        '/normal.csv'   || 106
        '/advanced.csv' || 109
    }

    void "When customer data file is processed, results get populated with data"() {
        when: 'customer data file is processed'
        CustomerMatchResults results = customerProcessorService.processCustomerData('/normal.csv')

        then: 'no exception occurs'
        noExceptionThrown()

        and: 'results contains customers'
        results.groupedCustomers.size() > 1
    }

    void "Non-existing customer data file should result in no customers in the result"() {
        when: 'non existing file is taken for processing'
        CustomerMatchResults results = customerProcessorService.processCustomerData('/not-found.csv')

        then: 'no exception occurs'
        noExceptionThrown()

        and: 'result should have 0 customers'
        results.groupedCustomers.size() == 0
    }
}
