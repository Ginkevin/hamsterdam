/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.move;

import dk.sdu.group3.semprojekt.common.data.Entity;
import dk.sdu.group3.semprojekt.common.data.Vector;
import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nikolai
 */
public class MoveProcessTest {
    
    public MoveProcessTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of move method, of class MoveProcess.
         */
    @Test
    public void testMove() {
        System.out.println("Testing move 1");
        IEntity entity = new dk.sdu.group3.semprojekt.common.data.Character();
        entity.setPosition(40, 40);
        entity.setVelocity(4, 0);
        int delta = 1;
        MoveProcess instance = new MoveProcess();
        instance.move(entity, delta);
        long expectedResult = 44;
        assertEquals(expectedResult, expectedResult);
    }
    
    @Test
    public void testMove2() {
        System.out.println("Testing move 2");
        IEntity entity = new dk.sdu.group3.semprojekt.common.data.Character();
        entity.setPosition(40, 40);
        entity.setVelocity(-4, 0);
        int delta = 1;
        MoveProcess instance = new MoveProcess();
        instance.move(entity, delta);
        long expectedResult = 36;
        assertEquals(expectedResult, expectedResult);
    }
    
    @Test
    public void testMove3() {
        System.out.println("Testing move 3");
        IEntity entity = new dk.sdu.group3.semprojekt.common.data.Character();
        entity.setPosition(40, 40);
        Vector v = new Vector(-4,0);
        entity.setVelocity(v);
        int delta = 1;
        MoveProcess instance = new MoveProcess();
        instance.move(entity, delta);
        long expectedResult = 36;
        assertEquals(expectedResult, expectedResult);
    }
    
    @Test
    public void testMove4() {
        System.out.println("Testing move 4");
        IEntity entity = new dk.sdu.group3.semprojekt.common.data.Character();
        entity.setPosition(40, 40);
        Vector v = new Vector(4,0);
        entity.setVelocity(v);
        int delta = 1;
        MoveProcess instance = new MoveProcess();
        instance.move(entity, delta);
        long expectedResult = 44;
        assertEquals(expectedResult, expectedResult);
    }
    
}
