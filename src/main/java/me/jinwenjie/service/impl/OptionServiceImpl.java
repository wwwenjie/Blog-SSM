package me.jinwenjie.service.impl;

import me.jinwenjie.dao.OptionDao;
import me.jinwenjie.model.Option;
import me.jinwenjie.service.OptionService;
import org.springframework.stereotype.Service;

@Service
public class OptionServiceImpl implements OptionService {
    private final OptionDao optionDao;

    public OptionServiceImpl(OptionDao optionDao) {
        this.optionDao = optionDao;
    }

    @Override
    public String getBlogName() {
        return optionDao.getOptionValueByName("blogname");
    }

    @Override
    public void update(Option option) {
        optionDao.updateByPrimaryKeySelective(option);
    }
}
