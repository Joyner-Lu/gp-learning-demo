package com.joyner.gp_learning.orm_related.mybatis.mapper;

import com.joyner.gp_learning.orm_related.mybatis.entity.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <pre>
 * 1.使用接口，则必须xml文件的路径和接口的包名相同
 * 2.xml的namespace必须是接口的全路径
 * 3.xml中的id就是接口的方法名称
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
public interface MemberMapper {

    List<Member> selectAllMember();

    Member selectById(String id);

    List<Member> selectByName(@Param("name") String name);
}
