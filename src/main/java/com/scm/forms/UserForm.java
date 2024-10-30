package com.scm.forms;


import lombok.*;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString


public class UserForm {
    //same as UserForm in the register.html

    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String about;
}
