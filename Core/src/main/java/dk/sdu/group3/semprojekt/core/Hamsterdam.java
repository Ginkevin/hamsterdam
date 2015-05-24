package dk.sdu.group3.semprojekt.core;

import dk.sdu.group3.semprojekt.common.interfaces.ICharacter;
import dk.sdu.group3.semprojekt.common.data.Level;
import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import dk.sdu.group3.semprojekt.common.spi.IGamePlugin;
import dk.sdu.group3.semprojekt.common.spi.IGameProcess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        world.setRootLayer(rootLayer);
        setBackground(world.getLevel());         
    }

    @Override
    public void update(int delta) {
        clock.update(delta);
        plugins.clear();
        Lookup.Result<IGamePlugin> result = lookup.lookupResult(IGamePlugin.class);
        result.addLookupListener(lookupListener);
        plugins = new ArrayList(result.allInstances());
        result.allItems();
        for (IGameProcess p : getEntityProcessingServices()) {
            p.process(delta, world);
        }      
    }

    @Override
    public void paint(float alpha) {
        clock.paint(alpha);

        for (IEntity e : world.getEntities()) {
            if (e.getView() == null) 
                createView(e);
            
            if(e instanceof ICharacter){
                ICharacter c = (ICharacter) e;
                if(c.getViewsFW() == null && c.getViewsBW() == null){
                    loadImagesFW(c);
                    loadImagesBW(c);
                }
            }
            if(e.getIsDestroyed() == true)
            {
                DestroyEntity(e);
            }
            
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
        rootLayer.add(viewLayer);
        
    }
    
    public void loadImagesFW(ICharacter character){
        List<ImageLayer> listOfImagesFW = new ArrayList();
        for(String s : character.getPathsFW()){
            Image image = assets().getRemoteImage(s);
            final ImageLayer viewLayer = graphics().createImageLayer(image);
            listOfImagesFW.add(viewLayer);
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
        }
        character.setViewsFW(listOfImagesFW); 
    }
    
    public void loadImagesBW(ICharacter character){
        List<ImageLayer> listOfImagesBW = new ArrayList();
        for(String s : character.getPathsBW()){
            Image image = assets().getRemoteImage(s);
            final ImageLayer viewLayer = graphics().createImageLayer(image);
            listOfImagesBW.add(viewLayer);
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
        }
        character.setViewsBW(listOfImagesBW);
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
}
