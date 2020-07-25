/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.moovin.checklocation.service;

import com.vividsolutions.jts.geom.Polygon;
import java.util.Map;

/**
 *
 * @author jarry.palacios
 */
public interface CheckPointService {
    public Map<String,Object> checkPint(double longitud, double latitud);
    public Polygon getPolygon();
}
