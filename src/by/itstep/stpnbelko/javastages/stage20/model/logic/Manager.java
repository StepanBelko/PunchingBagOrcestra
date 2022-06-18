package by.itstep.stpnbelko.javastages.stage20.model.logic;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;
import by.itstep.stpnbelko.javastages.stage20.model.entity.container.Scene;
import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Guitar;
import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Percussion;
import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Singer;
import by.itstep.stpnbelko.javastages.stage20.model.logic.calculateTotalStrategy.Price;
import by.itstep.stpnbelko.javastages.stage20.model.logic.sortStrategy.SortBySalaryDesc;

import java.util.ArrayList;
import java.util.List;

import static by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Guitar.GuitarTypes.*;

public class Manager {
    private static final List<Scene> musicianList = new ArrayList<>();
    private static final Scene singers = new Scene();
    private static final Scene leadGuitars = new Scene();
    private static final Scene rhythmGuitars = new Scene();
    private static final Scene bassGuitars = new Scene();
    private static final Scene percussion = new Scene();

    private static final Scene cheapestBand = new Scene();

    public static boolean canMakePerform(int time, double declaredPrice, Scene scene) {

        createMusicianList(scene);

        double musicianPrice;

        for (Scene oneInstanceOfMusician : musicianList) {
            if (oneInstanceOfMusician.size() != 0) {
                cheapestBand.add(oneInstanceOfMusician.get(oneInstanceOfMusician.size() - 1));
            } else {
                return false;
            }
        }

        musicianPrice = Kapellmeister.calculateTotal(cheapestBand, new Price());

        double musicianResult = musicianPrice / 60 * time;

        System.out.println("Cheapest Band");
        System.out.println(cheapestBand);
        System.out.printf("Band price is %.1f$/60min\n\n", musicianPrice);

        System.out.printf("Declared price is %.1f$/%dmin\nCheapest musicians cost %.1f$/%dmin\n\n",
                declaredPrice, time, musicianResult, time);

        return declaredPrice > musicianResult;
    }

    private static void createMusicianList(Scene scene) {
        for (int i = 0; i < scene.size(); i++) {
            Musician musician = scene.get(i);
            if (musician instanceof Singer) {
                singers.add(musician);
            } else if (musician instanceof Percussion) {
                percussion.add(musician);
            } else if (musician instanceof Guitar) {
                distributionOfGuitarist((Guitar) musician);
            }
        }

        sortAllListByPriceDesc();
    }

    private static void sortAllListByPriceDesc() {
        StageSorter.sort(singers, new SortBySalaryDesc());
        StageSorter.sort(leadGuitars, new SortBySalaryDesc());
        StageSorter.sort(rhythmGuitars, new SortBySalaryDesc());
        StageSorter.sort(bassGuitars, new SortBySalaryDesc());
        StageSorter.sort(percussion, new SortBySalaryDesc());

        System.out.println(singers);
        System.out.println(leadGuitars);
        System.out.println(rhythmGuitars);
        System.out.println(bassGuitars);
        System.out.println(percussion);

        createMusicianList();
    }

    private static void createMusicianList() {
        musicianList.add(singers);
        musicianList.add(leadGuitars);
        musicianList.add(rhythmGuitars);
        musicianList.add(bassGuitars);
        musicianList.add(percussion);

    }

    private static void distributionOfGuitarist(Guitar guitar) {
        if (guitar.getTypeOfGuitar() == LEAD_GUITAR) {
            leadGuitars.add(guitar);
        } else if (guitar.getTypeOfGuitar() == RHYTHM_GUITAR) {
            rhythmGuitars.add(guitar);
        } else if (guitar.getTypeOfGuitar() == BASS) {
            bassGuitars.add(guitar);
        }
    }
}
