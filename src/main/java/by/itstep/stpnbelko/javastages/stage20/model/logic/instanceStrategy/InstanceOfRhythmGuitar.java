package by.itstep.stpnbelko.javastages.stage20.model.logic.instanceStrategy;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;
import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Guitar;

public class InstanceOfRhythmGuitar implements MusicianInstance {
    @Override
    public boolean isInstanceOfSpecial(Musician musician) {
        return (musician instanceof Guitar
                && ((Guitar<?>) musician).getTypeOfGuitar() == Guitar.GuitarTypes.RHYTHM_GUITAR);
    }
}
