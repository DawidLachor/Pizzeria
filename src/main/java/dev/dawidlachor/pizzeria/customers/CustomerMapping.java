package dev.dawidlachor.pizzeria.customers;

public class CustomerMapping {

    public static CustomerDto toDto(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setFirstName(customer.getUser().getFirstName());
        customerDto.setLastName(customer.getUser().getLastName());
        customerDto.setAddress(customer.getAddress());
        return customerDto;
    }
}
