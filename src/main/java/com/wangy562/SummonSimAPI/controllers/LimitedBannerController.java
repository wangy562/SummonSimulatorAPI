package com.wangy562.SummonSimAPI.controllers;


import com.wangy562.SummonSimAPI.SummonItem;
import com.wangy562.SummonSimAPI.SummonItemRepository;
import com.wangy562.SummonSimAPI.services.LimitedSummonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/limitedBanner")
public class LimitedBannerController {

    private SummonItemRepository summonItemRepository;
    private LimitedSummonService limitedSummonService;

    @Autowired
    public LimitedBannerController(SummonItemRepository summonItemRepository,
                                   LimitedSummonService limitedSummonService) {
        this.summonItemRepository = summonItemRepository;
        this.limitedSummonService = limitedSummonService;
    }

    @GetMapping("/summon")
    @ResponseBody
    public SummonItem summonSingle(@RequestBody HashMap<String, Integer> pity) {
        Integer pityCount = pity.get("pity");
        Integer guarantee = pity.get("guarantee");  // either 0 or 1 for guaranteed limited character
        return limitedSummonService.summon(pityCount, guarantee);
    }

    @GetMapping("/multi")
    @ResponseBody
    public List<SummonItem> summonMulti(@RequestBody HashMap<String, Integer> pity) {
        Integer pityCount = pity.get("pity");
        Integer guarantee = pity.get("guarantee");  // either 0 or 1 for guaranteed limited character
        List<SummonItem> summonItems = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            summonItems.add(limitedSummonService.summon(pityCount, guarantee));
            pityCount++;
        }
        return summonItems;
    }
}
