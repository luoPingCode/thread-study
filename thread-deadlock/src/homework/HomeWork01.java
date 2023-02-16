package homework;

/**
 * @author LuoPing
 * @project IntelliJ IDEA
 * @Package thread-study
 * @Date 2022/12/21 23:04
 */
public class HomeWork01 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);
        a.start();
        b.start();
        System.out.println(Thread.currentThread().getName());
    }
}

class A extends Thread{
    boolean loop = true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public void run(){//每个两秒输出
//        System.out.println(Thread.currentThread().getName());
        while (loop){ //输出1-100以内的数字
            int a = (int) (1+Math.random() * 100);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            System.out.println(a);
        }
        System.out.println(Thread.currentThread().getName());
    }
}

class B extends Thread{
    private A a;

    public B(A a) {
        this.a = a;
    }

    public void run() {
        char aa = 'A';
//        while (true){
            for (int i = 0; i < 26;i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                String bb = String.valueOf(aa++);
                if ("Q".equals(bb)){
                    a.setLoop(false);
                    System.out.println(bb + "B线程退出");
                    break;
                }
            }
//        }
    }
}
