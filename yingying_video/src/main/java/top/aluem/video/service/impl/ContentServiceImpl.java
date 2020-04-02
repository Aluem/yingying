package top.aluem.video.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.aluem.common.utils.IdWorker;
import top.aluem.domain.video.Content;
import top.aluem.video.mapper.ContentMapper;
import top.aluem.video.service.ContentService;

import java.util.Date;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentMapper contentMapper;

    @Autowired
    private IdWorker idWorker;

    @Override
    public void save(Content content) {
        String id = idWorker.nextId() + "";
        content.setId(id);
        contentMapper.insert(content);
    }

    @Override
    public void delete(String id) {
        contentMapper.deleteById(id);
    }

    @Override
    public void update(String id, Content content) {
        content.setId(id);
        contentMapper.updateById(content);
    }

    @Override
    public List<Content> findAll() {
        return contentMapper.selectList(null);
    }

    @Override
    public Content findId(String id) {
        return contentMapper.selectById(id);
    }
}
