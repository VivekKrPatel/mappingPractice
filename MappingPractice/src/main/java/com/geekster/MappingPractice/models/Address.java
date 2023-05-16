package com.geekster.MappingPractice.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {

    private String landmark;
    private Integer zipcode;
    private String district;
    private String state;
    private String country;
}
