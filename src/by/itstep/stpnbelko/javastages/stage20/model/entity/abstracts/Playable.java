package by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts;

public interface Playable {

    default void playMusic(String name) {
        System.out.println(name + " plays music now");
    }
}
