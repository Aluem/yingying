package top.aluem.domain.video;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_video")
public class Video {

    @TableId(type = IdType.INPUT)
    private String id;

    //发布视频的用户id
    private String uId;

    //标题
    private String title;

    //视频封面
    private String cover;

    //视频时长
    private Integer videoTime;

    //浏览数量
    private String viewCount;

    //创建时间
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;

    //修改时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateDate;

    //是否vip可看
    private Integer isVip;

    //视频状态 0 未发布 1 已发布
    private Integer status;

    //乐观锁
    @Version
    private Integer version;

    //存放视频的地址
    private String videoSourceId;

    //内容列表id
    private String contentId;

    //是否公开
    private String ispublic;

    //点赞数
    private Integer thumbup;

    //评论数
    private Integer comment;

    //收藏数
    private Integer favorite;

}
