package customer.customerinfo.service

import customer.customerinfo.model.Customer
import customer.customerinfo.repository.CustomerRepository
import org.springframework.stereotype.Service

/**
 * Service class for handling business logic related to customer operations
 */
@Service
class CustomerService(private val repository: CustomerRepository) {

    /**
     *  Retrieves all customers from the database
     *  @return List of all customers
     */
    fun getAllCustomers(): List<Customer> = repository.findAll()

    /**
     * Retrieves a customer by ID from the database
     * @param id the ID of the customer to retrieve
     * @return the customer if found, or null if not
     */
    fun getCustomerById(id: Long): Customer? = repository.findById(id).orElse(null)

    /**
     * Saves a new customer to the database
     * @param customer the customer object to save
     * @return the saved customer entity
     */
    fun createCustomer(customer: Customer): Customer = repository.save(customer)
}