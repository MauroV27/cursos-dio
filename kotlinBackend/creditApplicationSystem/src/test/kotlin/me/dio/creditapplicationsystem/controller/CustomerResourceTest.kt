package me.dio.creditapplicationsystem.controller

import com.fasterxml.jackson.databind.ObjectMapper
import me.dio.creditapplicationsystem.dto.CustomerDTO
import me.dio.creditapplicationsystem.dto.CustomerUpdateDTO
import me.dio.creditapplicationsystem.entity.Customer
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
class CustomerResourceTest {

    @Autowired private lateinit var customerRepository: CustomerRepository
    @Autowired private lateinit var mockMvc : MockMvc
    @Autowired private lateinit var objectMapper: ObjectMapper

    companion object{
        const val URL: String = "/api/customers"
    }

    @BeforeEach
    fun setup() = customerRepository.deleteAll()

    @AfterEach
    fun tearDown() = customerRepository.deleteAll()


    @Test
    fun `should create a customer and return 201 status`(){
        // given
        val customer: CustomerDTO = BuilderFakeEntitys.buildCustomerDTO()
        val valueAsString: String = objectMapper.writeValueAsString( customer ) // convert data to string

        // when & then
        mockMvc.perform(MockMvcRequestBuilders.post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(valueAsString))
                .andExpect(MockMvcResultMatchers.status().isCreated)
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value(customer.firstName))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value(customer.lastName))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cpf").value(customer.cpf))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(customer.email))
                .andExpect(MockMvcResultMatchers.jsonPath("$.income").value(customer.income))
                .andExpect(MockMvcResultMatchers.jsonPath("$.zipCode").value(customer.zipCode))
                .andExpect(MockMvcResultMatchers.jsonPath("$.street").value(customer.street))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value( 1L ))
                .andDo(MockMvcResultHandlers.print())

    }

    @Test
    fun `should not save a customer with same CPF and return 409 status`(){
        // given
        customerRepository.save( BuilderFakeEntitys.buildCustomerDTO().toEntity() )

        val customerDTO: CustomerDTO = BuilderFakeEntitys.buildCustomerDTO()
        val valueAsString: String = objectMapper.writeValueAsString(customerDTO)

        // then
        mockMvc.perform(MockMvcRequestBuilders.post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(valueAsString))
                .andExpect(MockMvcResultMatchers.status().isConflict)
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Conflict! Consult the documentation"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(409))
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.exception")
                                .value("class org.springframework.dao.DataIntegrityViolationException")
                )
                .andExpect(MockMvcResultMatchers.jsonPath("$.details[*]").isNotEmpty)
                .andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun `should not save a customer with firstName empty and return 400 status`(){
        // given
        val customerDTO: CustomerDTO = BuilderFakeEntitys.buildCustomerDTO(firstName = "")
        val valueAsString: String = objectMapper.writeValueAsString(customerDTO)

        mockMvc.perform(
                MockMvcRequestBuilders.post(URL)
                    .content(valueAsString)
                    .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest)
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Bad Request! Consult the documentation"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(400))
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.exception")
                                .value("class org.springframework.web.bind.MethodArgumentNotValidException")
                )
                .andExpect(MockMvcResultMatchers.jsonPath("$.details[*]").isNotEmpty)
                .andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun `should find customer by id and return status 200`(){
        // given :
        val customer : Customer = customerRepository.save( BuilderFakeEntitys.buildCustomerDTO().toEntity() )

        // when then
        mockMvc.perform(MockMvcRequestBuilders.get("$URL/${customer.id}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value(customer.firstName))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value(customer.lastName))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cpf").value(customer.cpf))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(customer.email))
                .andExpect(MockMvcResultMatchers.jsonPath("$.income").value(customer.income.toFloat()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.zipCode").value(customer.address.zipCode))
                .andExpect(MockMvcResultMatchers.jsonPath("$.street").value(customer.address.street))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value( customer.id ))
                .andDo(MockMvcResultHandlers.print())
    }


    @Test
    fun `should nout find customer with invalid id and return status 400`(){
        // given
        val invalidID : Long = 2L

        // when, then
        mockMvc.perform(MockMvcRequestBuilders.get("$URL/$invalidID")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest)
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Bad Request! Consult the documentation"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(400))
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.exception")
                                .value("class me.dio.creditapplicationsystem.exception.BusinessException")
                )
                .andExpect(MockMvcResultMatchers.jsonPath("$.details[*]").isNotEmpty)
                .andDo(MockMvcResultHandlers.print())
    }


    @Test
    fun `should delete customer by id and return status 204`(){
        // given
        val customer : Customer = customerRepository.save( BuilderFakeEntitys.buildCustomerDTO().toEntity() )

        // then
        mockMvc.perform(MockMvcRequestBuilders.delete("$URL/${customer.id}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent)
                .andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun `should not delete customer by id and return status 400`(){
        // given
        val invalidId : Long = 1L

        // then
        mockMvc.perform(MockMvcRequestBuilders.delete("$URL/$invalidId")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest)
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Bad Request! Consult the documentation"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(400))
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.exception")
                                .value("class me.dio.creditapplicationsystem.exception.BusinessException")
                )
                .andExpect(MockMvcResultMatchers.jsonPath("$.details[*]").isNotEmpty)
                .andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun `should update a customer and return status 200`(){
        // given
        val customer : Customer = customerRepository.save( BuilderFakeEntitys.buildCustomerDTO().toEntity() )
        val customerUpdDTO : CustomerUpdateDTO = BuilderFakeEntitys.buildCustomerUpdateDTO()
        val valueAsString: String = objectMapper.writeValueAsString(customerUpdDTO)

        mockMvc.perform(MockMvcRequestBuilders.patch("$URL?customerId=${customer.id}")
                .contentType(MediaType.APPLICATION_JSON)
                .content(valueAsString))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value(customerUpdDTO.firstName))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value(customerUpdDTO.lastName))
                .andExpect(MockMvcResultMatchers.jsonPath("$.income").value(customerUpdDTO.income.toFloat()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.zipCode").value(customerUpdDTO.zipCode))
                .andExpect(MockMvcResultMatchers.jsonPath("$.street").value(customerUpdDTO.street))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cpf").value(customer.cpf))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(customer.email))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value( customer.id ))
                .andDo(MockMvcResultHandlers.print())

    }

    @Test
    fun `should not update a customer with invalid id and return 400 status`(){
        // given
        val invalidID : Long = 2L
        val customerUpdDTO : CustomerUpdateDTO = BuilderFakeEntitys.buildCustomerUpdateDTO()
        val valueAsString: String = objectMapper.writeValueAsString(customerUpdDTO)

        mockMvc.perform(MockMvcRequestBuilders.patch("$URL?customerId=$invalidID")
                .contentType(MediaType.APPLICATION_JSON)
                .content(valueAsString))
                .andExpect(MockMvcResultMatchers.status().isBadRequest)
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Bad Request! Consult the documentation"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(400))
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.exception")
                                .value("class me.dio.creditapplicationsystem.exception.BusinessException")
                )
                .andExpect(MockMvcResultMatchers.jsonPath("$.details[*]").isNotEmpty)
                .andDo(MockMvcResultHandlers.print())


    }

}