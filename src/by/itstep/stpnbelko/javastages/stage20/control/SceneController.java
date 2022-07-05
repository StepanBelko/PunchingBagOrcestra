package by.itstep.stpnbelko.javastages.stage20.control;

import by.itstep.stpnbelko.javastages.stage20.model.entity.container.Scene;
import by.itstep.stpnbelko.javastages.stage20.model.logic.Kapellmeister;
import by.itstep.stpnbelko.javastages.stage20.model.logic.Manager;
import by.itstep.stpnbelko.javastages.stage20.model.logic.StageSorter;
import by.itstep.stpnbelko.javastages.stage20.model.logic.calculateTotalStrategy.*;
import by.itstep.stpnbelko.javastages.stage20.model.logic.instanceStrategy.*;
import by.itstep.stpnbelko.javastages.stage20.model.logic.sortStrategy.*;
import by.itstep.stpnbelko.javastages.stage20.util.ByteStreamSceneBuilder;
import by.itstep.stpnbelko.javastages.stage20.util.CharStreamSceneBuilder;
import by.itstep.stpnbelko.javastages.stage20.util.exceptions.tecnicalException.SceneFileNotFoundException;
import by.itstep.stpnbelko.javastages.stage20.util.serialization.SceneSerializator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.IOException;

import static by.itstep.stpnbelko.javastages.stage20.model.logic.Kapellmeister.howManySomeInstance;

public abstract class SceneController {
    private static final Logger SceneLOG;

    static {
        SceneLOG = Logger.getRootLogger();
        SceneLOG.setLevel(Level.DEBUG);
    }

    //factory method
    public abstract Scene createCurrentScene();

    public abstract Scene getCurrentScene();

    public void saveCurrentScene() throws SceneFileNotFoundException, IOException {
        Scene scene = getCurrentScene();
        new ByteStreamSceneBuilder().save(scene);
        new CharStreamSceneBuilder().save(scene);
        SceneSerializator.write(scene);
        SceneLOG.info("Successfully saved");
    }

    public double calculateTotalPrice() {
        Scene scene = getCurrentScene();
        double total = Kapellmeister.calculateTotal(scene, new Price());
        SceneLOG.debug("total price = " + total);
        return total;
    }

    public boolean canMakePerform(int time, double declaredPrice) {
        Scene scene = getCurrentScene();
        SceneLOG.debug("Current scene\n" + scene);

        boolean isPerformPossible = Manager.canMakePerform(time, declaredPrice, scene);

        SceneLOG.debug("Is perform possible? " + isPerformPossible);
        return isPerformPossible;
    }

    public int calculateTotalExperience() {
        Scene scene = getCurrentScene();
        int totalExp = (int) Kapellmeister.calculateTotal(scene, new Experience());
        String msg = "Total musicians experience is " + totalExp + " year(s)";
        SceneLOG.info(msg);
        return totalExp;
    }

    public double calculateTotalVolume() {
        Scene scene = getCurrentScene();
        double totalVolume = Kapellmeister.calculateTotal(scene, new Volume());
        String msg = "Total musicians volume is " + totalVolume + "dB";
        SceneLOG.info(msg);
        return totalVolume;
    }

    public void playMusic() {
        Scene scene = getCurrentScene();
        Kapellmeister.playMusic(scene);
    }

    public int howManyPercussionists() {
        Scene scene = getCurrentScene();
        int count = howManySomeInstance(scene, new InstanceOfPercussion());
        SceneLOG.debug("How many percussionists? " + count);
        return count;
    }

    public int howManySingers() {
        Scene scene = getCurrentScene();
        int count = howManySomeInstance(scene, new InstanceOfSinger());
        SceneLOG.debug("How many singers? " + count);
        return count;
    }

    public int howManyViolins() {
        Scene scene = getCurrentScene();
        int count = howManySomeInstance(scene, new InstanceOfViolin());
        SceneLOG.debug("How many violins? " + count);
        return count;
    }

    public int howManyUnknownInstances() {
        Scene scene = getCurrentScene();
        int count = howManySomeInstance(scene, new UnknownInstance());
        SceneLOG.debug("How many unknown musicians? " + count);
        return count;
    }

    public void sortByVolumeAsc() {
        Scene scene = getCurrentScene();
        StageSorter.sort(scene, new SortByVolumeAsc());
        SceneLOG.debug("Sorted by volume Asc \n" + scene);
    }

    public void sortByVolumeDesc() {
        Scene scene = getCurrentScene();
        StageSorter.sort(scene, new SortByVolumeDesc());
        SceneLOG.debug("Sorted by volume Desc \n" + scene);
    }

    public void sortByExperienceAsc() {
        Scene scene = getCurrentScene();
        StageSorter.sort(scene, new SortByExperienceAsc());
        SceneLOG.debug("Sorted by experience Asc \n" + scene);
    }

    public void sortByExperienceDesc() {
        Scene scene = getCurrentScene();
        StageSorter.sort(scene, new SortByExperienceDesc());
        SceneLOG.debug("Sorted by experience Desc \n" + scene);
    }

    public void sortBySalary() {
        Scene scene = getCurrentScene();
        StageSorter.sort(scene, new SortBySalaryDesc());
        SceneLOG.debug("Sorted by salary Desc \n" + scene);
    }
}
