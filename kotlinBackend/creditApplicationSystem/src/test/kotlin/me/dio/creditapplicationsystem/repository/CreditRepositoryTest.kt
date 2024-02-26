package me.dio.creditapplicationsystem.repository

import me.dio.creditapplicationsystem.entity.Credit
import me.dio.creditapplicationsystem.entity.Customer
import me.dio.creditapplicationsystem.utils.BuilderFakeEntitys
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.ActiveProfiles
import java.util.*

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CreditRepositoryTest {

    @Autowired lateinit var creditRepository: CreditRepository
    @Autowired lateinit var testEntityManager: TestEntityManager

    private lateinit var customer: Customer
    private lateinit var credit1: Credit
    private lateinit var credit2: Credit

    @BeforeEach
    fun setup(){
        val fakeCustomer : Customer = BuilderFakeEntitys.builderCustomer()
        customer = testEntityManager.persist( fakeCustomer )
        credit1 = testEntityManager.persist( BuilderFakeEntitys.builderCredit( customer = fakeCustomer ) )
        credit2 = testEntityManager.persist( BuilderFakeEntitys.builderCredit( customer = fakeCustomer ) )
    }

    @Test
    fun `should find credit by credit code`() {
        // given
//        val creditCode1 = UUID.fromString("a867335e-a29e-4135-86da-e56631c322d1")
//        val creditCode2 = UUID.fromString("ac673a2f-0fd4-43b9-813d-f9f000d7d802")
//
//        this.credit1.creditCode = creditCode1
//        this.credit2.creditCode = creditCode2

        // when
        val fakeCredit1: Credit? = creditRepository.findByCreditCode( credit1.creditCode )
        val fakeCredit2: Credit? = creditRepository.findByCreditCode( credit2.creditCode )

        Assertions.assertThat(fakeCredit1).isNotNull
        Assertions.assertThat(fakeCredit2).isNotNull
        Assertions.assertThat(fakeCredit1).isSameAs(credit1)
        Assertions.assertThat(fakeCredit2).isSameAs(credit2)
    }

    @Test
    fun `should find all credits by customer id`(){
        // given
        val customerId: Long = 1

        // when
        val creditList: List<Credit> = creditRepository.findAllByCustomerId( customerId )

        // then
        Assertions.assertThat(creditList).isNotEmpty
        Assertions.assertThat(creditList.size).isEqualTo(2)
        Assertions.assertThat(creditList).contains(credit1, credit2)
    }
}