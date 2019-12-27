package com.whale.homework.third.entity;


import javax.persistence.Id;

public class Comment {
    @Id
    private Integer id;
    private Integer flowerid;
    private Integer userid;
    private String content;
    private Long createtime;

    public Integer getFlowerid() {
        return flowerid;
    }

    public void setFlowerid(Integer flowerid) {
        this.flowerid = flowerid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }
}
