package com.maharram.userloginregistration.controller;

import com.maharram.userloginregistration.dto.ChangePasswordRequest;
import com.maharram.userloginregistration.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @Operation(
            summary = "Update user password",
            description = "Enables users to update their password by submitting the current password and the desired new password."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Password was updated successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid data provided or the passwords do not match."),
            @ApiResponse(responseCode = "401", description = "Access denied. The user must log in to proceed."),
            @ApiResponse(responseCode = "500", description = "Unexpected server error occurred.")
    })
    @PatchMapping
    public ResponseEntity<?> changePassword(
            @RequestBody @Parameter(description = "Payload containing the current and new passwords.") ChangePasswordRequest request,
            @Parameter(description = "The currently authenticated user attempting the password update.") Principal connectedUser
    ) {
        service.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }
}
