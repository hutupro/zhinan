package com.hutupro.zhinan.service.impl;

import com.hutupro.zhinan.data.CategoryDao;
import com.hutupro.zhinan.model.Category;
import com.hutupro.zhinan.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public int deleteByKey(String name, String collectionName) {
        return categoryDao.deleteByNameAndCollectionName(name, collectionName);
    }

    public int save(Category category) {
        Category save = categoryDao.save(category);
        return save == null? 0 : 1;
    }
}
