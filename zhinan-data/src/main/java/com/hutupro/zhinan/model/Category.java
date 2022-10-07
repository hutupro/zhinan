package com.hutupro.zhinan.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

/**
 * Composite-id class must implement Serializable.
 *
 * @author hutupro
 * @since 2022/10/7
 */
@Data
@IdClass(Category.CategoryPK.class)
@Entity(name = "category")
public class Category implements Serializable {

    private static final long serialVersionUID = 2881913186573188465L;
    @Id
    private String name;
    @Id
    @Column(name="collection_name")
    private String collectionName;
    private String info;
    private int weight;

    static class CategoryPK implements Serializable {
        private static final long serialVersionUID = -5914294540372930199L;
        private String name;
        private String collectionName;
    }
}
