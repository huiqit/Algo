// TT.java
/*
问：当m1执行的过程中，m2能够执行吗？
答：不同的线程可以，这才叫多线程。。。只锁住了m1这个方法，另一个线程可以去访问哪些没有锁定的方法
要对访问这个对象所有的方法都仔细考虑
线程可以自由访问那些没加锁的method，并且可能对加了锁的产生影响（把b的值改了，那加锁的那里在print b 也变成2000了）
加锁只是另外的线程不会执行我这段代码了
加锁：只有1个线程能够执行这个方法
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
