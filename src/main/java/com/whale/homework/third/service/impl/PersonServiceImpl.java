package com.whale.homework.third.service.impl;

import com.whale.homework.third.entity.Collections;
import com.whale.homework.third.entity.Flower;
import com.whale.homework.third.mapper.CollectionsMapper;
import com.whale.homework.third.mapper.FlowerMapper;
import com.whale.homework.third.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    FlowerMapper flowerMapper;
    @Autowired
    CollectionsMapper collectionsMapper;

    //    展示收藏
    public List<Flower> showcollection(Integer userid) {
        List<Flower> flowers=new ArrayList<>();
        Example example = new Example(Collections.class);
        example.and().andEqualTo("userid",userid);
        List<Collections> collections = collectionsMapper.selectByExample(example);
        for (Collections collection : collections) {
            Integer fid = collection.getFid();
            Flower flower = flowerMapper.selectByPrimaryKey(fid);
            flowers.add(flower);
        }
        return flowers;
    }

    //    删除收藏
    public void deletecol(Integer userId, String fid) {
        Example example = new Example(Collections.class);
        example.and().andEqualTo("userid",userId).andEqualTo("fid",fid);
        collectionsMapper.deleteByExample(example);
    }
}
