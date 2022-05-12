package by.itstep.stpnbelko.javastages.stage20.model.logic.instanceStrategy;

import by.itstep.stpnbelko.javastages.stage20.model.entity.Singer;
import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;

public class InstanceOfSinger implements MusicianInstance {
    @Override
    public boolean isInstanceOfSpecial(Musician musician) {
        return musician instanceof Singer;
    }
}
