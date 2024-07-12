package com.lwn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginBean {
    private String jwt;
    private List<Rights> rights;

    public static LoginBean getLoginBean(String jwt, List<Rights> rights) {
        return new LoginBean(jwt, rights);
    }
}
