package top.aluem.video.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.aluem.common.entity.Result;
import top.aluem.common.entity.ResultCode;
import top.aluem.domain.video.Content;
import top.aluem.video.service.impl.ContentServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/video")
public class ContentController {

    @Autowired
    private ContentServiceImpl contentService;

    /**
     * 根据id查询列表内容
     */
    @GetMapping("/content/{id}")
    public Result getContent(@PathVariable("id") String id) {
        Content content = contentService.findId(id);
        return new Result(ResultCode.SUCCESS,content);
    }

    /**
     * 添加列表内容
     */
    @PostMapping("/content")
    public Result addContent(@RequestBody Content content) {
        contentService.save(content);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 根据id删除列表内容
     * TODO:删除列表里的视频 需要特殊权限
     */
    @DeleteMapping("/content/{id}")
    public Result delete(@PathVariable("id") String id) {
        contentService.delete(id);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 修改列表内容
     */
    @PutMapping("/content/{id}")
    public Result update(@PathVariable("id") String id, @RequestBody Content content) {
        contentService.update(id,content);
        return new Result(ResultCode.SUCCESS);
    }
}
