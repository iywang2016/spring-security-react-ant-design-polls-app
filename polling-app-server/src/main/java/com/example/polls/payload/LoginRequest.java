package com.example.polls.payload;

import org.checkerframework.checker.confidential.qual.*;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank
    private @NonConfidential String usernameOrEmail;

    @NotBlank
    private @Confidential String password;

    public @NonConfidential String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public void setUsernameOrEmail(@NonConfidential String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    public @Confidential String getPassword() {
        return password;
    }

    public void setPassword(@Confidential String password) {
        this.password = password;
    }
}
