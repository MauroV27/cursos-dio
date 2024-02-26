package me.dio.creditapplicationsystem.utils

import me.dio.creditapplicationsystem.dto.CreditDTO
import me.dio.creditapplicationsystem.dto.CustomerDTO
import me.dio.creditapplicationsystem.dto.CustomerUpdateDTO
import me.dio.creditapplicationsystem.entity.Address
import me.dio.creditapplicationsystem.entity.Credit
import me.dio.creditapplicationsystem.entity.Customer
import me.dio.creditapplicationsystem.enummeration.Status
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

class BuilderFakeEntitys {

    companion object {
        fun builderCustomer(
                firstName: String = "Mauro",
                lastName: String = "Victor",
                cpf: String = "611.385.620-84",
                email: String = "mauro@teste.com",
                income: BigDecimal = BigDecimal.valueOf(1000.0),
                password: String = "1234",
                zipCode: String = "000000",
                street: String = "Rua A",
                id : Long = 1L
        ) = Customer(
                firstName = firstName,
                lastName = lastName,
                cpf = cpf,
                email = email,
                income = income,
                password = password,
                address = Address(
                        zipCode = zipCode,
                        street = street
                ),
                id = id
        )

        fun builderCredit(
                creditCode : UUID = UUID.randomUUID(),
                creditValue : BigDecimal = BigDecimal.ZERO,
                dayFirstInstallment: LocalDate = LocalDate.now(),
                numberOfInstallments: Int = 0,
                status: Status = Status.IN_PROGRESS,
                customer: Customer? = null,
                id : Long? = null
        ) = Credit(
                creditCode = creditCode,
                creditValue = creditValue,
                dayFirstInstallment = dayFirstInstallment,
                numberOfInstallments = numberOfInstallments,
                status = status,
                customer = customer,
                id = id
        )

        fun builderCreditDTO(
                numberOfInstallments: Int = 1,
                creditValue: BigDecimal = BigDecimal.valueOf(1000L),
                dayFirstOfInstallment: LocalDate = LocalDate.now(),
                customerId: Long = 1L
        ) = CreditDTO(
                numberOfInstallments = numberOfInstallments,
                creditValue =  creditValue,
                dayFirstOfInstallment = dayFirstOfInstallment,
                customerId = customerId
        )

        fun buildCustomerDTO(
                firstName: String = "Mauro",
                lastName: String = "Victor",
                cpf: String = "611.385.620-84",
                email: String = "mauro@teste.com",
                income: BigDecimal = BigDecimal.valueOf(1000.0),
                password: String = "1234",
                zipCode: String = "000000",
                street: String = "Rua A"
        ): CustomerDTO = CustomerDTO(
                firstName = firstName,
                lastName = lastName,
                cpf = cpf,
                email = email,
                password = password,
                income = income,
                zipCode = zipCode,
                street = street,
        )

        fun buildCustomerUpdateDTO(
                firstName: String = "Mauro Victor",
                lastName: String = "Dias",
                income: BigDecimal = BigDecimal.valueOf(5000.0),
                zipCode: String = "111111",
                street: String = "Rua B"
        ): CustomerUpdateDTO = CustomerUpdateDTO(
                firstName = firstName,
                lastName = lastName,
                income = income,
                zipCode = zipCode,
                street = street
        )
    }


}


