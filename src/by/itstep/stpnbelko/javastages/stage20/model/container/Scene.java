package by.itstep.stpnbelko.javastages.stage20.model.container;

import by.itstep.stpnbelko.javastages.stage20.model.abstracts.Musician;

public class Scene {
    private Musician[] musicians;

    public Scene() {
        musicians = new Musician[0];
    }

    public Musician[] getMusicians() {
        return musicians;
    }

    public void setMusicians(Musician[] musicians) {
        this.musicians = musicians;
    }

    public void inviteMusician(Musician musician) {
        Musician[] temp = new Musician[musicians.length + 1];
        int i = 0;
        for (; i < musicians.length; i++) {
            temp[i] = musicians[i];
        }
        temp[i] = musician;
        musicians = temp;
        System.out.println("added " + musician.getName());
    }

    public void expelMusician(int index) {
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
        return "One the stage now " +
                "musicians \n" + stringBuilder;
    }
}
