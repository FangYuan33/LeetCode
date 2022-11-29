package testinwork;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试线程池下InheritableThreadLocal线程变量失效的场景
 */
public class TestInheritableThreadLocal {

//    private static final InheritableThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    private static final TransmittableThreadLocal<String> threadLocal = new TransmittableThreadLocal<>();

    // 固定大小的线程池，保证线程复用
    private static final ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {
        threadLocal.set("main线程 变量1");
        // 正常取到 main线程 变量1
        executorService.execute(() -> System.out.println(threadLocal.get()));

        threadLocal.set("main线程 变量2");
        // 线程复用再取还是 main线程 变量1
//        executorService.execute(() -> System.out.println(threadLocal.get()));
        // 使用TransmittableThreadLocal解决问题
        executorService.execute(TtlRunnable.get(() -> System.out.println(threadLocal.get())));

        executorService.shutdown();
    }
}
