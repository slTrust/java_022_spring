package user.model;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;
// 工厂模式 ——依赖注入
/**
 * 当你的库是别人写好的
 * 你就无法 使用 @Component 注解
 */
@Component("userDao") // 参数只是一个标记符 类名也是可以随便起的
public class UserDaoFactory implements FactoryBean<UserDao> {

    @Override
    public UserDao getObject(){
        System.out.println("使用工厂模式创建一个UserDao的组件");
        return new UserMockDao();
    }

    @Override
    public Class<?> getObjectType() {
        return UserMockDao.class;
    }

    // 是否是单例模式
    @Override
    public boolean isSingleton() {
        return true;
    }
}
