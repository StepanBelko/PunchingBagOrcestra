package by.itstep.stpnbelko.javastages.stage20.util;

import by.itstep.stpnbelko.javastages.stage20.model.entity.container.Scene;
import by.itstep.stpnbelko.javastages.stage20.util.exceptions.SceneFileNotFoundException;

public interface SceneBuilder {
    Scene create(int amount) throws SceneFileNotFoundException;
}
