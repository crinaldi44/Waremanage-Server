package com.testing.warmanagespring.models;

import javax.persistence.*;

@Entity
@Table(name="permission_sets")
public class PermissionSet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public PermissionSet() {

    }
}
