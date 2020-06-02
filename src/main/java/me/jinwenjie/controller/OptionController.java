package me.jinwenjie.controller;

import me.jinwenjie.model.Option;
import me.jinwenjie.service.OptionService;
import me.jinwenjie.util.JSONResult;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/options")
@RestController
public class OptionController {
    private final OptionService optionService;

    public OptionController(OptionService optionService) {
        this.optionService = optionService;
    }

    @GetMapping("/name")
    String getBlogName() {
        return optionService.getBlogName();
    }

    @PatchMapping("")
    JSONObject update(@RequestBody Option option) {
        optionService.update(option);
        return JSONResult.success();
    }
}
