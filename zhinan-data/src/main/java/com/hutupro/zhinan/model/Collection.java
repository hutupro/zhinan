package com.hutupro.zhinan.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author hutupro
 * @since 2022/10/7
 */
@Data
@Entity(name = "collection")
public class Collection {
    @Id
    private String name;
    private String info;
    private int weight;
}
