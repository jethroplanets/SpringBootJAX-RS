package com.Demoproject.Demojaxrs.repository;

import com.Demoproject.Demojaxrs.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
