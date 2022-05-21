package by.itstep.stpnbelko.javastages.stage20.model.logic;

import by.itstep.stpnbelko.javastages.stage20.model.entity.Percussion;
import by.itstep.stpnbelko.javastages.stage20.model.entity.Singer;
import by.itstep.stpnbelko.javastages.stage20.model.entity.Violin;
import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;
import by.itstep.stpnbelko.javastages.stage20.model.entity.container.SceneDynamicArray;
import by.itstep.stpnbelko.javastages.stage20.model.logic.calculateTotalStrategy.Experience;
import by.itstep.stpnbelko.javastages.stage20.model.logic.calculateTotalStrategy.Volume;
import org.junit.Test;

import static org.junit.Assert.*;

public class KapellmeisterTest {
    @Test
    public void testTotalVolumeValidData() {
        Musician violin = new Violin("violin 1", 3, 20.2, 4);
        Musician musician1 = new Violin("violin 2", 2, 19, 4);
        Musician violin3 = new Violin("violin 3", 8, 25.2, 4);
        Percussion percussion = new Percussion("DrumKit", 10, 50, 12);
        Singer singer = new Singer("Voice1", 20, 40.0, "highest");
        Singer singer2 = new Singer("Voice2", 20, 350.0, "low");

        SceneDynamicArray scene = new SceneDynamicArray();
        scene.add(violin);
        scene.add(violin3);
        scene.add(musician1);
        scene.add(percussion);
        scene.add(singer);
        scene.add(singer2);
        double expected = 504.4;
        double actual = Kapellmeister.calculateTotal(scene, new Volume());

        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testTotalExperienceValidData() {
        Musician violin = new Violin("violin 1", 3, 20.2, 4);
        Musician musician1 = new Violin("violin 2", 2, 19, 4);
        Musician violin3 = new Violin("violin 3", 8, 25.2, 4);
        Percussion percussion = new Percussion("DrumKit", 10, 50, 12);
        Singer singer = new Singer("Voice1", 20, 40.0, "highest");
        Singer singer2 = new Singer("Voice2", 20, 350.0, "low");

        SceneDynamicArray scene = new SceneDynamicArray();
        scene.add(violin);
        scene.add(violin3);
        scene.add(musician1);
        scene.add(percussion);
        scene.add(singer);
        scene.add(singer2);
        int expected = 63;
        int actual = (int)Kapellmeister.calculateTotal(scene, new Experience());

        assertEquals(expected, actual);
    }
}
