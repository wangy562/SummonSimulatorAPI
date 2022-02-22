package com.wangy562.SummonSimAPI.controllers;


import com.wangy562.SummonSimAPI.SummonItemRepository;
import com.wangy562.SummonSimAPI.services.WeaponSummonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weaponBanner")
public class WeaponBannerController {

    private SummonItemRepository summonItemRepository;
    private WeaponSummonService weaponSummonService;

    @Autowired
    public WeaponBannerController(SummonItemRepository summonItemRepository, WeaponSummonService weaponSummonService) {
        this.summonItemRepository = summonItemRepository;
        this.weaponSummonService = weaponSummonService;
    }
}
