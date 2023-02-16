package homework;

/**
 * @author LuoPing
 * @project IntelliJ IDEA
 * @Package thread-study
 * @Date 2022/12/22 0:00
 * 多个线程共享资源,使用Runnable实现
 */
public class Homework02 {
    public static void main(String[] args) {
        T t = new T();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.start();
        t2.start();
    }
}
class T implements Runnable {
    private int money = 10000;

    @Override
    public void run() {
        while (true) {
//                System.out.println(Thread.currentThread().getName()+"开始取钱！当前余额"+money);
            //1。这里使用synchronized实现了线程同步
            //2．当多个线程执行到这里时，就会去争夺this对象锁
            //3．哪个线程争夺到(获取)this对象锁，就执行synchronized代码块,执行完后，会释放this对象锁
            // 4．争夺不到this对象锁，就blocked ，准备继续争夺
            //5.this 对象锁是非公平锁
            synchronized (this) {
                if (money < 1000) {
                    System.out.println(Thread.currentThread().getName() + "钱取完了 当前余额" + money);
                    break;
                }
                money -= 1000;
                System.out.println(Thread.currentThread().getName() + "取了1000元，当前余额" + money);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}