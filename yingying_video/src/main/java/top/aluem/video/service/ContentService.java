package top.aluem.video.service;

import top.aluem.domain.video.Content;

import java.util.List;

public interface ContentService {

    //新增列表内容
    void save(Content content);

    //删除列表内容
    void delete(String id);

    //修改列表内容
    void update(String id, Content content);

    //查询全部列表内容
    List<Content> findAll();

    //根据id查询列表
    Content findId(String id);
}
