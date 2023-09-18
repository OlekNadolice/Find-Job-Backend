package org.example.valueobjects;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode()
public class RegonNumber {

    private  final String regonNumber;


    public RegonNumber(String regonNumber) {
        this.regonNumber = regonNumber;
    }
}
