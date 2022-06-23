package by.itstep.stpnbelko.javastages.stage20.util.serialization;

import by.itstep.stpnbelko.javastages.stage20.model.entity.container.Scene;

import java.io.*;

public class SceneSerializator {
    private static String serializationPath;

    static {
        serializationPath = "Scene.dat";
    }

    public static void write(Scene scene) {
        try (ObjectOutputStream stream = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(serializationPath)))) {
            stream.writeObject(scene);
        } catch (IOException exception) {
            System.err.println(exception);
        }
    }

    public static Scene read() {
        Scene scene = null;
        try (ObjectInputStream stream = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(serializationPath)))) {
            scene = (Scene) stream.readObject();
        } catch (ClassNotFoundException | IOException exception) {
            System.err.println(exception);
        }
        return scene;
    }
}
