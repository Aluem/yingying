package top.aluem.domain.video;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_content")
public class Content implements Serializable {

    @TableId(type = IdType.INPUT) //手动插入
    private String id;

    //列表内容
    private String content;

    //该列表下视频数量
    private Integer videoNum;

    //列表创建时间
    @TableField(fill = FieldFill.INSERT)    //自动配置插入时间
    private Date createDate;

    //列表更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE) //自动配置修改时间
    private Date updateDate;

    //乐观锁
    @Version
    private Integer version;
}
