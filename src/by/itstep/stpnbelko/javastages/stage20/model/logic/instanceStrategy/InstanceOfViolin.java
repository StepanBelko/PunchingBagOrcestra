package by.itstep.stpnbelko.javastages.stage20.model.logic.instanceStrategy;

import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Violin;
import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;

public class InstanceOfViolin implements MusicianInstance {
    @Override
    public boolean isInstanceOfSpecial(Musician musician) {
        return musician instanceof Violin;
    }
}
