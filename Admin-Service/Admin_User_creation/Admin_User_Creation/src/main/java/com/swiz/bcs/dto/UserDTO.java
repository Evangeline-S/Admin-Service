package com.swiz.bcs.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int id;
    private String userName;
    private String password;
    private String email;
    private Boolean isactive;

    // getters and setters
}
