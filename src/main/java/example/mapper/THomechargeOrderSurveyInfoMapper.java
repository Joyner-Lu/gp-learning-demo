package example.mapper;

import example.model.THomechargeOrderSurveyInfo;
import example.model.THomechargeOrderSurveyInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface THomechargeOrderSurveyInfoMapper {
    long countByExample(THomechargeOrderSurveyInfoExample example);

    int deleteByExample(THomechargeOrderSurveyInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(THomechargeOrderSurveyInfo row);

    int insertSelective(THomechargeOrderSurveyInfo row);

    List<THomechargeOrderSurveyInfo> selectByExample(THomechargeOrderSurveyInfoExample example);

    THomechargeOrderSurveyInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") THomechargeOrderSurveyInfo row, @Param("example") THomechargeOrderSurveyInfoExample example);

    int updateByExample(@Param("row") THomechargeOrderSurveyInfo row, @Param("example") THomechargeOrderSurveyInfoExample example);

    int updateByPrimaryKeySelective(THomechargeOrderSurveyInfo row);

    int updateByPrimaryKey(THomechargeOrderSurveyInfo row);
}