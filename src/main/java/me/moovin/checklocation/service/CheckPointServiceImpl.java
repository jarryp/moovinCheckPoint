/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.moovin.checklocation.service;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.geom.impl.CoordinateArraySequence;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author jarry.palacios
 */
@Service
public class CheckPointServiceImpl implements CheckPointService {

    @Override
    public Map<String,Object> checkPint(double longitud, double latitud) {
        Map<String,Object> result = new HashMap<>();
        GeometryFactory gf = new GeometryFactory();
        Coordinate coord = new Coordinate(latitud,longitud);
        Point point = gf.createPoint(coord);
        if(point.within(getPolygon())){
            result.put("result", true);
            result.put("description", "El punto consultado se encuentra dentro del poligono de trabajo");
        }else{
            result.put("result", false);
            result.put("description", "El punto consultado NO se encuentra dentro del poligono de trabajo");
        }
        return result;
    }

    @Override
    public Polygon getPolygon() {
        GeometryFactory gf = new GeometryFactory();
        Polygon polygon = gf.createPolygon(new LinearRing(
                new CoordinateArraySequence(
                        getListPoints().toArray(
                                new Coordinate[getListPoints().size()]
                        )
                ),gf),null);
        return polygon;
    }
    
    private ArrayList<Coordinate> getListPoints(){
        ArrayList<Coordinate> listPoint = new ArrayList<>();
        listPoint.add(new Coordinate(10.02933, -84.125963));
        listPoint.add(new Coordinate(10.040148,-84.055239));
        listPoint.add(new Coordinate(10.001268,-84.008203));
        listPoint.add(new Coordinate(9.979967, -83.988977));
        listPoint.add(new Coordinate(9.946152, -83.978334));
        listPoint.add(new Coordinate(9.921804, -83.991381));
        listPoint.add(new Coordinate(9.913011, -83.949152));
        listPoint.add(new Coordinate(9.883586, -83.893534));
        listPoint.add(new Coordinate(9.837246, -83.846155));
        listPoint.add(new Coordinate(9.814919, -83.854738));
        listPoint.add(new Coordinate(9.821008, -83.950182));
        listPoint.add(new Coordinate(9.839952, -83.986231));
        listPoint.add(new Coordinate(9.853821, -83.986231));
        listPoint.add(new Coordinate(9.887645, -83.953958));
        listPoint.add(new Coordinate(9.897453, -83.971468));
        listPoint.add(new Coordinate(9.878513, -84.074121));
        listPoint.add(new Coordinate(9.894748, -84.142786));
        listPoint.add(new Coordinate(9.894748, -84.161325));
        listPoint.add(new Coordinate(9.900788, -84.161218));
        listPoint.add(new Coordinate(9.906434, -84.205075));
        listPoint.add(new Coordinate(9.902188, -84.217974));
        listPoint.add(new Coordinate(9.904218, -84.260202));
        listPoint.add(new Coordinate(9.931611, -84.263979));
        listPoint.add(new Coordinate(9.929244, -84.293505));
        listPoint.add(new Coordinate(9.95021,  -84.341227));
        listPoint.add(new Coordinate(9.986053, -84.340197));
        listPoint.add(new Coordinate(10.007692, -84.322));
        listPoint.add(new Coordinate(10.045895, -84.22999));
        listPoint.add(new Coordinate(10.057389, -84.160982));
        listPoint.add(new Coordinate(10.02933, -84.125963));
        return listPoint;
    }
    
    
}
