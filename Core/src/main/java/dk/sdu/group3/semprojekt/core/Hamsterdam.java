package dk.sdu.group3.semprojekt.core;

import dk.sdu.group3.semprojekt.common.Entity;
import dk.sdu.group3.semprojekt.common.IGamePlugin;
import dk.sdu.group3.semprojekt.common.IGameProcess;
import dk.sdu.group3.semprojekt.common.Position;
import dk.sdu.group3.semprojekt.common.World;
import java.util.ArrayList;
import java.util.List;
import org.openide.util.Lookup;
import playn.core.Game;
import playn.core.GroupLayer;
import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.Keyboard;
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
		plugins = new ArrayList<IGamePlugin>(result.allInstances());
		
		for (IGamePlugin p : plugins){
			p.start(world);
		}

		Entity e = new Entity();
		e.setSpritePath("");
		e.setPosition(new Position(100,100));
		e.setRotation(0);
		e.setScale(1);

		world.entities.add(e);
	}

	@Override
	public void update(int delta) {
		super.update(delta);
		
		Lookup.Result<IGameProcess> result = Lookup.getDefault().lookupResult(IGameProcess.class);
		gameProcesses = new ArrayList<IGameProcess>(result.allInstances());

		for (IGameProcess p : gameProcesses){
			p.process(delta, world.entities);
		}
	}

	@Override
	public void paint(float alpha) {
		super.paint(alpha);
		
		for (Entity e : world.entities){
			if (e.getView() == null) e.setView(createView(e));

			ImageLayer spriteLayer = e.getView();
			
			Position p = e.getPosition();
			float r = e.getRotation();
			float s = e.getScale();
			
			spriteLayer.setTranslation(p.x, p.y);
			spriteLayer.setRotation(r);
			spriteLayer.setScale(s);

			rootLayer.add(spriteLayer);
		}
	}

	private ImageLayer createView(Entity entity) { 

		Image image = assets().getImageSync(entity.getSpritePath());

		ImageLayer viewLayer = graphics().createImageLayer(image);
		viewLayer.setOrigin(image.width() / 2f, image.height() / 2f);
		
		entity.setView(viewLayer);
		rootLayer.add(viewLayer);

		return viewLayer;
	}


	private final Keyboard.Listener keyboardListener = new Keyboard.Listener() {

		@Override
		public void onKeyDown(Keyboard.Event event) {
			switch (event.key()) {
				case W:

					break;

				case S:
					break;

				case A:
					break;

				case D:
					break;

				case SPACE:
					break;

				default:
					break;
			}
		}

		@Override
		public void onKeyTyped(Keyboard.TypedEvent te) {
		}

		@Override
		public void onKeyUp(Keyboard.Event event) {
		}
	};
}
