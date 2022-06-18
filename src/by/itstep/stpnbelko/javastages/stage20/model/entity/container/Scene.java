package by.itstep.stpnbelko.javastages.stage20.model.entity.container;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;
import org.jetbrains.annotations.NotNull;

import java.lang.Iterable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Scene implements Iterable<Musician> {
    private final List<Musician> musicians;

    public Scene() {
        musicians = new ArrayList<>();
    }

    public Scene(List<Musician> list) {
        musicians = list;
    }

    public Musician get(int index) {
        return musicians.get(index);
    }

    public void set(Musician musician, int index) {
        musicians.set(index, musician);
    }

    public void add(Musician musician) {
        musicians.add(musician);
    }

    public void remove(int index) {
        musicians.remove(index);
    }

    public int size() {
        return musicians.size();
    }

    @NotNull
    @Override
    public Iterator<Musician> iterator() {
        return musicians.iterator();
    }

    @Override
    public String toString() {StringBuilder stringBuilder = new StringBuilder();
        for (Musician element : musicians) {
            stringBuilder.append(element.toString()).append("\n");
        }
        return "One the stage now " + musicians.size() +
                " musicians \n" + stringBuilder;
    }
}
