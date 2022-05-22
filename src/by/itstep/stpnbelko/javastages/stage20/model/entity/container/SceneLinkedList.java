package by.itstep.stpnbelko.javastages.stage20.model.entity.container;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;

public class SceneLinkedList implements Container {
    Node first;
    int size;

    public SceneLinkedList() {
        first = null;
        size = 0;
    }

    public void add(Musician musician) {
        if (size == 0) {
            first =new Node(musician);
        } else {
            Node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(musician);
        }
        size++;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node temp = first;
        while (temp.next != null) {
            stringBuilder.append(temp.musician).append("\n");
            temp = temp.next;
        }
        stringBuilder.append(temp.musician).append("\n");
        return "One the stage now " +
                "musicians \n" + stringBuilder;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Musician get(int index) {
        Node temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.musician;
    }

    private class Node {
        Musician musician;
        Node next;

        public Node(Musician musician) {
            this.musician = musician;
        }
    }
}
