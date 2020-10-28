package com.Demoproject.Demojaxrs.rescource;


import com.Demoproject.Demojaxrs.exception.ResourceNotFoundException;
import com.Demoproject.Demojaxrs.model.Item;
import com.Demoproject.Demojaxrs.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/items")
@Produces (MediaType.APPLICATION_JSON)
public class ItemResource {

    @Autowired
    private final ItemRepository itemrepository;

    public ItemResource(ItemRepository itemrepository) {
        this.itemrepository = itemrepository;
    }

    // get all items api
    @GET
    @Path("/getallItems")
    @Produces (MediaType.APPLICATION_JSON)
    public List<Item> getallItems(){
        return this.itemrepository.findAll();

    }

    // get all items by id
    @GET
    @Path("/{id}")
    @Produces (MediaType.APPLICATION_JSON)
    public Item getItemById(@PathParam("id") long itemId ) {

        return this.itemrepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with this id"+ itemId));
    }

    // create items
    @POST
    @Path("/createItem")
    @Consumes({ MediaType.APPLICATION_JSON })
    public Item createItem(Item item) {

        return this.itemrepository.save(item);
    }
    // update items api

    @PUT
    @Path("/{id}")
    @Consumes({ MediaType.APPLICATION_JSON })
    public Item updateItem(Item item, @PathParam ("id") long itemId) {
        //		item is the new item created.
        //we first get the item from the database then update it... we are updating the existing item.
        Item existingItem = this.itemrepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with this id"+ itemId));
        // then update it
        existingItem.setCode(item.getCode());
        existingItem.setLevelDesc(item.getLevelDesc());
        return this.itemrepository.save(existingItem);
    }

    // delete items by id

    @DELETE
    @Path("/{id}")
    public ResponseEntity<Item> deleteItem(@PathParam ("id") long itemId){

        Item existingItem = this.itemrepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found from the database with this id"+ itemId));

        this.itemrepository.delete(existingItem);

        return ResponseEntity.ok().build();

    }



}
