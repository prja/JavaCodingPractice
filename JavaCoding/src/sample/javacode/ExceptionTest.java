package sample.javacode;

import junit.framework.Test;

public class ExceptionTest {
    
    public int speed (int distance, int time){
        if(distance < 0 || time <= 0){
            throw new IllegalArgumentException("distance: " + distance
                                                + " time: " + time);
        }      
        return distance/time;
    }
    
    
    
    
    public int speed (Integer distance, Integer time){
        if(distance < 0 || time <= 0){
            throw new IllegalArgumentException("distance: " + distance
                                                + " time: " + time);
        }      
        return distance/time;
    }
    

}


