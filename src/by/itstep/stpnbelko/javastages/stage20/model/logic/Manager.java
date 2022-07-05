package by.itstep.stpnbelko.javastages.stage20.model.logic;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;
import by.itstep.stpnbelko.javastages.stage20.model.entity.container.Scene;
import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Guitar;
import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Percussion;
import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Singer;
import by.itstep.stpnbelko.javastages.stage20.model.logic.calculateTotalStrategy.Price;
import by.itstep.stpnbelko.javastages.stage20.model.logic.sortStrategy.SortBySalaryDesc;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

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

    private static final Logger ManagerLOG;

    static {
        ManagerLOG = Logger.getLogger(Manager.class);
        ManagerLOG.setLevel(Level.DEBUG);
    }

    public static boolean canMakePerform(int time, double declaredPrice, Scene scene) {
        ManagerLOG.info("Start canMakePerform()");
//        Из общего списка рандомных музыкантов создаём списки певцов, гитаристов итд.
        createMusicianList(scene);


//        Если нет ни одного баса или барабанщика итд, то шоу сделать невозможно
        if (singers.size() == 0 || leadGuitars.size() == 0 || rhythmGuitars.size() == 0
                || bassGuitars.size() == 0 || percussion.size() == 0) {
            ManagerLOG.debug("Not enough musicians");
            return false;
        }

//        Сортируем списки музыкантов по цене
        sortAllListByPriceDesc();

//        Формируем список списка музыкантов
        createMusicianList();

//        Из этого списка берём самого последнего музыканта(он же самый дешёвый)
//        и создаём контейнер cheapestBand
        createCheapestBandList();

        double musicianPrice = Kapellmeister.calculateTotal(cheapestBand, new Price());
        double musicianResult = musicianPrice / 60 * time;

        ManagerLOG.debug("Cheapest Band");
        ManagerLOG.debug(cheapestBand);
        ManagerLOG.debug(String.format("Cheapest band price is %.1f$/60min\n\n", musicianPrice));

        ManagerLOG.debug(String.format("Declared price is %.1f$/%dmin\nCheapest musicians cost %.1f$/%dmin\n\n",
                declaredPrice, time, musicianResult, time));

        return declaredPrice > musicianResult;
    }

    private static void createMusicianList(Scene scene) {
        ManagerLOG.info("Start createMusicianList()");
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
    }

    private static void createCheapestBandList() {
        for (Scene oneInstanceOfMusician : musicianList) {
            cheapestBand.add(oneInstanceOfMusician.get(oneInstanceOfMusician.size() - 1));
        }
    }

    private static void sortAllListByPriceDesc() {
        ManagerLOG.info("Start sortAllListByPriceDesc()");
        StageSorter.sort(singers, new SortBySalaryDesc());
        StageSorter.sort(leadGuitars, new SortBySalaryDesc());
        StageSorter.sort(rhythmGuitars, new SortBySalaryDesc());
        StageSorter.sort(bassGuitars, new SortBySalaryDesc());
        StageSorter.sort(percussion, new SortBySalaryDesc());

        ManagerLOG.debug("Singers list. " + singers);
        ManagerLOG.debug("Lead guitars list. " + leadGuitars);
        ManagerLOG.debug("Rhythm guitars list. " + rhythmGuitars);
        ManagerLOG.debug("Bass guitars list. " + bassGuitars);
        ManagerLOG.debug("Drums list. " + percussion);
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
