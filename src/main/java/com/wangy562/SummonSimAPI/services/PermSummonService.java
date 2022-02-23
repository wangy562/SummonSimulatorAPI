package com.wangy562.SummonSimAPI.services;


import com.wangy562.SummonSimAPI.SummonItem;
import com.wangy562.SummonSimAPI.SummonItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PermSummonService {

    private SummonItemRepository summonItemRepository;
    private Random random;

    @Autowired
    public PermSummonService(SummonItemRepository summonItemRepository) {
        this.summonItemRepository = summonItemRepository;
        this.random = new Random();
    }

    public SummonItem summon(Integer pityCount) {
        /**
         * Random counts from 0, so we must subtract 1 from the /1000 rates.
         * 3 star probability is 94.3%
         * 4 star probability is 5.1%
         * 5 star probability is 0.6%
         * Randomly generates a number from 0 to 999, since this follows uniform distribution, the probability
         * of getting a number in a range is exactly the size of the range / 1000 * 100%
         */
        int seed = random.nextInt(1000);
        int charOrWep = random.nextInt(2);  // 50% chance of getting either weapon or character
        int rarity = 0;
        if (pityCount == 90) {  // 90 pity guarantees a 5 star
            rarity = 5;
        } else if (pityCount >= 75) {
            if (seed <= 742) {
                rarity = 3;
            } else if (seed <= 793) {
                rarity = 4;
            } else {
                rarity = 5;
            }
        }
        else {
            if (seed <= 942) {
                rarity = 3;
            } else if (seed <= 993) {
                rarity = 4;
            } else {
                rarity = 5;
            }
        }
        String type = charOrWep == 0 ? "character" : "weapon";
        List<SummonItem> summonItems = summonItemRepository.findByRarityAndType(rarity, type);
        //TODO: Test this method again after populating the DB with wish objects
        int index = random.nextInt(summonItems.size());
        return summonItems.get(index);
    }
}
