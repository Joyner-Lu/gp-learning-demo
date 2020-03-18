package com.joyner.gp_learning.spring_related.imitate_spring.framework.beans;

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
public class GPBeanWrapper {

    private Object wrappedInstance;

    public GPBeanWrapper(Object wrappedInstance) {
        this.wrappedInstance = wrappedInstance;
    }


    public Object getWrappedInstance() {
        return wrappedInstance;
    }


    /**
     * Return the type of the wrapped bean instance.
     */
    public Class<?> getWrappedClass() {
        return this.wrappedInstance.getClass();
    }


}
