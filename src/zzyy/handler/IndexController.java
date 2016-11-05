package com.zzyy.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by zliu on 16-11-2.
 */
@Controller
public class IndexController {


    @RequestMapping(value = {"/", "/index"})
    public String index() {

        return "index";
    }

    @RequestMapping(value = {"pojo"})
    @ResponseBody
    public Map<String, String> pojo() {
        Map<String, String> results = new LinkedHashMap<>();
        results.put("code", "ok");
        results.put("poji", "ok");
        results.put("pojo", "ok");

        return results;
    }

  }
