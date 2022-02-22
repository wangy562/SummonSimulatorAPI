package com.wangy562.SummonSimAPI.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.wangy562.SummonSimAPI.SummonItem;
import com.wangy562.SummonSimAPI.SummonItemRepository;
import com.wangy562.SummonSimAPI.services.PermSummonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/permBanner")
public class PermBannerController {

    private SummonItemRepository summonItemRepository;
    private PermSummonService permSummonService;

    @Autowired
    public PermBannerController(SummonItemRepository summonItemRepository, PermSummonService permSummonService) {
        this.summonItemRepository = summonItemRepository;
        this.permSummonService = permSummonService;
    }

    @GetMapping("/summon")
    @ResponseBody
    public SummonItem summonSingle(@RequestBody HashMap<String, Integer> pity) {
        // Increment pity on client side
        Integer pityCount = pity.get("pity");
        return permSummonService.summon(pityCount);
    }

    @GetMapping("/multi")
    @ResponseBody
    public List<SummonItem> summonMulti(@RequestBody HashMap<String, Integer> pity) {
        // need to increment pity here for calculations
        Integer pityCount = pity.get("pity");
        List<SummonItem> summonItems = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            summonItems.add(permSummonService.summon(pityCount));
            pityCount++;
        }
        return summonItems;
    }

    @PostMapping("/addToPool")
    public void addSummonItem(@RequestBody SummonItem summonItem) {
        summonItemRepository.save(summonItem);
    }

    @DeleteMapping("/deleteFromPool")
    public void deleteSummonItemByName(@RequestBody SummonItem summonItem) {
        summonItemRepository.delete(summonItem);
    }
}
