package top.aluem.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 配置插入值时自动填充时间等
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {


    //在mp执行添加操作时运行
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createDate",new Date(), metaObject);
        this.setFieldValByName("updateDate",new Date(), metaObject);
    }

    //在mp执行修改操作时运行
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateDate", new Date(), metaObject);
    }
}
