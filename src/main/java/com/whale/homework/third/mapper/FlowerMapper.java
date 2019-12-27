package com.whale.homework.third.mapper;

import com.whale.homework.third.entity.Flower;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface FlowerMapper extends Mapper<Flower> {
    @Select("select * from flower where fname like #{keyword}")
    List<Flower> searchKey(@Param("keyword") String keyword);
}
