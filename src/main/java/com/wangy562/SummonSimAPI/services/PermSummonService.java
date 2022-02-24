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

    public SummonItem summon(Integer pityCount, Integer fs) {
        /*
          Random counts from 0, so we must subtract 1 from the /1000 rates.
          3 star probability is 94.3%
          4 star probability is 5.1%
          5 star probability is 0.6%
          Randomly generates a number from 0 to 999, since this follows uniform distribution, the probability
          of getting a number in a range is exactly the size of the range / 1000 * 100%
         */
        int seed = random.nextInt(1000);
        int charOrWep = random.nextInt(2);  // 50% chance of getting either weapon or character
        int rarity;
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
        } else {
            if (seed <= 942) {
                rarity = 3;
            } else if (seed <= 993) {
                rarity = 4;
            } else {
                rarity = 5;
            }
        }
        // 4 star pity mechanic, if fs is 10 then it is guaranteed 4 star, otherwise the rate is increased to 20%
        if (rarity == 3 && fs >= 7 && fs < 10) {
            int fourStarSeed = random.nextInt(1000);
            if (fourStarSeed >= 788) {
                rarity = 4;
            }
        } else if (fs == 10) {
            rarity = 4;
        }
        // Edge case found: characters are only 4 star and above, if rarity is 3 then weapon is guaranteed
        String type = rarity == 3 ? "weapon" : (charOrWep == 0 ? "character" : "weapon");
        List<SummonItem> summonItems = summonItemRepository.findByRarityAndType(rarity, type);
        int listSize = summonItems.size();
        int index = random.nextInt(listSize);
        return summonItems.get(index);
    }
}
