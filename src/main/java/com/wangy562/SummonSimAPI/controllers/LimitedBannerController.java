package com.wangy562.SummonSimAPI.controllers;


import com.wangy562.SummonSimAPI.SummonItemRepository;
import com.wangy562.SummonSimAPI.services.LimitedSummonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitedBannerController {

    private SummonItemRepository summonItemRepository;
    private LimitedSummonService limitedSummonService;

    @Autowired
    public LimitedBannerController(SummonItemRepository summonItemRepository,
                                   LimitedSummonService limitedSummonService) {
        this.summonItemRepository = summonItemRepository;
        this.limitedSummonService = limitedSummonService;
    }
}
