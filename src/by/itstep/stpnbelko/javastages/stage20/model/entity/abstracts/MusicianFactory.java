package by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts;

import by.itstep.stpnbelko.javastages.stage20.model.entity.Percussion;
import by.itstep.stpnbelko.javastages.stage20.model.entity.Singer;
import by.itstep.stpnbelko.javastages.stage20.model.entity.Violin;

import java.util.Random;

public class MusicianFactory {
    private static int singerCount = 0;
    private static int violinCount = 0;
    private static int percussionCount = 0;

    private static final Random random = new Random();

    public Musician createMusician(MusicianTypes type) {
        Musician musician = null;

        switch (type) {
            case SINGER -> musician = createRandomSinger();
            case VIOLIN -> musician = new Violin(type.getRusName() + " " + (++violinCount), 11, 110.2, 4);
            case PERCUSSION -> musician = new Percussion("Percussion " + ++percussionCount, 12, 200.0, 13);
        }
        return musician;
    }

    public static Musician createRandomMusician() {
        MusicianTypes[] types = MusicianTypes.values();
        MusicianFactory factory = new MusicianFactory();

        int i = random.nextInt(types.length);
        System.out.println("Random Musician is " + types[i]);
        return factory.createMusician(types[i]);
    }

    private Singer createRandomSinger() {
        int experience = random.nextInt(100);
        double volume = random.nextDouble() * 100;

        return new Singer(MusicianTypes.SINGER.getRusName() + " " + ++singerCount, experience, volume, "SuperHi");
    }
}
