package com.hutupro.zhinan.service;

import com.hutupro.zhinan.model.Category;

import java.util.List;

/**
 * @author hutupro
 * @since 2022/10/7
 */
public interface CategoryService {
    List<Category> findAll();
}
