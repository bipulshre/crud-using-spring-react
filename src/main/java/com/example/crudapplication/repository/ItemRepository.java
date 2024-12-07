package com.example.crudapplication.repository;

import com.example.crudapplication.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("select i from Item i where i.name = ?1")
    List<Item> findByName(String name);
}
