package by.itstep.stpnbelko.javastages.stage20.model.entity.container;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;

public class SceneLinkedList {
    Node first;
    int size;

    private class Node {
        Musician musician;
        Node next;

        public Node(Musician musician) {
            this.musician = musician;
        }
    }
}
