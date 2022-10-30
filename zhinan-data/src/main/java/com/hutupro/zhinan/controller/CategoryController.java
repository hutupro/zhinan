package com.hutupro.zhinan.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hutupro.zhinan.model.Category;
import com.hutupro.zhinan.model.Collection;
import com.hutupro.zhinan.service.CategoryService;
import com.hutupro.zhinan.service.CollectionService;
import org.springframework.web.bind.annotation.*;

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

    @Resource
    private CollectionService collectionService;

    @RequestMapping(value = "/all-collect")
    public String getAllCollect() {
        List<Category> cates = categoryService.findAll();
        List<Collection> collections = collectionService.findAll();
        Map<String, List<Category>> categoryMap = new LinkedHashMap<String, List<Category>>();
        for (Collection collection : collections) {
            String collectionName = collection.getName();
            if (!categoryMap.containsKey(collectionName)) {
                categoryMap.put(collectionName, new LinkedList<Category>());
            }
        }
        for (Category category : cates) {
            String collection = category.getCollectionName();
            if (categoryMap.containsKey(collection)) {
                categoryMap.get(collection).add(category);
            }
            // 不在的丢弃
        }
        return new Gson().toJson(categoryMap);
    }

    @RequestMapping(value = "/all")
    public String getAll() {
        List<Category> colls = categoryService.findAll();
        return new Gson().toJson(colls);
    }

    @RequestMapping(value = "/delete")
    public String delete(@RequestParam("name") String name,
                         @RequestParam("collectionName") String collectionName) {
        int line = categoryService.deleteByKey(name, collectionName);
        return buildRes(line);
    }

    @PostMapping(value = "/save")
    public String save(@RequestBody Category category) {
        int line = categoryService.save(category);
        return buildRes(line);
    }

    private String buildRes(int line) {
        JsonObject jo = new JsonObject();
        jo.addProperty("code", line > 0 ? 1 : 0);
        jo.addProperty("message", "");
        return new Gson().toJson(jo);
    }

}
