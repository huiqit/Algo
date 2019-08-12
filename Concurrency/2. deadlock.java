/*
javac TestDeadLock.java
java TestDeadLock
死锁 哲学家吃饭问题

*/
public static void main(String[] args) {
  TestDeadLock td1 = new TestDeadlock();
  TestDeadLock td2 = new TestDeadlock();
  td1.flag = 1;
  td2.flag = 2;
  Thread t1 = new Thread(td1);
  Thread t2 = new Thread(td2);
  t1.start();
  t2.start();
}

public class TestDeadlock implement Runnable {
  public int flag = 1;
  static Object o1 = new Object();
  static Object o2 = new Object();
  public void run() {
    System.out.println("flag="+flag);
    if(flag == 1) {
      synchronized(o1) {
        try {
          Thread.sleep(500);
        } catch (Exception e) {
          e.printStackTrace();
        }
        synchronized(o2) {
          System.out.println("1");
        }
      }
    }
    if(flag == 2) {
      synchronized(o2) {
        try {
          Thread.sleep(500);
        } catch (Exception e) {
          e.printStackTrace();
        }
        synchronized(o1) {
          System.out.println("2");
        }
      }
    }
  }
      


