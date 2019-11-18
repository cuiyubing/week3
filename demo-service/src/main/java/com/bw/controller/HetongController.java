package com.bw.controller;

import com.bw.entity.Moneys;
import com.bw.entity.MoneysVO;
import com.bw.service.HetongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@CrossOrigin
public class HetongController {
    @Autowired
    private HetongService hetongService;
    //列表
    @GetMapping("list")
    public Page<Moneys> getList(MoneysVO moneysVO){
        return hetongService.selectMoneyList(moneysVO);
    }
}
