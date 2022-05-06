package com.example.tddtest1

class MockEmailUtil : IEmailUtil {
    var receiveEmail: String = ""
    override fun sendCustomer(email: String) {
        receiveEmail = email
    }
}