package com.joyner.gp_learning.juc.thread;

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
public class Main {

    PrintRequestProcessor printRequestProcessor;

    public void init() {
        SaveRequestProcessor saveRequestProcessor = new SaveRequestProcessor();
        printRequestProcessor = new PrintRequestProcessor(saveRequestProcessor);
        saveRequestProcessor.start();
        printRequestProcessor.start();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.init();
        main.printRequestProcessor.processRequest(new Request());

    }
}
