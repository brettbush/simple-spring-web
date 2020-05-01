package com.brettbush.simplespringweb.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @Generated
    private Long id;
    private String name;
    private String username;
    private String userType;

}
