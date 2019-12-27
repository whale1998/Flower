package com.whale.homework.third.entity;

import javax.persistence.Id;

public class Flower {
    @Id
    private Integer fid;
    private String fname;
    private String fcontent;
    private String fmean;
    private String ftitle;


    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFmean() {
        return fmean;
    }

    public void setFmean(String fmean) {
        this.fmean = fmean;
    }

    public String getFtitle() {
        return ftitle;
    }

    public void setFtitle(String ftitle) {
        this.ftitle = ftitle;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFcontent() {
        return fcontent;
    }

    public void setFcontent(String fcontent) {
        this.fcontent = fcontent;
    }

}
