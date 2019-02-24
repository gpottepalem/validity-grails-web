package com.giri.validity

import grails.converters.JSON
import grails.converters.XML

class CustomerController {

    CustomerProcessorService customerProcessorService

//    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        def results = customerProcessorService.processCustomerData()
        Map resultsResponseData =                 [
            potentialDuplicates: results.potentialDuplicateCustomers,
            nonDuplicates: results.nonDuplicates
        ]
        withFormat {
            html { resultsResponseData }
            json { render resultsResponseData as JSON }
            xml { render resultsResponseData as XML }
            '*' { resultsResponseData } // html
        }
    }

}
