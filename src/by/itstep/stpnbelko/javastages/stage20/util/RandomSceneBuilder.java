package by.itstep.stpnbelko.javastages.stage20.util;

import by.itstep.stpnbelko.javastages.stage20.control.ThirdControllerRandom;
import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;
import by.itstep.stpnbelko.javastages.stage20.model.entity.container.Scene;

public class RandomSceneBuilder extends ThirdControllerRandom {
    private static final int AMOUNT = 100;
    @Override
    public Scene create() {
        Scene scene = new Scene();
        for (int i = 0; i < AMOUNT; i++) {
            Musician musician = MusicianFactory.createRandomMusician();
            scene.add(musician);
        }
        return scene;
    }

}
