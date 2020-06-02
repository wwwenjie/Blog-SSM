package me.jinwenjie.controller;

import com.github.pagehelper.PageHelper;
import me.jinwenjie.model.Log;
import me.jinwenjie.service.LogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/logs")
@RestController
public class LogController {
    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("")
    public List<Log> findAll(Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 0 : pageNum;
        pageSize = pageSize == null ? 8 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        return logService.findAll();
    }

    @GetMapping("/total")
    public Integer total() {
        return logService.count();
    }

}
