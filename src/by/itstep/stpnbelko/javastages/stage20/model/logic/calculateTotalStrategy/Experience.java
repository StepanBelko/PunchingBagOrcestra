package by.itstep.stpnbelko.javastages.stage20.model.logic.calculateTotalStrategy;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;

public class Experience implements MusicianCalculable {
    @Override
    public double calculate(Musician musician) {
        return musician.getExperience();
    }
}
