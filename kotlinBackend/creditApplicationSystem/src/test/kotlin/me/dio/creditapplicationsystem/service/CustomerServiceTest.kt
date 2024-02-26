package me.dio.creditapplicationsystem.service

import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.just
import io.mockk.runs
import io.mockk.verify
import me.dio.creditapplicationsystem.entity.Customer
import me.dio.creditapplicationsystem.exception.BusinessException
import me.dio.creditapplicationsystem.repository.CustomerRepository
import me.dio.creditapplicationsystem.service.impl.CustomerService
import me.dio.creditapplicationsystem.utils.BuilderFakeEntitys
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ActiveProfiles
import java.util.*


@ActiveProfiles("test")
@ExtendWith(MockKExtension::class)
class CustomerServiceTest {

    @MockK lateinit var customerRepository: CustomerRepository
    @InjectMockKs lateinit var customerService: CustomerService

    @Test
    fun `should create customer`(){
        // given
        val fakeCustomer : Customer = BuilderFakeEntitys.builderCustomer()

        every {
            customerRepository.save(any())
        } returns fakeCustomer

        // when
        val actual : Customer = customerService.save(fakeCustomer)

        // then
        Assertions.assertThat(actual).isNotNull()
        Assertions.assertThat(actual).isSameAs(fakeCustomer)

        verify ( exactly = 1 ){ customerRepository.save(fakeCustomer)}
    }


    @Test
    fun `should find customer by id`(){
        // giver
        val fakeId : Long = Random().nextLong()
        val fakeCustomer : Customer = BuilderFakeEntitys.builderCustomer(id = fakeId)

        every { customerRepository.findById(fakeId) } returns Optional.of(fakeCustomer)

        // when
        val actual : Customer = customerService.findByID(fakeId)

        // then
        Assertions.assertThat(actual).isNotNull()
        Assertions.assertThat(actual).isExactlyInstanceOf(Customer::class.java)
        Assertions.assertThat(actual).isSameAs(fakeCustomer)
        verify(exactly = 1) { customerRepository.findById(fakeId) }
    }

    @Test
    fun `should not find customer by id and throws BusinessException`(){
        //given
        val fakeId: Long = Random().nextLong()
        every { customerRepository.findById(fakeId) } returns Optional.empty()

        // when and then
        Assertions.assertThatExceptionOfType(BusinessException::class.java)
                .isThrownBy { customerService.findByID(fakeId) }
                .withMessage("Id $fakeId not found!")
        verify(exactly = 1) { customerRepository.findById(fakeId) }
    }

    @Test
    fun `should delete customer by id`(){
        // given
        val fakeid : Long = Random().nextLong()
        val fakeCustomer : Customer = BuilderFakeEntitys.builderCustomer(id =  fakeid)
        every { customerRepository.findById(fakeid) } returns Optional.of(fakeCustomer)
        every { customerRepository.delete(fakeCustomer) } just runs

        // when
        customerService.delete(fakeid)

        // then
        verify (exactly = 1) { customerRepository.findById(fakeid) }
        verify (exactly = 1) { customerRepository.delete(fakeCustomer) }

    }



}