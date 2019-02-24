# Overview
[![Build Status](https://travis-ci.org/gpottepalem/validity-grails-web.svg?branch=master)](https://travis-ci.org/gpottepalem/validity-grails-web)

This is a simple Gails 3 web application with one controller (`CustomerController`) with one action (`index`) which loads
a csv file with customer data, processes it and lists potential duplicates and non-duplicates found.

## Installation
Nothing really is needed.

## Running the app
Simply run the following command from the main project directory:  
`./grailsw run-app`  
or  
`./gradlew bootRun`

## Test the end-point
**End-point: `customer`**  
List customers data processed (html): `curl http://localhost:8080/customer`  
List customers data processed (json): `curl http://localhost:8080/customer?format=json`  
List customers data processed (xml) : `curl http://localhost:8080/customer?format=xml`  

## Tests
### Running
Simply run the following command from the main project directory to run all unit/integration/functional tests:  
`./grailsw clean`  
`./grailsw test-app`  
or  
`./gradlew clean test`
### Test Reports
Simply run the following command from the main project directory or point your browser to the following
`build/reports/...` directory:  
`open ./build/reports/tests/test/index.html`  