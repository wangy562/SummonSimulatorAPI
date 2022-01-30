package com.wangy562.SummonSimAPI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PermBannerController {

    private SummonItemRepository summonItemRepository;

    @Autowired
    public PermBannerController(SummonItemRepository summonItemRepository) {
        this.summonItemRepository = summonItemRepository;
    }


}
