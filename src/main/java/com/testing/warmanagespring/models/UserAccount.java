package com.testing.warmanagespring.models;

import javax.persistence.*;

@Entity
@Table(name="user_account")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String username;

    private String password;

    private int privileges;

    public UserAccount() {

    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPrivileges() {
        return privileges;
    }

    public void setPrivileges(int rank) {
        this.privileges = rank;
    }
}
