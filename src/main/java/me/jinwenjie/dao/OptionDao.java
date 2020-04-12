package me.jinwenjie.dao;

import java.util.List;
import me.jinwenjie.model.Option;
import me.jinwenjie.model.OptionExample;
import org.apache.ibatis.annotations.Param;

public interface OptionDao {
    long countByExample(OptionExample example);

    int deleteByExample(OptionExample example);

    int deleteByPrimaryKey(Long optionId);

    int insert(Option record);

    int insertSelective(Option record);

    List<Option> selectByExampleWithBLOBs(OptionExample example);

    List<Option> selectByExample(OptionExample example);

    Option selectByPrimaryKey(Long optionId);

    int updateByExampleSelective(@Param("record") Option record, @Param("example") OptionExample example);

    int updateByExampleWithBLOBs(@Param("record") Option record, @Param("example") OptionExample example);

    int updateByExample(@Param("record") Option record, @Param("example") OptionExample example);

    int updateByPrimaryKeySelective(Option record);

    int updateByPrimaryKeyWithBLOBs(Option record);

    int updateByPrimaryKey(Option record);
}