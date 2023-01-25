package by.itstep.stpnbelko.javastages.stage20.model.logic.salaryFindStrategy;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;

public interface MusicianSalary {
    boolean compare(Musician musician, int salary);
}
