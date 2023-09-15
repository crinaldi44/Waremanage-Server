package com.testing.warmanagespring.models;

import org.springframework.lang.NonNull;

import javax.persistence.*;

/**
 * A user account is a profile accessed by an end-user and is identified by a unique ID.
 * Users are given a unique username, password, and associated privilege level.
 */
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NonNull
    @Column(unique = true)
    private String username;

    @NonNull
    @Column(unique = true)
    private String email;

    private String password;

    private String streetAddress1;

    private String streetAddress2;

    private String addressCity;

    private String addressState;

    private String addressZip;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "permissionSetId", referencedColumnName = "id")
    private PermissionSet permissionSet;

    public User() {
        this.username = "";
        this.password = "";
        this.email = "";
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

    public String getAddressCity() {
        return addressCity;
    }

    public String getStreetAddress1() {
        return streetAddress1;
    }

    public String getStreetAddress2() {
        return streetAddress2;
    }

    public String getAddressState() {
        return addressState;
    }

    public String getAddressZip() {
        return addressZip;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PermissionSet getPermissionSet() {
        return this.permissionSet;
    }

    public void setPermissionSet(PermissionSet rank) {
        this.permissionSet = rank;
    }

    public void setStreetAddress1(String streetAddress1) {
        this.streetAddress1 = streetAddress1;
    }

    public void setStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    public void setAddressZip(String addressZip) {
        this.addressZip = addressZip;
    }


}
