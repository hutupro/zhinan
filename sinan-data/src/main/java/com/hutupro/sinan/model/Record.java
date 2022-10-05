package com.hutupro.sinan.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author hutupro
 * @since 2022/10/5
 */
@Data
@Entity(name = "record")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String info;
    private String collection;
    private String category;
    private String link;
    private String tag;
    private int weight;
}
