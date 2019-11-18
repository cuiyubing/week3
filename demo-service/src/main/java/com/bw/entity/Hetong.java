package com.bw.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@Entity
@Table(name = "hetong")
public class Hetong implements Serializable {
    @Id
    @GeneratedValue
    private String id;
    private String uid;
    private Integer money;
    private String coment;

}
