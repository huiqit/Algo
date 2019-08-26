public class Test {
    public static void main(String[] args) {
        Single a = new Single("kaijun");
        Single b = new Single("chenyu");
       Single x = Single.getInstance();
       MySingle s = MySingle.getInstance();
       MySingleton chou = MySingleton.getInstance();
       System.out.println(x.name);
       System.out.println(s.name);
       System.out.println(chou.name);
    }
}
/*
1. set to private constructor
2. out of class cannot call private constructor, but in the class can call it
3. static? if non-static, should use an instance to call it
*/
class Single {
    String name;

    private Single(String n) {
        name = n;
    }

    private static Single honghui = new Single("honghui"); // same class can call private

    public static Single getInstance() {
        return honghui;
    }


}

class MySingle {
    String name;

    private MySingle(String name) {
        this.name = name;
    }

    private static MySingle shirley; //must be private, if public, user can get this field, and set to other value

    public static synchronized MySingle getInstance() {
        if(shirley == null) {
            shirley = new MySingle("shirley");
        }
        return shirley;
    }
}

// double check locking
class MySingleton {
    String name;

    private MySingleton(String name) {
        this.name = name;
    }

    private static MySingleton instance;

    public static MySingleton getInstance() {
        if(instance == null) {
            synchronized (MySingleton.class) {
                if (instance == null) {
                    instance = new MySingleton("shirley");
                }
            }
        }
        return instance;
    }
}

class Singleton {

    private Singleton() {

    }

    private static Singleton instance;

    public static Singleton getInstance() {
        if(instance == null) {
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}




