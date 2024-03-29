package example.mapper;

import example.model.THomechargeOrderOperationRecord;
import example.model.THomechargeOrderOperationRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface THomechargeOrderOperationRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_homecharge_order_operation_record
     *
     * @mbg.generated Tue Apr 19 21:12:09 CST 2022
     */
    long countByExample(THomechargeOrderOperationRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_homecharge_order_operation_record
     *
     * @mbg.generated Tue Apr 19 21:12:09 CST 2022
     */
    int deleteByExample(THomechargeOrderOperationRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_homecharge_order_operation_record
     *
     * @mbg.generated Tue Apr 19 21:12:09 CST 2022
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_homecharge_order_operation_record
     *
     * @mbg.generated Tue Apr 19 21:12:09 CST 2022
     */
    int insert(THomechargeOrderOperationRecord row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_homecharge_order_operation_record
     *
     * @mbg.generated Tue Apr 19 21:12:09 CST 2022
     */
    int insertSelective(THomechargeOrderOperationRecord row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_homecharge_order_operation_record
     *
     * @mbg.generated Tue Apr 19 21:12:09 CST 2022
     */
    List<THomechargeOrderOperationRecord> selectByExample(THomechargeOrderOperationRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_homecharge_order_operation_record
     *
     * @mbg.generated Tue Apr 19 21:12:09 CST 2022
     */
    THomechargeOrderOperationRecord selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_homecharge_order_operation_record
     *
     * @mbg.generated Tue Apr 19 21:12:09 CST 2022
     */
    int updateByExampleSelective(@Param("row") THomechargeOrderOperationRecord row, @Param("example") THomechargeOrderOperationRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_homecharge_order_operation_record
     *
     * @mbg.generated Tue Apr 19 21:12:09 CST 2022
     */
    int updateByExample(@Param("row") THomechargeOrderOperationRecord row, @Param("example") THomechargeOrderOperationRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_homecharge_order_operation_record
     *
     * @mbg.generated Tue Apr 19 21:12:09 CST 2022
     */
    int updateByPrimaryKeySelective(THomechargeOrderOperationRecord row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_homecharge_order_operation_record
     *
     * @mbg.generated Tue Apr 19 21:12:09 CST 2022
     */
    int updateByPrimaryKey(THomechargeOrderOperationRecord row);
}