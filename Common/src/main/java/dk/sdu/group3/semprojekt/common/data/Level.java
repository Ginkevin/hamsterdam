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
public class Level extends Entity{
    private List<Platform> platforms = new ArrayList();
    private String background;
    
    public void setBackground(String path){
        background = path;
    }
    
    public String getBackground(){
        return background;
    }
    
    public List<Platform> getPlatforms(){
        return platforms;
    }
    
    public void addPlatform(Platform p){
        platforms.add(p);
    }
}
