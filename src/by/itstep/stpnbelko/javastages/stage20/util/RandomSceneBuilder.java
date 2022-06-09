package by.itstep.stpnbelko.javastages.stage20.util;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;
import by.itstep.stpnbelko.javastages.stage20.model.entity.container.Scene;
import by.itstep.stpnbelko.javastages.stage20.model.entity.container.SceneDynamicArray;
import by.itstep.stpnbelko.javastages.stage20.model.entity.container.SceneLinkedList;

public class RandomSceneBuilder implements SceneBuilder {

    @Override
    public Scene create(int amount) {
        Scene scene = new SceneLinkedList();
        for (int i = 0; i < amount; i++) {
            Musician musician = MusicianFactory.createRandomMusician();
            scene.add(musician);
        }
        return scene;
    }
}
