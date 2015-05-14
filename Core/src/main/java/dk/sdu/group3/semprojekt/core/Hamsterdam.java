package dk.sdu.group3.semprojekt.core;

import dk.sdu.group3.semprojekt.common.data.Level;
import dk.sdu.group3.semprojekt.common.data.Vector;
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
        
	for (IGamePlugin pl : plugins){
            System.out.println(pl.getClass());
	}

        for (IGamePlugin p : plugins) {
            p.start(world);
        }
    }

    @Override
    public void update(int delta) {
        clock.update(delta);

        for (IGameProcess p : getEntityProcessingServices()) {
            p.process(delta, world);
        }
    }

    private ImageLayer bgLayer;
    @Override
    public void paint(float alpha) {
        clock.paint(alpha);
        
        if (bgLayer==null) {
            createBackground(world.getLevel());
        }

        rootLayer.add(bgLayer);

        for (IEntity e : world.getEntities()) {
            if (e.getView() == null) e.setView(createView(e));

            ImageLayer spriteLayer = e.getView();

            Vector p = e.getPosition();
            float r = e.getAngle();
            float s = e.getScale();


            spriteLayer.setTranslation(p.getX(), p.getY());
            spriteLayer.setRotation(r);
            spriteLayer.setScale(s);

            rootLayer.add(spriteLayer);
        }
    }
    
    private ImageLayer createBackground(Level l){
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
            
        return bgLayer = viewLayer;
    }

    private ImageLayer createView(IEntity entity) {
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

        return viewLayer;
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
}
