package com.bw.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "moneys")
public class Moneys implements Serializable {
    @Id
    @GeneratedValue
    private String id;
    private Integer money;
    private Integer yue;
    private String huiId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date huiTime;
    private Integer huiMoney;
    private String huiName;
    private String coment;

}
