package com.wangy562.SummonSimAPI.services;


import com.wangy562.SummonSimAPI.SummonItem;
import com.wangy562.SummonSimAPI.SummonItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeaponSummonService {

    private SummonItemRepository summonItemRepository;

    @Autowired
    public WeaponSummonService(SummonItemRepository summonItemRepository) {
        this.summonItemRepository = summonItemRepository;
    }

    public SummonItem summon(Integer pityCount, Integer epitomized) {
        return null;
    }
}
