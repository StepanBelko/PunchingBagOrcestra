package by.itstep.stpnbelko.javastages.stage20.util;

public class BuilderSimpleFactory {

    public enum BuilderType {
        RND,
        USER,
        FILE
    }

    public static SceneBuilder getBuilder(BuilderType type) {

        return switch (type) {
            case FILE -> new FileSceneBuilder();
            case RND -> new RandomSceneBuilder();
            case USER -> new UserSceneBuilder();
        };
    }
}
