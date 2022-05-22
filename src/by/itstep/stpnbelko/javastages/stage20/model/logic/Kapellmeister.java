package by.itstep.stpnbelko.javastages.stage20.model.logic;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;
import by.itstep.stpnbelko.javastages.stage20.model.entity.container.Iterable;
import by.itstep.stpnbelko.javastages.stage20.model.entity.container.SceneDynamicArray;
import by.itstep.stpnbelko.javastages.stage20.model.entity.iteratorPattern.MyIterator;
import by.itstep.stpnbelko.javastages.stage20.model.entity.iteratorPattern.SceneDynamicArrayPattern;
import by.itstep.stpnbelko.javastages.stage20.model.logic.calculateTotalStrategy.MusicianCalculable;
import by.itstep.stpnbelko.javastages.stage20.model.logic.instanceStrategy.MusicianInstance;

public class Kapellmeister {
    private Kapellmeister() {
    }

    public static double calculateTotal(Iterable iterable, MusicianCalculable calculable) {
        double total = 0;
        MyIterator iterator = iterable.getIterator();

        while (iterator.hasNext()) {
            total += calculable.calculate(iterator.next());
        }

        return total;
    }

    public static void playMusic(Iterable iterable) {
        MyIterator iterator = iterable.getIterator();
        while (iterator.hasNext()) {
            iterator.next().playMusic(iterator.getName());
        }
    }

    public static int howManySomeInstance(SceneDynamicArray scene, MusicianInstance musicianInstance) {
        int count = 0;
        for (Musician musician : scene.getMusicians()) {
            if (musicianInstance.isInstanceOfSpecial(musician)) {
                count++;
            }
        }
        return count;
    }
}
