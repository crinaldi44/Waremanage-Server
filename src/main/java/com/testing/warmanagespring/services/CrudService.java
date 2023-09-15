package com.testing.warmanagespring.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import javax.persistence.Id;
import java.util.Collection;

/**
 * A general class providing Create-Read-Update-Delete functionality that can be
 * leveraged by controllers.
 */
public abstract class CrudService<T> {

    protected JpaRepository<T, Id> repository;

    public CrudService(JpaRepository<T, Id> repository) {
        this.repository = repository;
    }

    public Collection<T> find() {
        return null;
    }

    public void delete(Id id) {
    }

    public void update() {

    }

    public void add() {

    }

}
