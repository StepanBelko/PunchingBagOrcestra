package by.itstep.stpnbelko.javastages.stage20.model.entity.container;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;

public interface Container {
    int size();
    Musician get(int index);
}
