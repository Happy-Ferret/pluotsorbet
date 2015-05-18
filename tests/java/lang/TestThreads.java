package java.lang;

import gnu.testlet.Testlet;
import gnu.testlet.TestHarness;

public class TestThreads implements Testlet {
  public int getExpectedPass() {
    return 1;
  }

  public int getExpectedFail() {
    return 0;
  }

  public int getExpectedKnownFail() {
    return 0;
  }

  public static int count = 0;
  public void test(TestHarness th) {
    Thread[] threads = new Thread[32];
    System.out.println("Starting " + threads.length + " threads.");
    for (int i = 0; i < threads.length; i++) {
      Thread t = new Thread() {
        public void run() {

          for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
            Thread.yield();
            TestThreads.count ++;
          }
        }
      };
      System.out.println("Starting Thread: " + (i + 1));
      t.start();
      threads[i] = t;
    }

    System.out.println("Started all threads.");

    long start = System.currentTimeMillis();
    try {
      for (int i = 0; i < threads.length; i++) {
        threads[i].join();
      }
    } catch (InterruptedException e) {
    }
    // th.check(System.currentTimeMillis() - start < 500);
    System.out.println("Count: " + TestThreads.count);
    th.check(TestThreads.count == threads.length * 10);
  }
}
