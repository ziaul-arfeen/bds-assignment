package com.example.demo.service;

import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Optional<Item> getItemById(String id) {
        return itemRepository.findById(id);
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Optional<Item> updateItem(String id, Item updatedItem) {
        return itemRepository.findById(id).map(item -> {
            item.setName(updatedItem.getName());
            item.setPrice(updatedItem.getPrice());
            return itemRepository.save(item);
        });
    }

    public void deleteItem(String id) {
        itemRepository.deleteById(id);
    }
}
