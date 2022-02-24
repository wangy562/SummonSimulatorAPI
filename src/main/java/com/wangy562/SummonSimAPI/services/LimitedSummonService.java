package com.wangy562.SummonSimAPI.services;


import com.wangy562.SummonSimAPI.SummonItem;
import com.wangy562.SummonSimAPI.SummonItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LimitedSummonService {

    private SummonItemRepository summonItemRepository;

    @Autowired
    public LimitedSummonService(SummonItemRepository summonItemRepository) {
        this.summonItemRepository = summonItemRepository;
    }

    public SummonItem summon(Integer pityCount, Integer fs, Integer guarantee) {
        //TODO: Implement checks if the summoned drop is a promotional character
        return summonItemRepository.findByName("test");
    }
}
