package com.example.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * t_user
 * @author 
 */
@Data
public class User implements Serializable {
    private Integer id;

    private String username;

    private String password;

}