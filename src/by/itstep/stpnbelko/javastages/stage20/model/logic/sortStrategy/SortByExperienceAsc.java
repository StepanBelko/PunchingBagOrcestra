package by.itstep.stpnbelko.javastages.stage20.model.logic.sortStrategy;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;

public class SortByExperienceAsc implements MusiciansSortable {
    @Override
    public boolean compare(Musician musician1, Musician musician2) {
        return musician1.getExperience() > musician2.getExperience();
    }
}
