package top.aluem.video.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.aluem.common.entity.PageResult;
import top.aluem.common.entity.Result;
import top.aluem.common.entity.ResultCode;
import top.aluem.domain.video.Video;
import top.aluem.video.service.impl.VideoServiceImpl;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoServiceImpl videoService;

    /**
     * 模糊分页查询
     * page：当前页
     * size：每页记录数
     */
    @PostMapping("/searchLike/{page}/{size}")
    public Result searchLike(@PathVariable("page") Integer page,
                             @PathVariable("size") Integer size,
                             @RequestBody Map map) {
        Page r_page = videoService.searchLike(map, page, size);
        return new Result(ResultCode.SUCCESS, new PageResult((Long)r_page.getTotal(), r_page.getRecords()));
    }


    /**
     * 条件分页查询（具体）
     *  之前接收实体类数据，都使用entity，现在使用map
     *  之前所有的条件都要进行判断，遍历entity的所有属性需要使用反射的方式，成本较高，性能较低
     *  使用集合方式遍历，性能较高
     */
    @PostMapping("/search/{page}/{size}")
    public Result search(@PathVariable("page") Integer page,
                         @PathVariable("size") Integer size,
                         @RequestBody Map<String, Object> map) {
        Page r_page = videoService.search(map, page, size);
        return new Result(ResultCode.SUCCESS, new PageResult((Long)r_page.getTotal(), r_page.getRecords()));
    }



    /**
     * 根据id查询
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable("id") String id) {
        Video video = videoService.findId(id);
        return new Result(ResultCode.SUCCESS,video);
    }

    /**
     * 保存
     */
    @PostMapping("")
    public Result add(@RequestBody Video video) {
        videoService.add(video);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 根据id修改
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") String id) {
        videoService.delete(id);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 修改
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable("id") String id, @RequestBody Video video) {
        videoService.update(id,video);
        return new Result(ResultCode.SUCCESS);
    }
}
