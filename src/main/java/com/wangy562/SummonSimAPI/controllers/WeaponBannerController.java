package com.wangy562.SummonSimAPI.controllers;


import com.wangy562.SummonSimAPI.SummonItemRepository;
import com.wangy562.SummonSimAPI.SummonService;
import com.wangy562.SummonSimAPI.controllers.PermBannerController;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeaponBannerController extends PermBannerController {


    public WeaponBannerController(SummonItemRepository summonItemRepository, SummonService summonService) {
        super(summonItemRepository, summonService);
    }
}
