package me.dio.creditapplicationsystem.service.impl

import me.dio.creditapplicationsystem.entity.Credit
import me.dio.creditapplicationsystem.exception.BusinessException
import me.dio.creditapplicationsystem.repository.CreditRepository
import me.dio.creditapplicationsystem.service.ICreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(
        private val creditRepository: CreditRepository,
        private val customerService: CustomerService
) : ICreditService {

    override fun save(credit: Credit): Credit {

        credit.apply {
            customer = customerService.findByID(credit.customer?.id!!)
        }

        return this.creditRepository.save(credit)
    }


    override fun findAllByCustomer(customerID: Long): List<Credit> = this.creditRepository.findAllByCustomerId(customerID)


    override fun findByCreditCode(customerID: Long, creditCode: UUID): Credit {
        val credit : Credit = this.creditRepository.findByCreditCode(creditCode) ?:
            throw BusinessException("Creditcode $creditCode not found")

        return if ( credit.customer?.id == customerID ) credit else throw IllegalArgumentException("Contact admin")
    }

}