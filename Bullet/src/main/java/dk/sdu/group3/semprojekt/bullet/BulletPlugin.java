/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.bullet;

import dk.sdu.group3.semprojekt.common.data.BulletFactory;
import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.spi.IGamePlugin;

/**
 *
 * @author henrikfrank
 */
public class BulletPlugin implements IGamePlugin{

    @Override
    public void start(World world) {
        BulletFactory bullet = new BulletFactory("Assets/sprites/bullet.png", 5);
        world.setBulletFactory(bullet);
    }

    @Override
    public void stop(World world) {
        world.setBulletFactory(null);
    }
    
}
