package com.ccb;

import com.ccb.common.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest(classes = {App.class})
public class AppTest 
{
    @Test
    public void test() {
        RedisUtil.cacheValue("haha", "hello");
        Assert.isTrue("hello".equals(RedisUtil.getValue("haha")));
    }
}
