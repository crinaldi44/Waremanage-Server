package com.testing.warmanagespring.repositories;

import com.testing.warmanagespring.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
