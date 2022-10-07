package com.hutupro.zhinan.service.impl;

import com.hutupro.zhinan.data.CategoryDao;
import com.hutupro.zhinan.model.Category;
import com.hutupro.zhinan.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hutupro
 * @since 2022/10/7
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryDao categoryDao;

    public List<Category> findAll() {
        return categoryDao.getAll();
    }
}
