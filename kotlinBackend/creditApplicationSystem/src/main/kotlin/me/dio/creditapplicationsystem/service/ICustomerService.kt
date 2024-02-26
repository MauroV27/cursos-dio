package me.dio.creditapplicationsystem.service

import me.dio.creditapplicationsystem.entity.Customer

interface ICustomerService {

    fun save(customer:Customer) : Customer

    fun findByID( id: Long ) : Customer

    fun delete( id:Long )

}