/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.moovin.checklocation.controller;

import java.util.HashMap;
import java.util.Map;
import me.moovin.checklocation.URLMapping;
import me.moovin.checklocation.model.PointData;
import me.moovin.checklocation.service.CheckPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jarry.palacios
 */

@RestController
@RequestMapping(value=URLMapping.BASE,produces = "application/json")
public class ApiController {
    
    @Autowired CheckPointService service;
    
    @GetMapping(URLMapping.PING)
    @ResponseBody
    public Map<String,String> ping(){
        Map<String,String> result = new HashMap<>();
        result.put("status", "Ok");
        return result;
    }
    
    @PostMapping(URLMapping.POINT)
    @ResponseBody
    public Map<String,Object> checkPoint(@RequestBody PointData pointData){        
        return service.checkPint(pointData.getLongitud(), pointData.getLatitud());
    }
    
}
