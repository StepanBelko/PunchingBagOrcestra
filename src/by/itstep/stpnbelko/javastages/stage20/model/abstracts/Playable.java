package by.itstep.stpnbelko.javastages.stage20.model.abstracts;

public interface Playable {


    default void playMusic(Musician musician) {
        System.out.println(musician.getName() + " plays music now");
    }
}
