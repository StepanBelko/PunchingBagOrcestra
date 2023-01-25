package by.itstep.stpnbelko.javastages.stage20.model.entity.container;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;

import java.io.Serializable;
import java.lang.Iterable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Scene implements Iterable<Musician>, Serializable {
    static final long serialVersionUID = 1L;

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
        if (index < musicians.size() && musician != null) {
            musicians.set(index, musician);
        }
    }

    public void add(Musician musician) {
        musicians.add(musician);
    }

    public void remove(int index) {

        if (index < musicians.size()) {
            musicians.remove(index);
        }
    }

    public int size() {
        return musicians.size();
    }

    public boolean isEmpty() {
        return musicians.size() == 0;
    }

    public void clear() {
        for (int i = 0; i < musicians.size(); i++) {
            musicians.remove(i);
        }
    }

    @Override
    public Iterator<Musician> iterator() {
        return musicians.iterator();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Musician element : musicians) {
            stringBuilder.append(element.toString()).append("\n");
        }
        return musicians.size() +
                " musicians: \n" + stringBuilder;
    }


}
