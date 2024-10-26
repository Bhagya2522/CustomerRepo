package customer.customerinfo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Main application entry point for the Spring Boot application
 */
@SpringBootApplication
class CustomerinfoApplication

fun main(args: Array<String>) {
	runApplication<CustomerinfoApplication>(*args)
}
