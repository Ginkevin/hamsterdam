package dk.sdu.group3.semprojekt.ai;

import dk.sdu.group3.semprojekt.common.data.*;
import dk.sdu.group3.semprojekt.common.data.Character;
import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import dk.sdu.group3.semprojekt.common.spi.IGameProcess;
import dk.sdu.group3.semprojekt.enemy.Enemy;
import dk.sdu.group3.semprojekt.player.Player;
import org.openide.util.lookup.ServiceProvider;


@ServiceProvider(service = IGameProcess.class)
public class AIService implements IGameProcess {

    @Override
    public void process(int delta, World world) {
        IEntity player = world.getEntities().stream().filter(entity -> entity instanceof Character).filter(c -> ((Character) c).getCharacterEnum()==CharacterEnum.PLAYER).findFirst().get();
        world.getEntities().stream().filter(entity -> entity instanceof Character).filter(c -> ((Character) c).getCharacterEnum()==CharacterEnum.PLAYER).forEach(enemy -> {
            int dir = (int)Math.signum(enemy.getPosition().getX()-player.getPosition().getX());
            switch (dir){
                case(1):
                    turnLeft(enemy);
                    break;
                case(0):
                    break;
                case(-1):
                    turnRight(enemy);
            }
        });
    }

    private void turnLeft(IEntity enemy) {
        enemy.addEvent(new Event(EventEnum.LEFT));
    }

    private void turnRight(IEntity enemy) {
        enemy.addEvent(new Event(EventEnum.RIGHT));
    }

}
