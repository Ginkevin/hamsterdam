/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.core;

import org.openide.modules.ModuleInstall;
import playn.core.PlayN;
import playn.java.JavaPlatform;

public class Installer extends ModuleInstall {
    //ScheduledExecutorService e = Executors.newScheduledThreadPool(1);

    @Override
    public void restored() {
        JavaPlatform.Config config = new JavaPlatform.Config();
        config.appName = "Hamsterdam";
        config.height = 600;
        config.width = 800;
        JavaPlatform.register(config);
        PlayN.run(new Hamsterdam());

        // Det her er en copy paste fra et projekt med et update center.
//            e.schedule(()->{
//                    PlayN.run(new Hamsterdam());
//            }, 1000, TimeUnit.MILLISECONDS);
//            PlayN.run(new Hamsterdam());
    }
}
