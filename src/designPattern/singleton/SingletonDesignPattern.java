package designPattern.singleton;

//https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
public class SingletonDesignPattern {

}


/*Eager initialization
 if singleton class is not using a lot of resource this is the approach to use. Generally Singleton classes are used for database connection
file systems etc. So you should not be creating the object of Singleton classes unless called by the client.*/
class EagerInitializationSingleton{

    private static EagerInitializationSingleton eagerInitializationSingleton = new EagerInitializationSingleton();

    private EagerInitializationSingleton(){}

    public static EagerInitializationSingleton getEagerInitializationSingletonInstance(){
        return eagerInitializationSingleton;
    }

}


//Both eager initialization and static block initialization creates the instance even before it’s being used and that is not the best practice to use.
class StaticBlockInitializationSingleton{

    private static StaticBlockInitializationSingleton staticBlockInitializationSingleton;

    private StaticBlockInitializationSingleton(){}

    // static block is used to initialization the Singleton to handle the exception handling
    static {
        try{
            staticBlockInitializationSingleton = new StaticBlockInitializationSingleton();
        }catch (Exception e){}
    }

    public static StaticBlockInitializationSingleton getEagerInitializationSingletonInstance(){
        return staticBlockInitializationSingleton;
    }

}
