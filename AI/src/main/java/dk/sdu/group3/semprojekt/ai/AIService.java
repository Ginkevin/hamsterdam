package dk.sdu.group3.semprojekt.ai;

import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.spi.IGameProcess;
import dk.sdu.group3.semprojekt.enemy.Enemy;
import dk.sdu.group3.semprojekt.player.Player;
import org.openide.util.lookup.ServiceProvider;


@ServiceProvider(service = IGameProcess.class)
public class AIService implements IGameProcess {

    @Override
    public void process(int delta, World world) {
        Player player = (Player)world.getEntities().stream().filter(entity -> entity instanceof Player).findFirst().get();
        world.getEntities().stream().filter(entity -> entity instanceof Enemy).forEach(enemy -> {
            int dir = (int)Math.signum(enemy.getPosition().getX()-player.getPosition().getX());
            switch (dir){
                case(1):
                    turnLeft();
                    break;
                case(0):
                    break;
                case(-1):
                    turnRight();
            }
        });
    }

    private void turnLeft() {

    }

    private void turnRight() {

    }

}
