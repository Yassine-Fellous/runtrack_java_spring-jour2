package com.example.demo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Personne {
    @Min(value = 0)
    public int age = 0;
    @NotBlank
    public String name = "";
}
