package com.example.tddtest1

class Order {

    fun insertOrder(email: String, quantity:Int, price: Int, emailUtil: IEmailUtil){
        val weather = Weather()
        val umbrella = Umbrella()
        umbrella.totalPrice(weather, quantity, price)

        //寄送Email給使用者
        emailUtil.sendCustomer(email)
    }
}