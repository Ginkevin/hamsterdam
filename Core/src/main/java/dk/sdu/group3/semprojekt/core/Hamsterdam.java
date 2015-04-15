package dk.sdu.group3.semprojekt.core;

import dk.sdu.group3.semprojekt.common.spi.IGamePlugin;
import java.util.ArrayList;
import java.util.List;
import org.openide.util.Lookup;
import playn.core.Game;
/**
 * @author emilfrisk
 */
public class Hamsterdam extends Game.Default{

	List<IGamePlugin> plugins;
	
	private Hamsterdam() {
		super(33);
	}

	@Override
	public void init() {
		Lookup.Result<IGamePlugin> result = Lookup.getDefault().lookupResult(IGamePlugin.class);
		plugins = new ArrayList<IGamePlugin>(result.allInstances());

			
	}

	@Override
	public void paint(float alpha) {
	}

	@Override
	public void update(int delta) {
		super.update(delta); //To change body of generated methods, choose Tools | Templates.
	}
}
