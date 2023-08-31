package com.swiz.bcs.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDTO {
    private String userName;
    private String password;
    private String email;

    // getters and setters
}