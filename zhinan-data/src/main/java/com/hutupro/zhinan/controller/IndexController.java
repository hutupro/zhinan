package com.hutupro.zhinan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author hutupro
 * @since 2022/10/5
 */
@Controller
public class IndexController {
    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

}
