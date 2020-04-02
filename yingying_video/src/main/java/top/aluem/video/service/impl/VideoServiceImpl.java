package top.aluem.video.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import top.aluem.common.query.QWrapper;
import top.aluem.common.utils.GetTime;
import top.aluem.common.utils.IdWorker;
import top.aluem.domain.video.Video;
import top.aluem.video.mapper.VideoMapper;
import top.aluem.video.service.VideoService;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class VideoServiceImpl implements VideoService {

    private static String UID = "uId";
    private static String NICKNAME = "nickName";
    private static String TITLE = "title";
    private static String VIDEOTIME = "videoTime";
    private static String BEGINTIME = "beginTime";
    private static String ENDTIME = "endTime";
    private static String ISVIP = "isVip";
    private static String CONTENTID = "contentId";
    private static String FLAG = "flag";
    private static String ISPUBLIC = "ispublic";
    private static String STATUS = "status";
    private static String CREATEDATE = "create_date";

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private IdWorker idWorker;

    @Override
    public Video findId(String id) {
        return videoMapper.selectById(id);
    }

    @Override
    public List<Video> findAll() {
        return videoMapper.selectList(null);
    }

    @Override
    public void update(String id, Video video) {
        video.setId(id);
        videoMapper.updateById(video);
    }

    @Override
    public void add(Video video) {
        String id = idWorker.nextId() + "";
        video.setId(id);
        //TODO  设置 userId 为当前登录用户id
        videoMapper.insert(video);
    }

    @Override
    public void delete(String id) {
        videoMapper.deleteById(id);
    }

    @Override
    public Page search(Map<String, Object> map, Integer page, Integer size) {
        QWrapper wrapper = new QWrapper();
        Set<String> fieldSet = map.keySet();
        for (String field : fieldSet) {
            //动态sql
            wrapper.eq(null != map.get(field), field, map.get(field));
        }

        Page r_page = new Page(page, size);
        videoMapper.selectPage(r_page, wrapper);
        return r_page;
    }

    @Override
    public Page searchLike(Map<String, Object> map, Integer page, Integer size) {

        QWrapper<Video> wrapper = new QWrapper<>();

        //用户看到的必须是已经公开、已经发布的视频
        wrapper.eq(ISPUBLIC, "yes");
        wrapper.eq(STATUS, 1);

        Page r_page = new Page(page, size);

        if (map == null) {
            videoMapper.selectPage(r_page, wrapper);
            return r_page;
        } else {
            //TODO 用户名查询 需要调用用户微服务
            String uId = (String) map.get(UID);
            String nickName = (String) map.get(NICKNAME);
            String title = (String) map.get(TITLE);
            String videoTime = (String) map.get(VIDEOTIME);
            String beginTime = (String) map.get(BEGINTIME);
            String endTime = (String) map.get(ENDTIME);
            Integer isVip = (Integer) map.get(ISVIP);
            String contentId = (String) map.get(CONTENTID);
            Integer flag = (Integer) map.get(FLAG);

            //动态sql
            if (!StringUtils.isEmpty(uId)) {
                wrapper.eq(UID, uId);
            }
            if (!StringUtils.isEmpty(nickName)) {
                wrapper.like(NICKNAME, nickName);
            }
            if (!StringUtils.isEmpty(title)) {
                wrapper.like(TITLE, title);
            }
            if (!StringUtils.isEmpty(videoTime) && flag > 0) {
                wrapper.ge(VIDEOTIME, videoTime);
            } else if (!StringUtils.isEmpty(videoTime) && flag <= 0) {
                wrapper.le(VIDEOTIME, videoTime);
            }
            if (!StringUtils.isEmpty(beginTime)) {
                wrapper.ge(CREATEDATE, beginTime);
            }
            if (!StringUtils.isEmpty(endTime)) {
                wrapper.le(CREATEDATE, endTime);
            }

            if (!StringUtils.isEmpty(isVip)) {
                wrapper.eq(ISVIP, isVip);
            }
            if (!StringUtils.isEmpty(contentId)) {
                wrapper.eq(CONTENTID, contentId);
            }
        }

        videoMapper.selectPage(r_page, wrapper);
        return r_page;
    }
}
