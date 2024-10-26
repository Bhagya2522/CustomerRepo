package customer.customerinfo.controller

import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import com.fasterxml.jackson.databind.ObjectMapper
import customer.customerinfo.model.Customer
import customer.customerinfo.service.CustomerService

@WebMvcTest(CustomerController::class)
class CustomerControllerTest @Autowired constructor(
    val mockMvc: MockMvc
) {

    @MockBean
    private lateinit var service: CustomerService

    private val objectMapper = ObjectMapper()

    @Test
    fun `should get all customers`() {
        `when`(service.getAllCustomers()).thenReturn(listOf(
            Customer(firstName = "Adhrit", lastName = "Mane", dob = "adhrit.mane@gmail.com"),
            Customer(firstName = "Bhagya", lastName = "Jadhav", dob = "bhagya.jadhav@gmail.com")
        ))

        mockMvc.perform(get("/api/customers"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.length()").value(2))
    }

    @Test
    fun `should get customer by ID`() {
        val customer = Customer(id = 1, firstName = "Adhrit", lastName = "Mane", dob = "adhrit.mane@gmail.com")
        `when`(service.getCustomerById(1)).thenReturn(customer)

        mockMvc.perform(get("/api/customers/1"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.dob").value("adhrit.mane@gmail.com"))
    }

    @Test
    fun `should create customer`() {
        val customer = Customer(firstName = "Lakshmi", lastName = "Jadhav", dob = "lakshmi.jadhav@gmail.com")
        `when`(service.createCustomer(customer)).thenReturn(customer)

        mockMvc.perform(post("/api/customers")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(customer)))
            .andExpect(status().isCreated)
            .andExpect(jsonPath("$.dob").value("lakshmi.jadhav@gmail.com"))
    }
}