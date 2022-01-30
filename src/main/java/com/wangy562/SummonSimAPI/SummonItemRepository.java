package com.wangy562.SummonSimAPI;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SummonItemRepository extends MongoRepository<SummonItem, String> {

    SummonItem findByName(String name);

    List<SummonItem> findByRarity(Integer rarity);

    List<SummonItem> findByType(String type);
}
