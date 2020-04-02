package top.aluem.video.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import top.aluem.common.handler.MyMetaObjectHandler;
import top.aluem.common.utils.IdWorker;

@Configuration
@EnableTransactionManagement
@MapperScan("top.aluem.video.mapper")
public class VideoConfig {

    /**
     * 自定义id生成器
     */
    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }

    /**
     *  自动填充功能
     */
    @Bean
    public MyMetaObjectHandler myMetaObjectHandler() {
        return new MyMetaObjectHandler();
    }

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 乐观锁插件
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }
}
