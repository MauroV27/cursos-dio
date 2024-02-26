package me.dio.creditapplicationsystem.controller

import com.fasterxml.jackson.databind.ObjectMapper
import me.dio.creditapplicationsystem.dto.CreditDTO
import me.dio.creditapplicationsystem.entity.Credit
import me.dio.creditapplicationsystem.entity.Customer
import me.dio.creditapplicationsystem.repository.CreditRepository
import me.dio.creditapplicationsystem.repository.CustomerRepository
import me.dio.creditapplicationsystem.utils.BuilderFakeEntitys
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@ContextConfiguration
class CreditResourceTest {

    @Autowired private lateinit var mockMvc : MockMvc
    @Autowired private lateinit var objectMapper: ObjectMapper
    @Autowired private lateinit var creditRepository: CreditRepository
    @Autowired private lateinit var customerRepository: CustomerRepository

    companion object{
        const val URL: String = "/api/credits"
    }

    @BeforeEach fun setup() = creditRepository.deleteAll()

    @AfterEach fun tearDown() = creditRepository.deleteAll()

    @Test
    fun `should save credit and return status 201`(){
        // given
        val customerId : Long = 1L
        customerRepository.save( BuilderFakeEntitys.builderCustomer(id = customerId) )
        val creditDTO : CreditDTO = BuilderFakeEntitys.builderCreditDTO( customerId = customerId )
        val valueAsString: String = objectMapper.writeValueAsString(creditDTO)

        // then
        mockMvc.perform(
                MockMvcRequestBuilders.post(URL)
                    .content(valueAsString)
                    .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isCreated)
                .andExpect(MockMvcResultMatchers.jsonPath("$.creditValue").value(creditDTO.creditValue))
                .andExpect(MockMvcResultMatchers.jsonPath("$.numberOfInstallment").value(creditDTO.numberOfInstallments))
                .andDo(MockMvcResultHandlers.print())

    }
}