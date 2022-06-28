package by.itstep.stpnbelko.javastages.stage20.control;

import by.itstep.stpnbelko.javastages.stage20.model.entity.container.Scene;
import by.itstep.stpnbelko.javastages.stage20.util.serialization.SceneSerializator;

public class FifthControllerSerialization extends SceneController {
    @Override
    public Scene create() {
        return new SceneSerializator().read();
    }
}
