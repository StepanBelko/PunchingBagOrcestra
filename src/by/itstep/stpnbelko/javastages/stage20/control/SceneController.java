package by.itstep.stpnbelko.javastages.stage20.control;

import by.itstep.stpnbelko.javastages.stage20.model.entity.container.Scene;
import by.itstep.stpnbelko.javastages.stage20.model.logic.Kapellmeister;
import by.itstep.stpnbelko.javastages.stage20.model.logic.Manager;
import by.itstep.stpnbelko.javastages.stage20.model.logic.calculateTotalStrategy.Price;
import by.itstep.stpnbelko.javastages.stage20.util.serialization.SceneSerializator;

public abstract class SceneController {
    //factory method
    public abstract Scene create();


    public void makeSomeCalculates() {
        Scene scene = create();
        double total = Kapellmeister.calculateTotal(scene, new Price());
        SceneSerializator.write(scene);
        System.out.println(scene);
        System.out.println("total price = " + total);
    }

    public boolean canMakePerform(int time, double declaredPrice) {
        Scene scene = create();

        System.out.println(scene);

        boolean isPerformPosible = Manager.canMakePerform(time, declaredPrice, scene);

        System.out.println(isPerformPosible);
        return isPerformPosible;
    }
}
