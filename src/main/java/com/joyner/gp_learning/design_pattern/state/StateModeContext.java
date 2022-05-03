package com.joyner.gp_learning.design_pattern.state;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陆清云 luqy@xiaopeng.com
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class StateModeContext
{
    private State state;
    private ContextData data ;

    public ContextData getData() {
        return data;
    }

    public void setData(ContextData data) {
        this.data = data;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    /// 定义Context的初始状态
    public StateModeContext(State state , ContextData data )
    {
        this.data = data;
        this.state = state;
    }

    /// 对请求做处理，并设置下一个状态
    boolean  trueFlag = true;

    public void request()
    {
        // 如果不是最后一步，那么执行此状态下的动作
        state.handle(this);

    }
}