package org.example.valueobjects;


import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode()
public class NipNumber {
    private  final String nipNumber;


    public NipNumber(String nipNumber) {
        this.nipNumber = nipNumber;
    }



}
