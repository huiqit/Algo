// TT.java
/*
问：当m1执行的过程中，m2能够执行吗？
答：不同的线程可以，这才叫多线程。。。只锁住了m1这个方法，另一个线程可以去访问哪些没有锁定的方法
*/

public class TT implements Runnable {
  int b = 100;
  
  public Synchronized void m1() throws Exception {
    b = 1000;
    Thread.sleep(5000);
    System.out.println("b = " + b);
  }

  public void m2() {
    System.out.println(b);
  }
  
  @Override
  public void run() {
      try {
        m1();
      } catch (Exception e) {
        e.printStackTrace();
      }
  }
  public static void main(String[] args) throws Exception {
    TT tt = new TT();
    Thread t = new Thread(tt);
    t.start();
    
    Thread.sleep(1000); //确保进入了m1
    tt.m2();
    //如果b=100，说明不能执行，得等m1执行完了才能执行
    //实际：b=1000
  }
}
