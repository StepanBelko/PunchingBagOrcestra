package by.itstep.stpnbelko.javastages.stage20.util;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;
import by.itstep.stpnbelko.javastages.stage20.model.entity.container.Scene;

public class UserSceneBuilder implements SceneBuilder {

    public Scene create(int amount) {
        Scene scene = new Scene();

        Musician singer = MusicianFactory.createRandomSinger();
        Musician guitar1 = MusicianFactory.createLeadGuitar();
        Musician guitar2 = MusicianFactory.createRhythmGuitar();
        Musician bass = MusicianFactory.createBassGuitar();
        Musician drums = MusicianFactory.createRandomPercussion();

        scene.add(singer);
        scene.add(guitar1);
        scene.add(guitar2);
        scene.add(bass);
        scene.add(drums);

        return scene;
    }

}
