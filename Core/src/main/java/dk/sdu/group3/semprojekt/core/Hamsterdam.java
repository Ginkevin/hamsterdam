package dk.sdu.group3.semprojekt.core;

import dk.sdu.group3.semprojekt.common.data.Entity;
import dk.sdu.group3.semprojekt.common.data.Event;
import dk.sdu.group3.semprojekt.common.data.Level;
import dk.sdu.group3.semprojekt.common.data.World;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.DESTROY;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.E;
import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import dk.sdu.group3.semprojekt.common.spi.IGamePlugin;
import dk.sdu.group3.semprojekt.common.spi.IGameProcess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.netbeans.api.autoupdate.OperationContainer;
import org.netbeans.api.autoupdate.OperationContainer.OperationInfo;
import org.netbeans.api.autoupdate.OperationException;
import org.netbeans.api.autoupdate.OperationSupport;
import org.netbeans.api.autoupdate.OperationSupport.Restarter;
import org.netbeans.api.autoupdate.UpdateElement;
import org.netbeans.api.autoupdate.UpdateManager;
import org.netbeans.api.autoupdate.UpdateUnit;

import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;

import playn.core.*;
import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;

import playn.core.util.Callback;
import playn.core.util.Clock;


/**
 * @author emilfrisk
 */
public class Hamsterdam extends Game.Default {
    private final Clock.Source clock = new Clock.Source(33);
    private final Lookup lookup = Lookup.getDefault();
    private World world;
    private List<IGamePlugin> plugins;
    private GroupLayer rootLayer;
    private ImageLayer bgLayer;

    public Hamsterdam() {
        super(33);
    }

    @Override
    public void init() {
        world = new World();

        rootLayer = graphics().rootLayer();
        
        Lookup.Result<IGamePlugin> result = lookup.lookupResult(IGamePlugin.class);
        result.addLookupListener(lookupListener);
        plugins = new ArrayList(result.allInstances());
        result.allItems();

        for (IGamePlugin p : plugins) {
            p.start(world);
            System.out.println(p.getClass());
        }
        
        setBackground(world.getLevel());         
    }

    @Override
    public void update(int delta) {
        clock.update(delta);

        for (IGameProcess p : getEntityProcessingServices()) {
            p.process(delta, world);
        }
        
        for(Event e : world.getMoveEvents()){
            if(e.getEvent().equals(E))
                doDisable("dk.sdu.group3.semprojekt.Enemy");
        }
        
    }

    @Override
    public void paint(float alpha) {
        clock.paint(alpha);

        for (IEntity e : world.getEntities()) {
            if (e.getView() == null) 
                createView(e);
            
            ImageLayer spriteLayer = e.getView();

            spriteLayer.setTranslation(e.getPosition().getX(), e.getPosition().getY());
            spriteLayer.setRotation(e.getAngle());
            spriteLayer.setScale(e.getScale());
        }
    }
    
    private void setBackground(Level l){
        Level level = world.getLevel();
        Image image = assets().getRemoteImage(level.getBackground());
        final ImageLayer viewLayer = graphics().createImageLayer(image);

        image.addCallback(new Callback<Image>() {
            @Override
            public void onSuccess(Image t) {

            }

            @Override
            public void onFailure(Throwable thrwbl) {
                thrwbl.printStackTrace();
            }
        });
        
        bgLayer = viewLayer;
        rootLayer.add(bgLayer);
    }

    private void createView(IEntity entity) {
        Image image = assets().getRemoteImage(entity.getSprite());
        final ImageLayer viewLayer = graphics().createImageLayer(image);

        image.addCallback(new Callback<Image>() {
            @Override
            public void onSuccess(Image t) {
                viewLayer.setOrigin(t.width() / 2f, t.height() / 2f);
            }

            @Override
            public void onFailure(Throwable thrwbl) {
                thrwbl.printStackTrace();
            }
        });
        
        entity.setView(viewLayer);
        rootLayer.add(entity.getView());
    }
    
    private Collection<? extends IGameProcess> getEntityProcessingServices() {
        return lookup.lookupAll(IGameProcess.class);
    }
    
    private final LookupListener lookupListener = new LookupListener() {
        @Override
        public void resultChanged(LookupEvent le) {
            for (IGamePlugin updatedGamePlugin : lookup.lookupAll(IGamePlugin.class)) {
                if (!plugins.contains(updatedGamePlugin)) {
                    updatedGamePlugin.start(world);
                    plugins.add(updatedGamePlugin);
                    System.out.println(updatedGamePlugin.getClass());
               }
            }
        }
    };
    
    private void DestroyEntity(IEntity e)
    {
        rootLayer.remove(e.getView());
        world.removeEntity(e);
    }
    
    public void doDisable (String codeNames) { // codeName contains code name of modules for disable
        System.out.println("Trying to unload " + codeNames);
        OperationContainer<OperationSupport> oc = OperationContainer.createForDirectDisable();

        for(UpdateUnit unit : UpdateManager.getDefault().getUpdateUnits(UpdateManager.TYPE.MODULE)) {
            if (unit.getInstalled() != null) { // filter all installed modules
                UpdateElement el = unit.getInstalled();
                if (el.isEnabled()) { // filter all enabled modules
                    if (codeNames.equals(el.getCodeName())) { // filter given module in the parameter
                        System.out.println("found one with the same codename: " + unit.getCodeName());
                        if(oc.canBeAdded (unit, el)){ // check if module can be disabled
                            OperationInfo operationInfo = oc.add(el);
                            if(operationInfo != null){ // check that it's not already planned to be disabled
                                oc.add(operationInfo.getRequiredElements()); // add all of them between modules for disable
                            }
                        }
                    }
                }
            }
        }

        if(!oc.listAll().isEmpty()){ // check the container doesn't contain any invalid element
            try {
            Restarter restarter = oc.getSupport().doOperation(null); // get operation support for complete the disable operation
            } catch (OperationException ex) {
                Exceptions.printStackTrace (ex);
            }
        }
    }
}
