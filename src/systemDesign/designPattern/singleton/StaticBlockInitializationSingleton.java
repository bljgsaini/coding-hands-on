package systemDesign.designPattern.singleton;

//Both eager initialization and static block initialization creates the instance even before it’s being used and that is not the best practice to use.
class StaticBlockInitializationSingleton {

    private static StaticBlockInitializationSingleton staticBlockInitializationSingleton;

    private StaticBlockInitializationSingleton() {}

    // static block is used to initialization the Singleton to handle the exception handling
    static {
        try {
            staticBlockInitializationSingleton = new StaticBlockInitializationSingleton();
        } catch (Exception e) {
        }
    }

    public static StaticBlockInitializationSingleton getEagerInitializationSingletonInstance() {
        return staticBlockInitializationSingleton;
    }

}
