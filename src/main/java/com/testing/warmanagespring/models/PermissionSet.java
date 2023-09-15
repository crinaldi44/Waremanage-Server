package com.testing.warmanagespring.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="permission_sets")
public class PermissionSet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PermissionSet() {

    }
}
