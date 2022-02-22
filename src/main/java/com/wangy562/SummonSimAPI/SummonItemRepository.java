package com.wangy562.SummonSimAPI;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SummonItemRepository extends MongoRepository<SummonItem, String> {

    SummonItem findByName(String name);

    List<SummonItem> findByRarity(Integer rarity);

    List<SummonItem> findByType(String type);

    List<SummonItem> findByRarityAndType(Integer rarity, String type);
    // TODO: check functionality of this query
}
