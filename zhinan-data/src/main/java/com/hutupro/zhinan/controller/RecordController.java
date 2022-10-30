package com.hutupro.zhinan.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hutupro.zhinan.model.Record;
import com.hutupro.zhinan.service.RecordService;
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
@RequestMapping("/record")
public class RecordController {
    @Resource
    private RecordService recordService;

    @RequestMapping(value = "/getall")
    public String index() {
        List<Record> records = recordService.findAll();
        return new Gson().toJson(records);
    }

    @RequestMapping(value = "/get-all-collect")
    public String getAllCollect() {
        List<Record> records = recordService.findAll();
        Map<String, Map<String, List<Record>>> collects = new LinkedHashMap<String, Map<String, List<Record>>>();
        for (final Record record : records) {
            String collection = record.getCollection();
            final String category = record.getCategory();
            if (collects.containsKey(collection)) {
                if (collects.get(collection).containsKey(category)) {
                    collects.get(collection).get(category).add(record);
                } else {
                    LinkedList<Record> tmp = new LinkedList<Record>();
                    tmp.add(record);
                    collects.get(collection).put(category, tmp);
                }
            } else {
                LinkedHashMap<String, List<Record>> tmpMap = new LinkedHashMap<String, List<Record>>();
                LinkedList<Record> tmp = new LinkedList<Record>();
                tmp.add(record);
                tmpMap.put(category, tmp);
                collects.put(collection, tmpMap);
            }
        }
        return new Gson().toJson(collects);
    }

    @RequestMapping(value = "/all")
    public String getAll() {
        List<Record> colls = recordService.findAll();
        return new Gson().toJson(colls);
    }

    @RequestMapping(value = "/delete")
    public String delete(@RequestParam("id") int id) {
        int line = recordService.deleteById(id);
        return buildRes(line);
    }

    @PostMapping(value = "/save")
    public String save(@RequestBody Record record) {
        int line = recordService.save(record);
        return buildRes(line);
    }

    private String buildRes(int line) {
        JsonObject jo = new JsonObject();
        jo.addProperty("code", line > 0 ? 1 : 0);
        jo.addProperty("message", "");
        return new Gson().toJson(jo);
    }
}
