package me.jinwenjie.service;

import me.jinwenjie.model.Log;

import java.util.List;

public interface LogService {
    Integer count();

    List<Log> findAll();

    void addLog(Log log);
}
