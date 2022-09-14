package systemDesign.designPattern.singleton;

/*Eager initialization
 if singleton class is not using a lot of resource this is the approach to use. Generally Singleton classes are used for database connection
file systems etc. So you should not be creating the object of Singleton classes unless called by the client.*/
class EagerInitializationSingleton {

    private static EagerInitializationSingleton eagerInitializationSingleton = new EagerInitializationSingleton();

    private EagerInitializationSingleton() {
    }

    public static EagerInitializationSingleton getEagerInitializationSingletonInstance() {
        return eagerInitializationSingleton;
    }

}
