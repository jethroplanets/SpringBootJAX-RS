package com.Demoproject.Demojaxrs.service;

import com.Demoproject.Demojaxrs.exception.ResourceNotFoundException;
import com.Demoproject.Demojaxrs.model.Item;
import com.Demoproject.Demojaxrs.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import javax.ws.rs.PathParam;
import java.util.List;

@Service
@Transactional
public class ItemService {

    @Autowired
    ItemRepository itemrepository;

    public Item getItemById(long itemId ){
        return  itemrepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with this id"+ itemId));

    }
    public List<Item> getallItems(){
        return itemrepository.findAll();

    }

    public Item createItem(Item item) {
        return this.itemrepository.save(item);
    }






}
