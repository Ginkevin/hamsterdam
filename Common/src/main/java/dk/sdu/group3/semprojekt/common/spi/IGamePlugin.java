/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.common.spi;

import dk.sdu.group3.semprojekt.common.data.World;

/**
 *
 * @author henrikfrank
 */
public interface IGamePlugin {    
    public void start(World world);
}
