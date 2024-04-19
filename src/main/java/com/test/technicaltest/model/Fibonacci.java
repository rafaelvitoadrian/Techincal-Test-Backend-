package com.test.technicaltest.model;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class Fibonacci {
//    @NotEmpty(message="Nilai tidak boleh kosong")
    @NotNull(message = "Nilai tidak boleh kosong")
    @Min(value = 0,message = "Nilai harus bilangan bulat positif")
    @Digits(integer = 10, fraction = 0)
    private BigDecimal n;

    public int getN() {
        return this.n.intValue();
    }

    public void setN(BigDecimal n) {
        this.n = n;
    }
}
