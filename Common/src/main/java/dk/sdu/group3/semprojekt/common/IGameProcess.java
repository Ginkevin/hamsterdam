/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.common;

import java.util.List;

/**
 *
 * @author henrikfrank
 */
public interface IGameProcess {
    
    void process(int delta, List entities);
    
}
