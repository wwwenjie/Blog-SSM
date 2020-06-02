package me.jinwenjie.dao;

import me.jinwenjie.model.Option;

public interface OptionDao {
    String getOptionValueByName(String optionName);

    int updateByPrimaryKeySelective(Option record);
}