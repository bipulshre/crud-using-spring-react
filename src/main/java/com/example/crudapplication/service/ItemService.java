package com.example.crudapplication.service;

import com.example.crudapplication.model.Item;
import com.example.crudapplication.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository repository;

    public ItemService(ItemRepository repository){
        this.repository = repository;
    }

    public List<Item> getAllItems() {
        return repository.findAll();
    }
    public Item getItemById(Long id){
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Item not found"));
    }

    public Item createItem(Item item){
       return repository.save(item);
    }

    public Item updateItem(Long id, Item updatedItem){
        Item item = getItemById(id);
        item.setName("mobile");
        item.setDescription("this is a mobile");
        return repository.save(item);
    }

    public void deleteItem(Long id){
        repository.deleteById(id);
    }
}
