package dk.sdu.group3.semprojekt.ai;

import dk.sdu.group3.semprojekt.common.enums.EventEnum;
import dk.sdu.group3.semprojekt.common.enums.CharacterEnum;
import dk.sdu.group3.semprojekt.common.data.*;
import dk.sdu.group3.semprojekt.common.data.Character;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.SHOOT;
import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import dk.sdu.group3.semprojekt.common.spi.IGameProcess;
import org.openide.util.lookup.ServiceProvider;


@ServiceProvider(service = IGameProcess.class)
public class AIService implements IGameProcess {

    @Override
    public void process(int delta, World world) {
        world.getEntities().stream().filter(entity -> entity instanceof Character).filter(c -> ((Character) c).getCharacterEnum() == CharacterEnum.PLAYER).forEach(player -> {
            world.getEntities().stream().filter(entity -> entity instanceof Character).filter(c -> ((Character) c).getCharacterEnum() == CharacterEnum.ENEMY).forEach(enemy -> {
                int dir = (int) Math.signum(enemy.getPosition().getX() - player.getPosition().getX());
                switch (dir) {
                    case (1):
                        enemy.addEvent(new Event(EventEnum.LEFT));
                        break;
                    case (-1):
                        enemy.addEvent(new Event(EventEnum.RIGHT));
                        break;
                    default:
                        break;
                }
                if (Math.random() < 0.01f) {
                    enemy.addEvent(new Event(SHOOT));
                }
            });
        });
    }
}
