package com.example.polls.payload;

import javax.validation.constraints.*;
import org.checkerframework.checker.confidential.qual.*;

public class SignUpRequest {
    @NotBlank
    @Size(min = 4, max = 40)
    private @NonConfidential String name;

    @NotBlank
    @Size(min = 3, max = 15)
    private @NonConfidential String username;

    @NotBlank
    @Size(max = 40)
    @Email
    private @NonConfidential String email;

    @NotBlank
    @Size(min = 6, max = 20)
    private @Confidential String password;

    public @NonConfidential String getName() {
        return name;
    }

    public void setName(@NonConfidential String name) {
        this.name = name;
    }

    public @NonConfidential String getUsername() {
        return username;
    }

    public void setUsername(@NonConfidential String username) {
        this.username = username;
    }

    public @NonConfidential String getEmail() {
        return email;
    }

    public void setEmail(@NonConfidential String email) {
        this.email = email;
    }

    public @Confidential String getPassword() {
        return password;
    }

    public void setPassword(@Confidential String password) {
        this.password = password;
    }
}
