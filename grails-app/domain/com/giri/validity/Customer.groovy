package com.giri.validity

/**
 * Customer domain object, holds details of a customer
 *
 * @author gpottepalem
 * Created on Feb 24, 2019
 */
class Customer {
    int loadedId
    String firstName
    String lastName
    String company
    String email
    String address1
    String address2
    String zip
    String city
    String state
    String stateCode
    String phone

    /** Computed phonetic phrase */
    transient String phoneticPhrase

    String getName() {
        firstName + lastName
    }

    @Override
    String toString() {
        return "$loadedId,$firstName,$lastName,$company,$email,$address1$address2,$zip,$city,$state,$stateCode,$phone"
    }

    static constraints = {
    }
}
