package com.wangy562.SummonSimAPI.controllers;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.wangy562.SummonSimAPI.SummonItem;
import com.wangy562.SummonSimAPI.services.WeaponSummonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weaponBanner")
public class WeaponBannerController {

    private WeaponSummonService weaponSummonService;

    @Autowired
    public WeaponBannerController(WeaponSummonService weaponSummonService) {
        this.weaponSummonService = weaponSummonService;
    }

    @GetMapping("/summon")
    @ResponseBody
    public SummonItem summonSingle(@RequestBody HashMap<String, Integer> pity) {
        Integer pityCount = pity.get("pity");
        Integer epitomized = pity.get("epitomized");  // 0 or 1 or 2for epitomized path
        return weaponSummonService.summon(pityCount, epitomized);
    }

    @GetMapping("/multi")
    @ResponseBody
    public List<SummonItem> summonMulti(@RequestBody HashMap<String, Integer> pity) {
        Integer pityCount = pity.get("pity");
        Integer epitomized = pity.get("epitomized");  // 0 or 1 or 2 for epitomized path
        List<SummonItem> summonItems = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            summonItems.add(weaponSummonService.summon(pityCount, epitomized));
            pityCount++;
        }
        return summonItems;
    }
}
