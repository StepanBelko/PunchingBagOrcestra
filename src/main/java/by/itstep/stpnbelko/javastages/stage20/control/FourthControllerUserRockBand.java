package by.itstep.stpnbelko.javastages.stage20.control;

import by.itstep.stpnbelko.javastages.stage20.model.entity.container.Scene;
import by.itstep.stpnbelko.javastages.stage20.util.UserSceneBuilder;

public class FourthControllerUserRockBand extends SceneController {
    @Override
    public Scene createCurrentScene() {
        return new UserSceneBuilder().createCurrentScene();
    }

    @Override
    public  Scene getCurrentScene() {
        return new UserSceneBuilder().getCurrentScene();
    }
}
