package property_auto_fill;

import com.alibaba.fastjson.JSONObject;
import example.model.THomechargeOrder;
import example.model.THomechargeOrderOperationRecord;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

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
public class PodamTest {

    public static void main(String[] args) {
        // Simplest scenario. Will delegate to Podam all decisions
        PodamFactory factory = new PodamFactoryImpl();

// This will use constructor with minimum arguments and
// then setters to populate POJO
        THomechargeOrder myPojo = factory.manufacturePojo(THomechargeOrder.class);

        System.out.println();
        String jsonString = JSONObject.toJSONString(myPojo);
        System.out.println(jsonString);

    }
}
