package org.pdp.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Person {
    private String name;
    private String gender;
    private String address;
    private String postcode;
}
