package by.itstep.stpnbelko.javastages.stage20.model.entity.iteratorPattern;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;
import by.itstep.stpnbelko.javastages.stage20.model.entity.container.SceneLinkedList;

public class SceneLinkedListPattern implements MyIterator {
    private final SceneLinkedList linkedList;
    private int current;

    public SceneLinkedListPattern(SceneLinkedList linkedList) {
        this.linkedList = linkedList;
        current = 0;
    }

    @Override
    public Musician next() {
        return linkedList.get(current++);
    }

    @Override
    public boolean hasNext() {
        return current < linkedList.size();
    }

    @Override
    public void reset() {
        current = 0;
    }
    
}
