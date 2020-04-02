package top.aluem.video.query;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 视频分页查询条件对象
 */
@Data
public class VideoQuery implements Serializable {

    //发布视频的用户id
    private String uId;

    //发布视频的用户名
    private String nickName;

    //标题
    private String title;

    //视频时长  单位 s
    private Integer videoTime;

    //起始日期
    private Date beginTime;

    //最后日期
    private Date endTime;

    //是否vip可看
    private Integer isVip;

    //内容列表id
    private String contentId;

    //判断视频时长是大于时长还是短于某个时长
    //大于0  大于   小于等于0  小于
    private Integer flag;
}
