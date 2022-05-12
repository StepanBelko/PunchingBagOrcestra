package by.itstep.stpnbelko.javastages.stage20.model.logic.sortStrategy;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;

public interface MusiciansSortable {
    boolean compare(Musician musician1, Musician musician2);
}
