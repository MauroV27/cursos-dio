package me.dio.creditapplicationsystem.service

import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import me.dio.creditapplicationsystem.entity.Credit
import me.dio.creditapplicationsystem.entity.Customer
import me.dio.creditapplicationsystem.repository.CreditRepository
import me.dio.creditapplicationsystem.repository.CustomerRepository
import me.dio.creditapplicationsystem.service.impl.CreditService
import me.dio.creditapplicationsystem.service.impl.CustomerService
import me.dio.creditapplicationsystem.utils.BuilderFakeEntitys
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ActiveProfiles


@ActiveProfiles("test")
@ExtendWith(MockKExtension::class)
class CreditServiceTest {

    @MockK lateinit var customerService: CustomerService
    @MockK lateinit var creditRepository: CreditRepository
    @InjectMockKs lateinit var creditService: CreditService


    @Test
    fun `should create credit`(){
        // given
        val fakeCustomer : Customer = BuilderFakeEntitys.builderCustomer()
        val fakeCredit : Credit = BuilderFakeEntitys.builderCredit(customer = fakeCustomer)

        every { customerService.findByID(1L) } returns fakeCustomer

        every {
            creditRepository.save(any())
        } returns fakeCredit

        // when
        val actual : Credit = creditService.save(fakeCredit)

        // then
        Assertions.assertThat(actual).isNotNull()
        Assertions.assertThat(actual).isSameAs(fakeCredit)

        verify ( exactly = 1 ){ creditRepository.save(fakeCredit) }
    }




}