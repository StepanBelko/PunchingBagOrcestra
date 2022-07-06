package by.itstep.stpnbelko.javastages.stage20.model.logic;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;
import by.itstep.stpnbelko.javastages.stage20.model.entity.container.Scene;
import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Guitar;
import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Percussion;
import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Singer;
import by.itstep.stpnbelko.javastages.stage20.util.exceptions.SceneIsEmptyException;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerTest {
    @Test
    public void canMakePerformPositiveTest() {
        Musician leadGuitar = new Guitar<>("LeadGuitar", 10, 20, 10, Guitar.GuitarTypes.LEAD_GUITAR);
        Musician rhythmGuitar = new Guitar<>("RhythmGuitar", 10, 20, 10, Guitar.GuitarTypes.RHYTHM_GUITAR);
        Musician bassGuitar = new Guitar<>("BassGuitar", 10, 20, 10, Guitar.GuitarTypes.BASS);
        Musician singer = new Singer("Singer", 10, 20, 10, Singer.SingerType.UNKNOWN_VOICE_POWER);
        Musician percussion = new Percussion("Drums", 10, 20, 10, 12);

        Scene scene = new Scene();

        scene.add(leadGuitar);
        scene.add(rhythmGuitar);
        scene.add(bassGuitar);
        scene.add(singer);
        scene.add(percussion);

        assertTrue(Manager.canMakePerform(120, 100, scene));
    }

    @Test
    public void canMakePerformNegativeTest() {
        Musician leadGuitar = new Guitar<>("LeadGuitar", 10, 20, 10, Guitar.GuitarTypes.LEAD_GUITAR);
        Musician rhythmGuitar = new Guitar<>("RhythmGuitar", 10, 20, 10, Guitar.GuitarTypes.RHYTHM_GUITAR);
        Musician bassGuitar = new Guitar<>("BassGuitar", 10, 20, 10, Guitar.GuitarTypes.BASS);
        Musician singer = new Singer("Singer", 10, 20, 10, Singer.SingerType.UNKNOWN_VOICE_POWER);
        Musician percussion = new Percussion("Drums", 10, 20, 10, 12);

        Scene scene = new Scene();

        scene.add(leadGuitar);
        scene.add(rhythmGuitar);
        scene.add(bassGuitar);
        scene.add(singer);
        scene.add(percussion);

        assertFalse(Manager.canMakePerform(120, 99, scene));
    }

    @Test
    public void canMakePerformNotEnoughMusicianTest() {
        Musician leadGuitar = new Guitar<>("LeadGuitar", 10, 20, 10, Guitar.GuitarTypes.LEAD_GUITAR);
        Musician rhythmGuitar = new Guitar<>("RhythmGuitar", 10, 20, 10, Guitar.GuitarTypes.RHYTHM_GUITAR);
        Musician bassGuitar = new Guitar<>("BassGuitar", 10, 20, 10, Guitar.GuitarTypes.BASS);

        Musician percussion = new Percussion("Drums", 10, 20, 10, 12);

        Scene scene = new Scene();

        scene.add(leadGuitar);
        scene.add(rhythmGuitar);
        scene.add(bassGuitar);
        
        scene.add(percussion);

        assertFalse(Manager.canMakePerform(120, 99, scene));
    }

    @Test(expected = NullPointerException.class)
    public void canMakePerformEmptySceneTest() {
        Manager.canMakePerform(120, 99, null);
    }
}
