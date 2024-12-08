package com.example.crudapplication.controller;

import com.example.crudapplication.model.Item;
import com.example.crudapplication.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/items")
@CrossOrigin(origins = "http://localhost:3000")
public class ItemController {

    public final ItemService service;

    public ItemController(ItemService service){
        this.service = service;
    }
    @GetMapping
    public List<Item> getAllItems() {
        return service.getAllItems();
    }

    @GetMapping("/{id}")
    public Item getItem(@PathVariable Long id) {
        return service.getItemById(id);
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return service.createItem(item);
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item item) {
        return service.updateItem(id, item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable String id) {

        service.deleteItem(Long.parseLong(id));
    }

}
