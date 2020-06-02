package me.jinwenjie.service.impl;

import me.jinwenjie.dao.LogDao;
import me.jinwenjie.model.Log;
import me.jinwenjie.service.LogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    private final LogDao logDao;

    public LogServiceImpl(LogDao logDao) {
        this.logDao = logDao;
    }

    @Override
    public Integer count() {
        return logDao.count();
    }

    @Override
    public List<Log> findAll() {
        return logDao.findAll();
    }

    @Override
    public void addLog(Log log) {
        logDao.insertSelective(log);
    }
}
