package homework;

/**
 * @author LuoPing
 * @project IntelliJ IDEA
 * @Package thread-study
 * @Date 2022/12/23 21:54
 */
public class Deamon {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            int count = 10;
            Thread t2 = new Thread(() -> {
                while (true){
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("我是个守护线程！");
                }
            });
            t2.setDaemon(true);
            t2.start();
            while (count >= 0){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("我是用户线程！");
                count--;
            }
            System.out.println("用户线程结束-------------------");
        });
//        t1.setDaemon(true);
        t1.start();
    }
}
