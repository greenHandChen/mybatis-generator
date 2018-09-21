package com.ceh.mybatis.generator.controller;

import com.ceh.mybatis.generator.po.TableInfo;
import com.ceh.mybatis.generator.service.GenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by enHui.Chen on 2018/9/17.
 */
@RestController
@RequestMapping("/api")
public class GenerateController {
    @Autowired
    private GenerateService generateService;

    @RequestMapping(value = "/getAllnInfos", method = RequestMethod.GET)
    public ResponseEntity<List<TableInfo>> getAllTables() {
        List<TableInfo> allTables = generateService.getAllnInfos();
        return new ResponseEntity<>(allTables, HttpStatus.OK);
    }

    @RequestMapping(value = "/generateCode", method = RequestMethod.POST)
    public ResponseEntity<String> generateCode(@RequestBody TableInfo tableInfo) {
        generateService.generateCode(tableInfo);
        return new ResponseEntity<>("生成成功", HttpStatus.OK);
    }
}
