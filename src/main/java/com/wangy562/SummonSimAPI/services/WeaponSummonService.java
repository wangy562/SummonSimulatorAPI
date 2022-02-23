package com.wangy562.SummonSimAPI.services;


import com.wangy562.SummonSimAPI.SummonItem;
import com.wangy562.SummonSimAPI.SummonItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeaponSummonService {

    private SummonItemRepository summonItemRepository;
    private Boolean epitomized;  // after 2 non-epitmoized items, guarantee the item drop

    @Autowired
    public WeaponSummonService(SummonItemRepository summonItemRepository, Integer epitmoized) {
        this.summonItemRepository = summonItemRepository;
        this.epitomized = epitomized;
    }

    public SummonItem summon(Integer pityCount, Integer epitomized2) {
        return null;
    }
}
