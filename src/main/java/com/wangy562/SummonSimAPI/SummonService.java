package com.wangy562.SummonSimAPI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SummonService {

    private SummonItemRepository summonItemRepository;
    private Random random;

    @Autowired
    public SummonService(SummonItemRepository summonItemRepository) {
        this.summonItemRepository = summonItemRepository;
        this.random = new Random();
    }

    public SummonItem summon(Integer pityCount) {
        int seed = random.nextInt(100);
        return summonItemRepository.findByName("test");
    }
}
