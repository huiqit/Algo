/*
设计一个面包筐
*/

public class ProducerConsumer {
  public static void main(String[] args) {
    Basket basket = new Basket();
    Producer p = new Producer(basket);
    Consumer c = new Consumer(basket);
    new Thread(p).start();
    new Thread(c).start();
  }
}

public class Bread {
  int id;
  Bread(int id) {
    this.id = id;
  }
}

public class Basket {
  int index = 0;
  Bread[] array = new Bread[6];
  
  public synchronized void push(Bread bd) {
    while(index == array.length) {
      try {
        this.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    this.notify();
    array[index++] = bd;
  }
  
  public synchronized Bread pop() {
    while(index == 0) {
      try {
        this.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    this.notify();
    index--;
    return array[index];
  }
}

public class Consumer implement Runnable {
  Basket basket = null;
  Consumer(Basket basket) {
    this.basket = basket;
  }
  
  public void run() {
    for(int i = 0; i < 20; i++) {
      basket.push(new Bread(i));
    }
  }
}
  
public class Producer implement Runnable {
  Basket basket = null;
  Producer(Basket basket) {
    this.basket = basket;
  }
  
  public void run() {
    for(int i = 0; i < 20; i++) {
      basket.pop();
    }
  }
}




  
  
