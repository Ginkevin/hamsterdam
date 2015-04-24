/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.core;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.openide.modules.ModuleInstall;
import playn.core.PlayN;
import playn.java.JavaPlatform;

public class Installer extends ModuleInstall {
    ScheduledExecutorService e = Executors.newScheduledThreadPool(1);

    @Override
    public void restored() {
        JavaPlatform.Config config = new JavaPlatform.Config();
        config.appName = "Hamsterdam";
        config.height = 600;
        config.width = 800;
            JavaPlatform.register(config);
            
        e.schedule(()->{
            PlayN.run(new Hamsterdam());
        }, 1500, TimeUnit.MILLISECONDS);
    }
}
