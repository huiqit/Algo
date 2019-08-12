
public class TestThread1 {
  public static void main(String args[]) {
    Runner1 r = new Runner1; //线程类的对象
    r.start(); //直接就是一个thread了，不需要再启动一个新线程了
//     r.run();
//     Thread t = new Thread(r);
//     t.start(); //线程启动，必须调用Thread类的start() 
    
    for(int i = 0; i < 100; i++) {
       System.out.println("Main Thread:-----" + i);
    }
  }
}

// class Runner1 implements Runnable {
class Runner1 extends Thread {
  @Override
  public void run() {
    for(int i = 0; i < 100; i++) {
       System.out.println("Runner1 :" + i);
    }
  }
}


      
