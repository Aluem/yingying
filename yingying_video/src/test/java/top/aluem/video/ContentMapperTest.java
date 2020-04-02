package top.aluem.video;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.aluem.domain.video.Content;
import top.aluem.video.mapper.ContentMapper;

import java.util.Date;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ContentMapperTest {

    @Autowired
    private ContentMapper contentMapper;

    @Test
    public void test01() {
        Content content = contentMapper.selectById(1);
        System.out.println(content);
    }

    @Test
    public void test02() {
        Date date = new Date();
        System.out.println(date);
    }



}
