class Animal {
  String name;
  void makeSound() {}
    System.out.println("animal sound");
}
class Dog extends Animal {
  
  @Override 
  void makeSound() {
    System.out.println("wangwang");
  }
  
}

class Cat extends Animal {
  
  @Override 
  void makeSound() {
    System.out.println("miaomiao");
  }
  
}

public class Polymophysm {
  public static void main(String[] args) {
    System.out.println("Hello");
    new Dog();
    //怎么访问它
    Dog d = new Dog();
    d.name = "wangwang"; 
    d.makeSound(); // bind the method in class Dog
    Animal a = new Dog(); // new 谁就绑定谁 多态
    // 只能访问Animal的那部分属性
    // 非要访问dog的属性：
    Dog d = (Dog)a;
    d.swimmingSpeed = 3; 
    
    
  }
}






