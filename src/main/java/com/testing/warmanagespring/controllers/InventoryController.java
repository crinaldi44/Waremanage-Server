package com.testing.warmanagespring.controllers;

import com.testing.warmanagespring.exception.ResourceNotFoundException;
import com.testing.warmanagespring.models.Item;
import com.testing.warmanagespring.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    ItemRepository itemRepository;

    @GetMapping(path="")
    public List<Item> getItem(@RequestParam(value="name", required = false) String name) throws ResourceNotFoundException {

        if (name == null) {
            return itemRepository.findAll();
        }

        List<Item> i = itemRepository.findAll();
        List<Item> found = i.stream().filter(item -> item.getName().equals(name)).collect(Collectors.toList());

        if (found.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return found;
    }

    @GetMapping("/{id}")
    public Item getItem(@PathVariable int id) {

        Optional<Item> i = itemRepository.findById(id);

        return i.orElseGet(Item::new);

    }

    @PostMapping(consumes = "application/json")
    public Item createItem(@RequestBody Item newItem) {
        return itemRepository.save(newItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable int id) throws ResourceNotFoundException {

        Item i = itemRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        itemRepository.delete(i);

        return ResponseEntity.ok().build();

    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable int id, @RequestBody Item newItem) throws ResourceNotFoundException {
        Item i = itemRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        i.setName(newItem.getName());
        i.setDescription(newItem.getDescription());
        i.setValue(newItem.getValue());

        return itemRepository.save(i);
    }

}
