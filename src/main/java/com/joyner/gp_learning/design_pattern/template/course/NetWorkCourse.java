package com.joyner.gp_learning.design_pattern.template.course;

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
public abstract class NetWorkCourse {

    /**
     * 创建课程，不允许重写，也就是固定流程
     */
    public final void createCourse() {
        //1.发布预习资料
        this.postPreCourse();
        //2.制作课件 PPT
        this.createPPT();
        //3.在线直播
        this.liveVideo();
        //4.提 交 课 堂 笔 记
        this.postNode();
        //5.提 交 源 码 
        this.postSource();
        //6.布 置 作 业 --> 检 查 作 业
        //有些课程有作业，有些课程没有作业
        if (this.needCheckHomework()) {
            this.checkHomework();
        }
    }

    protected abstract void checkHomework();

    protected  boolean needCheckHomework() {
        return false;
    }

    private final void postSource() {
        System.out.println("上传源码");
    }

    private final void postNode() {
        System.out.println("发送笔记");
    }

    private final void liveVideo() {
        System.out.println("在线直播");
    }

    private final void createPPT() {
        System.out.println("创建课程ppt");
    }

    private final void postPreCourse() {
        System.out.println("上传预习资料");
    }
}
