package dk.sdu.group3.semprojekt.core;

import dk.sdu.group3.semprojekt.common.data.Level;
import dk.sdu.group3.semprojekt.common.data.Vector;
import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import dk.sdu.group3.semprojekt.common.spi.IGamePlugin;
import dk.sdu.group3.semprojekt.common.spi.IGameProcess;

import java.util.ArrayList;
import java.util.List;

import org.openide.util.Lookup;
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
    private World world;
    private List<IGamePlugin> plugins;
    private List<IGameProcess> gameProcesses;
    private GroupLayer rootLayer;

    public Hamsterdam() {
        super(33);
    }

    @Override
    public void init() {
        world = new World();

        rootLayer = graphics().rootLayer();

        Lookup.Result<IGamePlugin> result = Lookup.getDefault().lookupResult(IGamePlugin.class);
        plugins = new ArrayList<>(result.allInstances());
	for (IGamePlugin pl : plugins){
		System.out.println(pl.getClass());
	}
        System.out.println("IGamePlugins: " + plugins.size());

        for (IGamePlugin p : plugins) {
            p.start(world);
        }
        //todo
    }

    @Override
    public void update(int delta) {
        super.update(delta);

        Lookup.Result<IGameProcess> result = Lookup.getDefault().lookupResult(IGameProcess.class);
        gameProcesses = new ArrayList<>(result.allInstances());

        for (IGameProcess p : gameProcesses) {
            p.process(delta, world);
        }
    }

    private ImageLayer bgLayer;
    @Override
    public void paint(float alpha) {
        clock.paint(alpha);
        if (bgLayer==null) {
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
        }

        rootLayer.add(bgLayer);

        for (IEntity e : world.getEntities()) {
            if (e.getView() == null) e.setView(createView(e));

            ImageLayer spriteLayer = e.getView();

//            Vector p = new Vector(0,0);//e.getPosition();
            Vector p = e.getPosition();
            float r = e.getAngle();
            float s = e.getScale();


//            System.out.println(p);
            spriteLayer.setTranslation(p.getX(), p.getY());
            spriteLayer.setRotation(r);
            spriteLayer.setScale(s);

            rootLayer.add(spriteLayer);
        }
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
}
