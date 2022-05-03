package com.joyner.gp_learning.juc.thread;

import java.util.concurrent.*;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陆清云 luqingyun@foresee.cn
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class CallableDemo implements Callable<Boolean> {

    private static BlockingQueue<Future> taskQueue = new ArrayBlockingQueue(20);
    private static boolean isTerminal = true;

    @Override
    public Boolean call() throws InterruptedException {
        System.out.println("begin-work");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("finish work");
        return true;
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Boolean> future = service.submit(new CallableDemo());
        taskQueue.add(future);
        new Thread(new TaskChecker()).start();
    }
    static class TaskChecker implements Runnable {
        @Override
        public void run() {
            try {
                while (isTerminal) {


                    Future future = taskQueue.peek();
                    if (future == null) {
                        System.out.println("this are no tasks to process.");
                        TimeUnit.SECONDS.sleep(5);
                    } else if (future.isDone()) {
                        System.out.println("the task is finished. the result is:" + future.get());
                        taskQueue.poll();//remove the task from the queue
                    } else {
                        System.out.println("the task is still in processing,please wait...");

                    }
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("slow down the processing speed.");
                }

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        }
    }
}
