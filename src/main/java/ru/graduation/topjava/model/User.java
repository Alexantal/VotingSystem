package ru.graduation.topjava.model;

import java.util.Date;
import java.util.Set;

public class User extends AbstractNamedEntity {

    private String email;
    private String password;
    private Date registered;
    private Set<Role> roles;

    public User() {
    }

}
