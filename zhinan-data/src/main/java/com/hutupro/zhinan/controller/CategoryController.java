package com.hutupro.zhinan.controller;

import com.google.gson.Gson;
import com.hutupro.zhinan.model.Category;
import com.hutupro.zhinan.service.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author hutupro
 * @since 2022/10/5
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    @RequestMapping(value = "/all")
    public String getAllCollect() {
        List<Category> cates = categoryService.findAll();
        Map<String, List<Category>> categoryMap = new LinkedHashMap<String, List<Category>>();
        for (final Category category : cates) {
            String collection = category.getCollectionName();
            if (categoryMap.containsKey(collection)) {
                categoryMap.get(collection).add(category);
            } else {
                LinkedList<Category> tmp = new LinkedList<Category>();
                tmp.add(category);
                categoryMap.put(collection, tmp);
            }
        }
        return new Gson().toJson(categoryMap);
    }

}
