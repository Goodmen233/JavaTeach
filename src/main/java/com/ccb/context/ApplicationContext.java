package com.ccb.context;

import com.ccb.domain.bo.User;
import lombok.Data;

/**
 * @Description: 应用程序上下文
 * @Author: CCB
 * @Date: 2023/3/2 16:28
 */
@Data
public class ApplicationContext {

    private static ThreadLocal<User> userThreadLocal;

    public void setUser(User user) {
        userThreadLocal.set(user);
    }

    public User getUser() {
        return userThreadLocal.get();
    }

}
