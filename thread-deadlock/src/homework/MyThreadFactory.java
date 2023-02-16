package homework;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LuoPing
 * @project IntelliJ IDEA
 * @Package thread-study
 * @Date 2022/12/24 22:40
 */
public class MyThreadFactory implements ThreadFactory {

//    @Override
//    public Thread newThread(Runnable r) {
//        return new Thread(r);
//    }
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;
        @SuppressWarnings("removal")
        MyThreadFactory(String name) {
//            @SuppressWarnings("removal")
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            namePrefix = name + "-" +
                    poolNumber.getAndIncrement() +
                    "-thread-";
        }

        MyThreadFactory(){
            this("default");
        }

        public Thread newThread(Runnable r) {
            // 就是在创建线程
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
}
