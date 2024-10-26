package customer.customerinfo.service

import customer.customerinfo.model.Customer
import customer.customerinfo.repository.CustomerRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
class CustomerServiceTest {

    @Mock
    private lateinit var repository: CustomerRepository

    @InjectMocks
    private lateinit var service: CustomerService

    @BeforeEach
    fun setup() {
        service = CustomerService(repository)
    }

    @Test
    fun `should return all customers`() {
        `when`(repository.findAll()).thenReturn(listOf(
            Customer(firstName = "Adhrit", lastName = "Mane", dob = "adhrit.mane@gmail.com"),
            Customer(firstName = "Bhagya", lastName = "Jadhav", dob = "bhagya.jadhav@gmail.com")
        ))

        val customers = service.getAllCustomers()
        assertEquals(2, customers.size)
    }

    @Test
    fun `should find customer by ID`() {
        val customer = Customer(id = 1, firstName = "Adhrit", lastName = "Mane", dob = "adhrit.mane@gmail.com")
        `when`(repository.findById(1)).thenReturn(Optional.of(customer))

        val foundCustomer = service.getCustomerById(1)
        assertNotNull(foundCustomer)
        assertEquals(customer.dob, foundCustomer?.dob)
    }

    @Test
    fun `should create a customer`() {
        val customer = Customer(firstName = "Lakshmi", lastName = "Jadhav", dob = "lakshmi.jadhav@gmail.com")
        `when`(repository.save(customer)).thenReturn(customer)

        val createdCustomer = service.createCustomer(customer)
        assertNotNull(createdCustomer)
        assertEquals(customer.dob, createdCustomer.dob)
    }
}