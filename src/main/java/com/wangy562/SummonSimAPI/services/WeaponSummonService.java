package com.wangy562.SummonSimAPI.services;


import com.wangy562.SummonSimAPI.SummonItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeaponSummonService {

    private SummonItemRepository summonItemRepository;
    private String epitomized;  // after 2 non-epitmoized items, guarantee the item drop

    @Autowired
    public WeaponSummonService(SummonItemRepository summonItemRepository) {
        this.summonItemRepository = summonItemRepository;
        this.epitomized = "";
    }
}
