/**
 * @author LuoPing
 * @project IntelliJ IDEA
 * @Package thread-study
 * @Date 2022/12/21 22:19
 * 模拟线程死锁
 */
public class DeadLock extends Thread{
    static Object lock1 = new Object();
    static Object lock2 = new Object();
    boolean flag;

    public DeadLock(boolean flag) {
        this.flag = flag;
    }

    public void run() {
        //下面业务逻辑分析
        //1.如果flag为 T ，线程就会先得到/持有 lock1 对象锁，然后尝试去获取lock2对象锁
        //2.如果线程A 得不到 lock2 对象锁，就会Blocked
        //3.如果flag 为 F，线程B 就会得到/持有lock2 对象锁，然后尝试去获取 lock1 对象锁
        //4.如果线程B 得不到 lock1 对象锁，就会Blocked
        if (flag) {
            synchronized (lock1) {//对象锁，下面是同步代码
                try {
                    System.out.println(Thread.currentThread().getName() + "进入1");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {//这里获得li对象监视权
                    System.out.println(Thread.currentThread().getName() + "进入2");
                }
            }
        }else {
            synchronized (lock2) {
                try {
                    System.out.println(Thread.currentThread().getName() + "进入3");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {//这里获得li对象监视权
                    System.out.println(Thread.currentThread().getName() + "进入4");
                }
            }
        }
    }
}
