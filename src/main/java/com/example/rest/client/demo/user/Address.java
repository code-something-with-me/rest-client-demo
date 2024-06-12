package com.example.rest.client.demo;

public record Address(
        String street,
        String suite,
        String city,
        String zipcode,
        Geo geo) {

}

