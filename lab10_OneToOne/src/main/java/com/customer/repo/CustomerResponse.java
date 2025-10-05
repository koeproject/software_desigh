package com.customer.repo;

public record CustomerResponse(Long id,String name,String email,AddressResponse address) {

}
