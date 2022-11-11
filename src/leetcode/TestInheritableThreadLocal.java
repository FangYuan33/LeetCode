package leetcode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试线程池下InheritableThreadLocal线程变量失效的场景
 */
public class TestInheritableThreadLocal {

    // 取null
//    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private static InheritableThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    // 固定大小的线程池，保证线程复用
    private static ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {
        threadLocal.set("main 线程变量");
        // 正常取到 main 线程变量
        executorService.execute(() -> System.out.println(threadLocal.get()));


        threadLocal.set("main 线程变量2");
        // 线程复用再取还是 main 线程变量
        executorService.execute(() -> System.out.println(threadLocal.get()));
    }
}
