package com.lab8.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CustomerResponse (@NotNull long id,@NotBlank String name,@Email String email){
}
