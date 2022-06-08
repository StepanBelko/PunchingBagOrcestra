package by.itstep.stpnbelko.javastages.stage20.model.entity.container;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;
import by.itstep.stpnbelko.javastages.stage20.model.entity.iteratorPattern.MyIterator;
import by.itstep.stpnbelko.javastages.stage20.model.entity.iteratorPattern.SceneDynamicArrayPattern;

import static by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.MusicianFactory.createRandomMusician;

public class SceneDynamicArray implements Container, Iterable {
    private Musician[] musicians;

    public SceneDynamicArray(int amount) {
        musicians = new Musician[0];
        for (int i = 0; i < amount; i++) {
            this.add(createRandomMusician());
        }
    }

    public SceneDynamicArray() {
        musicians = new Musician[0];
    }

    public Musician[] getMusicians() {
        return musicians;
    }

    public void set(Musician musician, int index) {
        musicians[index] = musician;
    }

//       Нужен ли этот сеттер вообще?
//    public void setMusicians(Musician[] musicians) {
//        this.musicians = musicians;
//    }

    public void add(Musician musician) {
        Musician[] temp = new Musician[musicians.length + 1];
        int i = 0;
        for (; i < musicians.length; i++) {
            temp[i] = musicians[i];
        }
        temp[i] = musician;
        musicians = temp;
        System.out.println("added " + musician.getName());
    }

    public void remove(int index) {
        Musician[] temp = new Musician[musicians.length - 1];
        System.out.println("expelling " + musicians[index].getName());
        for (int i = 0, j = 0; i < musicians.length; i++) {
            if (i != index) {
                temp[j] = musicians[i];
                j++;
            }
        }
        musicians = temp;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Musician element : musicians) {
            stringBuilder.append(element.toString()).append("\n");
        }
        return "One the stage now " + musicians.length +
                " musicians \n" + stringBuilder;
    }

    @Override
    public int size() {
        return musicians.length;
    }

    @Override
    public Musician get(int index) {
        return musicians[index];
    }

    @Override
    public MyIterator getIterator() {
        return new SceneDynamicArrayPattern(this);
    }
}
