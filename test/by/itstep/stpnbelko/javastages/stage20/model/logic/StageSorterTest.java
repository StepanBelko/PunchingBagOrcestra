package by.itstep.stpnbelko.javastages.stage20.model.logic;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;
import by.itstep.stpnbelko.javastages.stage20.model.entity.container.Scene;
import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Guitar;
import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Percussion;
import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Singer;
import by.itstep.stpnbelko.javastages.stage20.model.logic.sortStrategy.SortBySalaryDesc;
import org.junit.Test;

import static org.junit.Assert.*;

public class StageSorterTest {
    @Test
    public void sortBySalaryPositiveTest() {
        Musician leadGuitar = new Guitar<>("LeadGuitar", 10, 20, 10, Guitar.GuitarTypes.LEAD_GUITAR);
        Musician rhythmGuitar = new Guitar<>("RhythmGuitar", 10, 20, 12, Guitar.GuitarTypes.RHYTHM_GUITAR);
        Musician bassGuitar = new Guitar<>("BassGuitar", 10, 20, 11, Guitar.GuitarTypes.BASS);
        Musician singer = new Singer("Singer", 10, 20, 13, Singer.SingerType.UNKNOWN_VOICE_POWER);
        Musician percussion = new Percussion("Drums", 10, 20, 14, 12);

        Scene scene = new Scene();

        scene.add(leadGuitar);
        scene.add(rhythmGuitar);
        scene.add(bassGuitar);
        scene.add(singer);
        scene.add(percussion);

        StageSorter.sort(scene, new SortBySalaryDesc());
        for (int i = 0; i < scene.size() - 1; i++) {
            assertTrue(scene.get(i).getSalary() >= scene.get(i+1).getSalary());
        }
    }

    @Test(expected = NullPointerException.class)
    public void sortBySalaryEmptySceneTest() {
        StageSorter.sort(null, new SortBySalaryDesc());
    }
}
