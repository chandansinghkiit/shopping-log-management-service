package com.mystyle.log.management.controller;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mystyle.log.management.model.Log;
import com.mystyle.log.management.model.Summary;
import com.mystyle.log.management.sevice.LogService;

@RestController
@RequestMapping("/service")
public class LogController {

    @Autowired
    private LogService logService;

    @PostMapping("/summary")
    public ResponseEntity<?> getSummaryOfProduct(@RequestBody Long productId){
    	System.out.println("get product summary for productId"+productId);
        return new ResponseEntity<>(logService.findSummaryByProductId(productId), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> saveLog(@RequestBody Log log){
        log.setLogDate(LocalDateTime.now());
        logService.saveOrUpdate(log);
        return ResponseEntity.ok(log);
    }

    @GetMapping("/popular")
    public ResponseEntity<?> findPopularProduct(){
        List<Long> idList = null;
        List<Summary> populars = logService.findPopularProduct();
        if(populars!=null && !populars.isEmpty()){
            idList =populars.parallelStream().map(s->s.getProductId()).collect(Collectors.toList());
        }
        return ResponseEntity.ok(idList);
    }
}