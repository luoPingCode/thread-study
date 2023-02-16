package homework;

/**
 * @author LuoPing
 * @project IntelliJ IDEA
 * @Package thread-study
 * @Date 2022/12/23 23:37
 */
public class Thread03 {
    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        t1.start();
        for (int i = 0; i < 11; i++) {
            System.out.println("主线程（小弟）吃" + i + "包子" );
            if (i == 5) {
                System.out.println("主线程（小弟）让子线程（老大）先吃");
                t1.join();
//                Thread.yield();
                System.out.println("子线程（老大）吃完了，主线程小弟吃");
            }
        }
    }
}
class T1 extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            for (int i = 0; i < 11; i++) {
                System.out.println("子线程（老大）吃" + i + "包子" );
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
