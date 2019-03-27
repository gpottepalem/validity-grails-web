package com.giri.validity

import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.apache.commons.csv.CSVRecord

/**
 * Provides implementation for loading and processing customer data.
 *
 * @author gpottepalem
 * Created on Feb 24, 2019
 */
class CustomerProcessorService {

    MetaPhoneAlgorithm metaPhoneAlgorithm

    /**
     * Loads customers from the given csv file
     * @param customersDataFile optional, defaulted to process normal.csv file found in the classpath
     * @return list of customers loaded, sorted by firstName, lastName, phone, email
     */
    List<Customer> loadCustomers(String customersDataFile = '/normal.csv') {
        log.info "loading customer data from file:$customersDataFile"

        List<Customer> customers = []
        this.class.getResource(customersDataFile)?.withReader { Reader reader ->
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())
            for(CSVRecord csvRecord in csvParser.iterator()) {
                customers << new Customer(
                        loadedId: csvRecord.get(0) as int, //glitch
                        firstName: csvRecord.get('first_name'),
                        lastName: csvRecord.get('last_name'),
                        company: csvRecord.get('company'),
                        email: csvRecord.get('email'),
                        address1: csvRecord.get('address1'),
                        address2: csvRecord.get('address2'),
                        zip: csvRecord.get('zip'),
                        city: csvRecord.get('city'),
                        state: csvRecord.get('state_long'),
                        stateCode: csvRecord.get('state'),
                        phone: csvRecord.get('phone')
                )
            }
        }
        log.info "successfully loaded customers:${customers.size()}"
        return customers.sort {a, b ->
            a.firstName <=> b.firstName ?: a.lastName <=> b.lastName ?: a.phone <=> b.phone ?: a.email <=> b.email
        }
    }

    /**
     * Processes customers loaded from the given file and returns results
     * @param customersDataFile optional, defaulted to process normal.csv file found in the classpath
     * @return results
     */
    CustomerMatchResults processCustomerData(String customersDataFile = '/normal.csv') {
        log.info "processing customer data"
        List<Customer> customers = loadCustomers(customersDataFile)
        return metaPhoneAlgorithm.processCustomers(customers)
    }

}
