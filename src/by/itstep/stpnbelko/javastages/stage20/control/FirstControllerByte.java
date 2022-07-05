package by.itstep.stpnbelko.javastages.stage20.control;

import by.itstep.stpnbelko.javastages.stage20.model.entity.container.Scene;
import by.itstep.stpnbelko.javastages.stage20.util.ByteStreamSceneBuilder;

public class FirstControllerByte extends SceneController {
    @Override
    public Scene createCurrentScene() {
        return new ByteStreamSceneBuilder().createCurrentScene();
    }

    @Override
    public Scene getCurrentScene() {
        return new ByteStreamSceneBuilder().createCurrentScene();
    }
}
