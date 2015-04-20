package dk.sdu.group3.semprojekt.core;

<<<<<<< Updated upstream
import dk.sdu.group3.semprojekt.common.data.Vector;
import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import dk.sdu.group3.semprojekt.common.spi.IGamePlugin;
import dk.sdu.group3.semprojekt.common.spi.IGameProcess;
=======
import dk.sdu.group3.semprojekt.common.data.Entity;
import dk.sdu.group3.semprojekt.common.spi.IGamePlugin;
import dk.sdu.group3.semprojekt.common.spi.IGameProcess;
import dk.sdu.group3.semprojekt.common.World;
>>>>>>> Stashed changes
import java.util.ArrayList;
import java.util.List;
import org.openide.util.Lookup;
import playn.core.Game;
import playn.core.GroupLayer;
import playn.core.Image;
import playn.core.ImageLayer;
import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;
import playn.core.util.Clock;
/**
 * @author emilfrisk
 */
public class Hamsterdam extends Game.Default{
	final Clock.Source clock  = new Clock.Source(33);
	World world;
	List<IGamePlugin> plugins;
	List<IGameProcess> gameProcesses;
	GroupLayer rootLayer;
	
	public Hamsterdam() {
		super(33);
	}

	@Override
	public void init() {

		world = new World();

		rootLayer = graphics().rootLayer();
		
		Lookup.Result<IGamePlugin> result = Lookup.getDefault().lookupResult(IGamePlugin.class);
		plugins = new ArrayList<>(result.allInstances());
		
		for (IGamePlugin p : plugins){
			p.start(world);
		}

	}

	@Override
	public void update(int delta) {
		super.update(delta);
		
		Lookup.Result<IGameProcess> result = Lookup.getDefault().lookupResult(IGameProcess.class);
		gameProcesses = new ArrayList<>(result.allInstances());

		for (IGameProcess p : gameProcesses){
			p.process(delta, world);
		}
	}

	@Override
	public void paint(float alpha) {
		super.paint(alpha);
		
		for (IEntity e : world.getEntities()){
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

	private ImageLayer createView(IEntity entity) { 

		Image image = assets().getImageSync(entity.getSprite());

		ImageLayer viewLayer = graphics().createImageLayer(image);
		viewLayer.setOrigin(image.width() / 2f, image.height() / 2f);
		
		entity.setView(viewLayer);
		rootLayer.add(viewLayer);

		return viewLayer;
	}
}
