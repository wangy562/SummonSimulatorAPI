package com.wangy562.SummonSimAPI;


import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeaponBannerController extends PermBannerController {

    public WeaponBannerController(SummonItemRepository summonItemRepository) {
        super(summonItemRepository);
    }

}
