package dev.dawidlachor.pizzeria.mapping;

import dev.dawidlachor.pizzeria.model.Customer;
import dev.dawidlachor.pizzeria.dto.CustomerDto;

public class CustomerMapping {

    public static CustomerDto toDto(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setFirstName(customer.getUser().getFirstName());
        customerDto.setLastName(customer.getUser().getLastName());
        customerDto.setAddress(customer.getAddress());
        return customerDto;
    }
}
