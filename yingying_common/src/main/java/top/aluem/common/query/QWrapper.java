package top.aluem.common.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

/**
* 我们自己的QueryWrapper类
*/
public class QWrapper<T> extends QueryWrapper<T> {
    @Override
    protected String columnToString(String column) {
        // 驼峰命名转换为下划线命名
        return StringUtils.camelToUnderline(column);
    }
}

