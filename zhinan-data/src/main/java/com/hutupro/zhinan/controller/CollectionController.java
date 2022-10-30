package com.hutupro.zhinan.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hutupro.zhinan.model.Category;
import com.hutupro.zhinan.model.Collection;
import com.hutupro.zhinan.service.CollectionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.naming.Name;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author hutupro
 * @since 2022/10/5
 */
@RestController
@RequestMapping("/collection")
public class CollectionController {
    @Resource
    private CollectionService collectionService;

    @RequestMapping(value = "/all")
    public String getAll() {
        List<Collection> colls = collectionService.findAll();
        return new Gson().toJson(colls);
    }

    @RequestMapping(value = "/delete")
    public String delete(@RequestParam("name") String name) {
        int line = collectionService.deleteByName(name);
        return buildRes(line);
    }

    @PostMapping(value = "/save")
    public String save(@RequestBody Collection collection) {
        int line = collectionService.save(collection);
        return buildRes(line);
    }

    private String buildRes(int line) {
        JsonObject jo = new JsonObject();
        jo.addProperty("code", line > 0 ? 1 : 0);
        jo.addProperty("message", "");
        return new Gson().toJson(jo);
    }

}
