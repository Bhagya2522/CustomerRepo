package customer.customerinfo.repository

import customer.customerinfo.model.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Repository interface for performing database operations on Customer entities
 */
@Repository
interface CustomerRepository : JpaRepository<Customer, Long>