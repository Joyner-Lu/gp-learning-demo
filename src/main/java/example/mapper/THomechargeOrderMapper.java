package example.mapper;

import example.model.THomechargeOrder;
import example.model.THomechargeOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface THomechargeOrderMapper {
    long countByExample(THomechargeOrderExample example);

    int deleteByExample(THomechargeOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(THomechargeOrder row);

    int insertSelective(THomechargeOrder row);

    List<THomechargeOrder> selectByExample(THomechargeOrderExample example);

    THomechargeOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") THomechargeOrder row, @Param("example") THomechargeOrderExample example);

    int updateByExample(@Param("row") THomechargeOrder row, @Param("example") THomechargeOrderExample example);

    int updateByPrimaryKeySelective(THomechargeOrder row);

    int updateByPrimaryKey(THomechargeOrder row);
}