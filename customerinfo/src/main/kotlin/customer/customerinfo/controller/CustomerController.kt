package customer.customerinfo.controller

import customer.customerinfo.model.Customer
import customer.customerinfo.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * REST controller for handling customer-related endpoints
 */
@RestController
@RequestMapping("/api/customers")
class CustomerController(private val service: CustomerService) {

    /**
     * GET endpoint to retrieve a list of all customers
     * @return List of all customers in the database
     */
    @GetMapping
    fun getAllCustomers(): List<Customer> = service.getAllCustomers()

    /**
     * GET endpoint to retrieve a specific customer by ID
     * @param id the ID of the customer to retrieve
     * @return ResponseEntity containing the customer if found, or a 404 Not Found status if not
     */
    @GetMapping("/{id}")
    fun getCustomerById(@PathVariable id: Long): ResponseEntity<Customer> {
        val customer = service.getCustomerById(id)
        return if (customer != null) ResponseEntity.ok(customer)
        else ResponseEntity.notFound().build()
    }

    /**
     * POST endpoint to create a new customer
     * @param customer the customer object to create
     * @return the newly created customer
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody customer: Customer): Customer = service.createCustomer(customer)
}