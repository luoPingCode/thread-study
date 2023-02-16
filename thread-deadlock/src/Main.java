/**
 * @author LuoPing
 * @project ${PRODUCT_NAME}
 * @Package ${PROJECT_NAME}
 * @Date ${DATE} ${TIME}
 * 模拟线程死锁
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        DeadLock A = new DeadLock(true);
        A.setName("A线程 ");
        DeadLock B = new DeadLock(false);
        B.setName("B线程 ");
//        Thread t1 = new Thread(A);
//        Thread t2 = new Thread(B);
        A.start();
        B.start();
    }
}
