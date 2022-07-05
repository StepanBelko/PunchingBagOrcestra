package by.itstep.stpnbelko.javastages.stage20.util;

import by.itstep.stpnbelko.javastages.stage20.control.ThirdControllerRandom;
import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;
import by.itstep.stpnbelko.javastages.stage20.model.entity.container.Scene;

public class RandomSceneBuilder extends ThirdControllerRandom {
    private static Scene currentScene;
    private static final int AMOUNT = 10;
    @Override
    public Scene createCurrentScene() {
        System.out.println("CreatRandom");
        Scene scene = new Scene();
        for (int i = 0; i < AMOUNT; i++) {
            Musician musician = MusicianFactory.createRandomMusician();
            scene.add(musician);
        }
        currentScene = scene;
        return scene;
    }

    @Override
    public Scene getCurrentScene() {
        return currentScene;
    }
}
