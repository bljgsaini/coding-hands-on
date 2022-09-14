package systemDesign.designPattern.singleton;


//The above implementation works fine in case of the single-threaded environment
//        but when it comes to multithreaded systems,
//        it can cause issues if multiple threads are inside the if condition at the same time.
//        It will destroy the singleton pattern and both threads will get the different instances of the singleton class
public class LazyInitializationSingleton {

    private static LazyInitializationSingleton lazyInitializationSingleton;

    private LazyInitializationSingleton(){}

    public static LazyInitializationSingleton getLazyInitializationSingletonInstance(){
        if(lazyInitializationSingleton == null){
            lazyInitializationSingleton = new LazyInitializationSingleton();
        }
        return lazyInitializationSingleton;
    }

}
