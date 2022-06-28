package by.itstep.stpnbelko.javastages.stage20.control;

import by.itstep.stpnbelko.javastages.stage20.model.entity.container.Scene;
import by.itstep.stpnbelko.javastages.stage20.util.RandomSceneBuilder;

public class ThirdControllerRandom extends SceneController {

    @Override
    public Scene create() {
        return new RandomSceneBuilder().create();
    }
}
