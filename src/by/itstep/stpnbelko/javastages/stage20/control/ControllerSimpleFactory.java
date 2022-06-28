package by.itstep.stpnbelko.javastages.stage20.control;

import java.util.HashMap;

public class ControllerSimpleFactory {

    public enum FactoryType {
        RND,
        USER,
        FROM_FILE_BYTE,
        FROM_FILE_CHAR,
        SERIALIZATION
    }

    private static HashMap<FactoryType, SceneController> map;

    static {
        map = new HashMap<>();
        map.put(FactoryType.RND, new ThirdControllerRandom());
        map.put(FactoryType.FROM_FILE_BYTE, new FirstControllerByte());
        map.put(FactoryType.FROM_FILE_CHAR, new SecondControllerChar());
    }

    public static SceneController getController(FactoryType key) {
        return map.get(key);
    }

    public static void addController(FactoryType key, SceneController value) {
        map.put(key, value); 
    }
}
