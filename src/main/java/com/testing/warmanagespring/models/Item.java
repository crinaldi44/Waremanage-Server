package com.testing.warmanagespring.models;

import javax.persistence.*;

/**
 * An item is an entry into our inventory database. An item is represented by a unique
 * id and contains a name, description, and value.
 */
@Entity
@Table(name="inventory")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String description;

    private Double value;

    public Item() {

    }

    public int getId() { return id; }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
