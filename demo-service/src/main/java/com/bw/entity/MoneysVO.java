package com.bw.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
public class MoneysVO implements Serializable {
    //合同编号
    private String id;
    //类型
    private String type;
    //内容收款人
    private String huiName;

    //回款开始时间
    private Date huiTimestart;
    //汇款结束时间
    private Date huiTimeend;
    //余款
    private String propName;
    //最小余额
    private Integer startyue;
    //最大余额
    private Integer endyue;

    private Integer pageNum;
    private Integer pageSize;




}
