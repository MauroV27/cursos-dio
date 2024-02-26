package me.dio.creditapplicationsystem.service.impl

import me.dio.creditapplicationsystem.entity.Customer
import me.dio.creditapplicationsystem.exception.BusinessException
import me.dio.creditapplicationsystem.repository.CustomerRepository
import me.dio.creditapplicationsystem.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(
        private val customerRepository: CustomerRepository
) : ICustomerService{

    override fun save(customer: Customer): Customer = this.customerRepository.save(customer)


    override fun findByID(id: Long): Customer {
        return this.customerRepository.findById(id).orElseThrow{
            throw BusinessException("Id $id not found!")
        }
    }

    override fun delete(id: Long) {
        val customer: Customer = this.findByID(id)
        this.customerRepository.delete(customer)
    }

}