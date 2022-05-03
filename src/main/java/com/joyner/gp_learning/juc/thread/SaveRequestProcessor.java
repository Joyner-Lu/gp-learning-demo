package com.joyner.gp_learning.juc.thread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

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
public class SaveRequestProcessor extends Thread implements RequestProcessor {

    LinkedBlockingDeque<Request> requests = new LinkedBlockingDeque();
    private RequestProcessor nextProcessor;

    public SaveRequestProcessor() {

    }

    public SaveRequestProcessor(RequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    @Override
    public void processRequest(Request request) {
        requests.add(request);
    }

    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.SECONDS.sleep(1);
                Request request = requests.take();
                System.out.println("save");
                if (nextProcessor != null) {
                    nextProcessor.processRequest(request);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
