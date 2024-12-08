package com.maharram.userloginregistration.model;

import com.maharram.userloginregistration.enums.Role;
import com.maharram.userloginregistration.token.Token;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
@Schema(description = "Entity representing a system user with related authentication and authorization details.")
public class User implements UserDetails {

    @Id
    @Schema(description = "A unique ID assigned to each user", example = "60c72b2f9b1e8e2f8f8f8f8f")
    private String id;

    @Schema(description = "The user's given name", example = "John")
    private String firstname;

    @Schema(description = "The user's family name", example = "Doe")
    private String lastname;

    @Schema(description = "Email address of the user, serving as their login identifier", example = "john.doe@example.com")
    private String email;

    @Schema(description = "Encrypted password of the user", example = "hashed_password")
    private String password;

    @Schema(description = "The user's role in the system (e.g., 'user', 'admin')", example = "user")
    private Role role;

    @Schema(description = "Collection of tokens linked to the user for managing active sessions.")
    private List<Token> tokens;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    @Schema(hidden = true)
    public String getPassword() {
        return password;
    }

    @Override
    @Schema(description = "The username used for login, which is the user's email address.")
    public String getUsername() {
        return email;
    }

    @Override
    @Schema(description = "Indicates if the account is active and not expired.", example = "true")
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @Schema(description = "Specifies whether the account is currently locked.", example = "true")
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @Schema(description = "Shows if the user's credentials are still valid.", example = "true")
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @Schema(description = "Confirms if the user's account is enabled.", example = "true")
    public boolean isEnabled() {
        return true;
    }
}
