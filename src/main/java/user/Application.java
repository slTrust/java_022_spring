package user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // 当启动这个main时候  spring会帮我们初始化所有的组件
    // 根据依赖关系，把每个组件所依赖的其他组件初始化，然后注入

    /*
    1.创建UserController ---》 new UserController(UserMockDao); ---> 需要另外一个对象(组件)  UserMockDao
    2. 先创建UserMockDao  --> 创建 UserController
     */
}
