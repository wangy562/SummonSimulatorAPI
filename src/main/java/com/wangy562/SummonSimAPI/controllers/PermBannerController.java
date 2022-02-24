package com.wangy562.SummonSimAPI.controllers;

import java.util.ArrayList;
import java.util.List;

import com.wangy562.SummonSimAPI.SummonItem;
import com.wangy562.SummonSimAPI.SummonItemRepository;
import com.wangy562.SummonSimAPI.services.PermSummonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/permBanner")
@CrossOrigin(origins = "http://localhost:3000")
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
    public SummonItem summonSingle(@RequestParam Integer pity, @RequestParam Integer fs) {
        // Increment pity on client side
        return permSummonService.summon(pity, fs);
    }

    @GetMapping("/multi")
    @ResponseBody
    public List<SummonItem> summonMulti(@RequestParam Integer pity, @RequestParam Integer fs) {
        // need to increment pity here for calculations
        Integer pityIncrement = pity;
        Integer fsIncrement = fs;
        List<SummonItem> summonItems = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            summonItems.add(permSummonService.summon(pityIncrement, fsIncrement));
            fsIncrement++;
            pityIncrement++;
        }
        return summonItems;
    }

    @GetMapping("/allItems")
    public List<SummonItem> getAll() {
        return summonItemRepository.findAll();
    }

    @GetMapping("/getByName")
    public SummonItem getByName(@RequestParam String name) {
        return summonItemRepository.findByName(name);
    }

    @GetMapping("/getByRarity")
    public List<SummonItem> getByRarity(@RequestParam Integer rarity) {
        return summonItemRepository.findByRarity(rarity);
    }

    @GetMapping("/getByType")
    public List<SummonItem> getByType(@RequestParam String type) {
        return summonItemRepository.findByType(type);
    }

    @GetMapping("/getByRarityAndType")
    public List<SummonItem> getByRarityAndType(@RequestParam Integer rarity, @RequestParam String type) {
        return summonItemRepository.findByRarityAndType(rarity, type);
    }

    @PostMapping("/addToPool")
    public void addSummonItem(@RequestBody SummonItem summonItem) {
        if (summonItemRepository.findByName(summonItem.getName()) == null) {
            summonItemRepository.save(summonItem);
        }
    }

    @DeleteMapping("/deleteFromPool")
    @ResponseBody
    public Long deleteSummonItemByName(@RequestParam String name) {
        return summonItemRepository.deleteByName(name);
    }
}
