package by.itstep.stpnbelko.javastages.stage20.model.entity.container;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;
import by.itstep.stpnbelko.javastages.stage20.model.entity.iteratorPattern.MyIterator;
import by.itstep.stpnbelko.javastages.stage20.model.entity.iteratorPattern.SceneLinkedListPattern;

public class SceneLinkedList implements Scene, Iterable {
    Node first;
    int size;

    public SceneLinkedList() {
        first = null;
        size = 0;
    }

    public void add(Musician musician) {
        if (size == 0) {
            first = new Node(musician);
        } else {
            Node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(musician);
        }
        size++;
    }

    public void remove(int index) {
        if (index >= size || index < 0) {
            System.out.println("invalid index " + index);
            return;
        } else if (index == 0) {
            first = first.next;
        } else {
            Node temp = first;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }

            Node temp2 = temp.next;
            temp.next = temp2.next;

        }
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (isEmpty()) {
            stringBuilder.append("Scene is empty");
            return stringBuilder.toString();
        } else {
            Node temp = first;
            while (temp.next != null) {
                stringBuilder.append(temp.musician).append("\n");
                temp = temp.next;
            }
            stringBuilder.append(temp.musician).append("\n");
            return "One the stage now " +
                    "musicians \n" + stringBuilder;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Musician get(int index) {
        if (isEmpty() || index >= size || index < 0) {
            return null;
        }
        Node temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.musician;
    }

    @Override
    public MyIterator getIterator() {
        return new SceneLinkedListPattern(this);
    }

    private static class Node {
        Musician musician;
        Node next;

        public Node(Musician musician) {
            this.musician = musician;
        }
    }
}
