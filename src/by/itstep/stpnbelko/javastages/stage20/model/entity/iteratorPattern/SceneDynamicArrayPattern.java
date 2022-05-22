package by.itstep.stpnbelko.javastages.stage20.model.entity.iteratorPattern;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;
import by.itstep.stpnbelko.javastages.stage20.model.entity.container.SceneDynamicArray;

public class SceneDynamicArrayPattern implements MyIterator {
    private SceneDynamicArray array;
    private int current;

    public SceneDynamicArrayPattern(SceneDynamicArray array) {
        this.array = array;
        current = 0;
    }

    @Override
    public Musician next() {
        return array.get(current);
    }

    @Override
    public boolean hasNext() {
        return current < array.size();
    }

    @Override
    public void reset() {
        current = 0;
    }

    @Override
    public String getName() {
        return array.get(current - 1).getName();
    }
}
