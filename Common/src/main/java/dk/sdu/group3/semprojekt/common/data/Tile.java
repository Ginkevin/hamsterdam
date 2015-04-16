/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.common.data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mads_000
 */
public class Tile {
    private List<Platform> platforms = new ArrayList();
    private boolean upConnection, downConnection, leftConnection, rightConnection;
    
    
    public List<Platform> getPlatforms(){
        return platforms;
    }
    
    public void addPlatform(Platform p){
        platforms.add(p);
    }
    
    public boolean canConnectUp(){
        return upConnection;
    }
    
    public boolean canConnectDown(){
        return downConnection;
    }
    
    public boolean canConnectLeft(){
        return leftConnection;
    }
    
    public boolean canConnectRight(){
        return rightConnection;
    }
}
