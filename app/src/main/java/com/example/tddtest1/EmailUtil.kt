package com.example.tddtest1

interface IEmailUtil {
    fun sendCustomer(email: String)
}

class EmailUtil : IEmailUtil {
    override fun sendCustomer(email: String) {

    }
}
