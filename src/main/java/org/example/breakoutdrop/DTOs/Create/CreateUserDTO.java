package org.example.breakoutdrop.DTOs.Create;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.example.breakoutdrop.Enums.Role;
import org.hibernate.validator.constraints.URL;

import java.util.HashSet;
import java.util.Set;

public record CreateUserDTO(
        @NotNull String name,
        @NotNull String password,
        @NotNull @Email String email,
        @NotNull @URL String tradeURL,
        Set<Role> roles
) {
    public CreateUserDTO() {
        this("", "", "", "", HashSet.newHashSet(0));
    }
}
