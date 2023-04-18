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

    private static ThreadLocal<User> userThreadLocal = new ThreadLocal<>();

    public static void setUser(User user) {
        userThreadLocal.set(user);
    }

    public static User getUser() {
        User user = userThreadLocal.get();
        if (Objects.isNull(user)) {
            throw new RuntimeException("获取用户信息异常");
        }
        return user;
    }

    public static void removeUser() {
        userThreadLocal.remove();
    }

}
