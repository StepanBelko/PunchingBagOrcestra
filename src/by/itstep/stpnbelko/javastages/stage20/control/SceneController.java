package by.itstep.stpnbelko.javastages.stage20.control;

import by.itstep.stpnbelko.javastages.stage20.model.entity.container.Scene;
import by.itstep.stpnbelko.javastages.stage20.model.logic.Kapellmeister;
import by.itstep.stpnbelko.javastages.stage20.model.logic.Manager;
import by.itstep.stpnbelko.javastages.stage20.model.logic.calculateTotalStrategy.Price;
import by.itstep.stpnbelko.javastages.stage20.util.serialization.SceneSerializator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public abstract class SceneController {
    private static final Logger SceneLOG;

    static {
        SceneLOG = Logger.getRootLogger();
    }
    //factory method
    public abstract Scene create();


    public void calculateTotalPrice() {
        Scene scene = create();
        double total = Kapellmeister.calculateTotal(scene, new Price());
        SceneSerializator.write(scene);
        SceneLOG.debug(scene);
        SceneLOG.debug("total price = " + total);
    }

    public boolean canMakePerform(int time, double declaredPrice) {
        Scene scene = create();
        SceneLOG.debug(scene);

        boolean isPerformPossible = Manager.canMakePerform(time, declaredPrice, scene);

        SceneLOG.debug(isPerformPossible);
        return isPerformPossible;
    }
}
