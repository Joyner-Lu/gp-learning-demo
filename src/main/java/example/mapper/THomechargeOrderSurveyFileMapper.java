package example.mapper;

import example.model.THomechargeOrderSurveyFile;
import example.model.THomechargeOrderSurveyFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface THomechargeOrderSurveyFileMapper {
    long countByExample(THomechargeOrderSurveyFileExample example);

    int deleteByExample(THomechargeOrderSurveyFileExample example);

    int deleteByPrimaryKey(Long id);

    int insert(THomechargeOrderSurveyFile row);

    int insertSelective(THomechargeOrderSurveyFile row);

    List<THomechargeOrderSurveyFile> selectByExample(THomechargeOrderSurveyFileExample example);

    THomechargeOrderSurveyFile selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") THomechargeOrderSurveyFile row, @Param("example") THomechargeOrderSurveyFileExample example);

    int updateByExample(@Param("row") THomechargeOrderSurveyFile row, @Param("example") THomechargeOrderSurveyFileExample example);

    int updateByPrimaryKeySelective(THomechargeOrderSurveyFile row);

    int updateByPrimaryKey(THomechargeOrderSurveyFile row);
}