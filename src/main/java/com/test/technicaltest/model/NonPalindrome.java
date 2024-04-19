package com.test.technicaltest.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class NonPalindrome {
    @NotEmpty(message="Variabel s Tidak Boleh Kosong")
    private String s;

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
