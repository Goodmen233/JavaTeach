package com.ccb.context;

import com.ccb.domain.bo.User;
import lombok.Data;

import java.util.Objects;

/**
 * @Description: 应用程序上下文
 * @Author: CCB
 * @Date: 2023/3/2 16:28
 */
@Data
public class ApplicationContext {

    private static User user = null;

    private static ThreadLocal<User> userThreadLocal = new ThreadLocal<>();

    public static synchronized void setUser(User user0) {
        user = user0;
        userThreadLocal.set(user0);
    }

    public static User getUser() {
        User user0 = userThreadLocal.get();
        if (Objects.isNull(user0)) {
            if (Objects.isNull(user)) {
                throw new RuntimeException("获取用户信息异常");
            }
            user0 = user;
        }
        return user0;
    }

    public static synchronized void removeUser() {
        user = null;
        userThreadLocal.remove();
    }

}
