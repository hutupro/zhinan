package com.hutupro.sinan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hutupro
 * @since 2022/10/5
 */
@RestController
public class IndexController {
    @RequestMapping(value = "/")
    public String index() {
        return "hello sinan";
    }

}
