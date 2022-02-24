package com.wangy562.SummonSimAPI.controllers;


import com.wangy562.SummonSimAPI.SummonItem;
import com.wangy562.SummonSimAPI.services.LimitedSummonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/limitedBanner")
public class LimitedBannerController {

    private LimitedSummonService limitedSummonService;

    @Autowired
    public LimitedBannerController(LimitedSummonService limitedSummonService) {
        this.limitedSummonService = limitedSummonService;
    }

    @GetMapping("/summon")
    @ResponseBody
    public SummonItem summonSingle(@RequestParam Integer pity, @RequestParam Integer fs, @RequestParam Integer guarantee) {
        return limitedSummonService.summon(pity, guarantee, guarantee);
    }

    @GetMapping("/multi")
    @ResponseBody
    public List<SummonItem> summonMulti(@RequestParam Integer pity, @RequestParam Integer fs, @RequestParam Integer guarantee) {
        Integer pityIncrement = pity;
        Integer fsIncrement = fs;
        Integer gIncrement = guarantee;
        List<SummonItem> summonItems = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            SummonItem summoned = limitedSummonService.summon(pityIncrement, fsIncrement, gIncrement);
            summonItems.add(summoned);
            Integer itemRarity = summoned.getRarity();
            if (fsIncrement == 10 || itemRarity == 4) {
                fsIncrement = 0;
            } else {
                fsIncrement++;
            }
            if (itemRarity == 5) {
                pityIncrement = 0;
            } else {
                pityIncrement++;
            }
        }
        return summonItems;
    }
}
