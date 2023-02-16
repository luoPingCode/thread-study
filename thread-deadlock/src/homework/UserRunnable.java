package homework;

/**
 * @author LuoPing
 * @project IntelliJ IDEA
 * @Package thread-study
 * @Date 2022/12/23 19:47
 */
public class UserRunnable {
        public static void main(String[] args) {
            System.out.println(1);
            //注意，这里new的是Thread
            new Thread(()-> System.out.println(2)).start();
            System.out.println(3);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(4);
        }
}
