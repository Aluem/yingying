package top.aluem.video.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import top.aluem.domain.video.Video;
import top.aluem.video.query.VideoQuery;

import java.util.List;
import java.util.Map;

public interface VideoService {

    //根据id查询
    Video findId(String id);

    //查询所有 未发布的也能看到（管理员看）
    List<Video> findAll();

    //根据id修改
    void update(String id, Video video);

    //添加
    void add(Video video);

    //删除
    void delete(String id);

    //具体查询
    Page search(Map<String, Object> map, Integer page, Integer size);

    //模糊查询（根据条件）
    Page searchLike(Map<String, Object> map, Integer page, Integer size);

}
