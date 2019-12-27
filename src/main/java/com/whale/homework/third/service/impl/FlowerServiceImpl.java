package com.whale.homework.third.service.impl;


import com.whale.homework.third.entity.Flower;
import com.whale.homework.third.mapper.FlowerMapper;
import com.whale.homework.third.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Map;

@Service
public class FlowerServiceImpl implements FlowerService {

    @Autowired
    FlowerMapper flowerMapper;

    public void turnPage(int id, ModelMap map) {

    }
}
