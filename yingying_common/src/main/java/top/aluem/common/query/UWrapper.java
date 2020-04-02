package top.aluem.common.query;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

/**
* 我们自己的UpdateWrapper类
*/
public class UWrapper<T> extends UpdateWrapper<T> {
    @Override
    protected String columnToString(String column) {
        // 驼峰命名转换为下划线命名
        return StringUtils.camelToUnderline(column);
    }
}
