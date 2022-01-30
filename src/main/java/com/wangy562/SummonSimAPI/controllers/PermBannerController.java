package com.wangy562.SummonSimAPI.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.wangy562.SummonSimAPI.SummonItem;
import com.wangy562.SummonSimAPI.SummonItemRepository;
import com.wangy562.SummonSimAPI.SummonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PermBannerController {

    private SummonItemRepository summonItemRepository;
    private SummonService summonService;

    @Autowired
    public PermBannerController(SummonItemRepository summonItemRepository, SummonService summonService) {
        this.summonItemRepository = summonItemRepository;
        this.summonService = summonService;
    }

    @GetMapping
    @ResponseBody
    public SummonItem summonSingle(@RequestBody HashMap<String, Integer> pity) {
        Integer pityCount = pity.get("pity");
        return summonService.summon(pityCount);
    }

    @GetMapping
    @ResponseBody
    public List<SummonItem> summonMulti(@RequestBody HashMap<String, Integer> pity) {
        // need to increment pity here for calculations
        Integer pityCount = pity.get("pity");
        List<SummonItem> summonItems = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            pityCount++;
            summonItems.add(summonService.summon(pityCount));
        }
        return summonItems;
    }

    @PostMapping
    public void addSummonItem(@RequestBody SummonItem summonItem) {
        summonItemRepository.save(summonItem);
    }

    @DeleteMapping
    public void deleteSummonItemByName(@RequestBody SummonItem summonItem) {
        summonItemRepository.delete(summonItem);
    }
}
