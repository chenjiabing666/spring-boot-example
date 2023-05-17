package com.zengqingfa.tx.service;

import com.zengqingfa.tx.dao.UserDao;
import com.zengqingfa.tx.entity.User;
import com.zengqingfa.tx.exception.MyException;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @fileName: UserService
 * @author: zengqf3
 * @date: 2021-7-19 9:30
 * @description:
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 未开启事务注解 EnableTransactionManagement
     * 需要配置 DataSourceTransactionManager
     */
    @Transactional
    public void save1() {
        User user = new User();
        user.setName("1");
        user.setAge(1);
        userDao.save(user);
        int i = 1 / 0;
    }


    /**
     * 标注了@Transactional的方法里面的异常被捕获了
     */
    @Transactional
    public void save2() {
        try {
            User user = new User();
            user.setName("2");
            user.setAge(2);
            userDao.save(user);
            int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 标注了@Transactional的方法发生了非 Error 或者 RuntimeException
     *
     * @throws Exception
     */
    @Transactional
    public void save3() throws Exception {
        User user = new User();
        user.setName("3");
        user.setAge(3);
        userDao.save(user);
        throw new Exception("test save3");
    }


    /**
     * 标注了@Transactional的方法的事务传播类型propagation配置成了NOTSUPPORT
     * NOTSUPPORT表示不支持事务，即使当前有事务，也不会使用事务。
     * 所以当 propagation = Propagation.NOT_SUPPORTED 的时候，不会使用事务。所以异常发生的时候，也就不会回滚。
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void save4() {
        User user = new User();
        user.setName("4");
        user.setAge(4);
        userDao.save(user);
        int i = 1 / 0;
    }

    /**
     * 标注了@Transactional的方法的事务传播类型propagation配置成了NEVER
     * NEVER表示不支持事务，如果有事务则会报错
     */
    @Transactional(propagation = Propagation.NEVER)
    public void save5() {
        User user = new User();
        user.setName("5");
        user.setAge(5);
        userDao.save(user);
        int i = 1 / 0;
    }

    /**
     * 标注了@Transactional的方法的事务传播类型propagation配置成了SUPPORTS且当前没有事务
     * SUPPORTS的意思是，如果当前有事务，就加入，如果没事务，则以非事务运行。
     * 从这个说明来看，使用这个级别和不加@Transaction注解也没什么不一样
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public void save6() {
        User user = new User();
        user.setName("6");
        user.setAge(6);
        userDao.save(user);
        int i = 1 / 0;
    }


    /**
     * 外部调用方法A，A内部调用方法B，A没有@Transaction注解而B有@Transactional注解
     * 在 UserService 里面添加 save7 方法，和 save72 方法，其中 save72 上面标有@Transactional注解，且save72里面有异常
     * this其实是个普通对象，没有被AOP动态代理增强过。所以 save72()出现异常的时候没有回滚
     */
    public void save7() {
        User user = new User();
        user.setName("7");
        user.setAge(7);
        userDao.save(user);
        save72();// == this.save72(),此时this对象没有被代理
    }

    @Resource
    private UserService userService;

    public void save7A() {
        User user = new User();
        user.setName("7");
        user.setAge(7);
        userDao.save(user);
        userService.save72();
    }

    @Transactional
    public void save72() {
        User user = new User();
        user.setName("72");
        user.setAge(72);
        userDao.save(user);
        int i = 1 / 0;
    }

    public void save7B() {
        User user = new User();
        user.setName("7");
        user.setAge(7);
        userDao.save(user);
        ((UserService) AopContext.currentProxy()).save72();
    }

    /**
     * Propagation.REQUIRES_NEW 新开启了一个事务，跟之前的事务无关，所以不会回滚
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save82() {
        User user = new User();
        user.setName("82");
        user.setAge(82);
        userDao.save(user);
    }

    /**
     *标注了@Transactional的方法不是public的
     */
    @Transactional
    protected void save9() {
        User user = new User();
        user.setName("9");
        user.setAge(9);
        userDao.save(user);
        int i = 1 / 0;
    }


    /**
     * 标注了@Transactional的方法发生的异常不是rollbackFor指定的类型或子类
     * @throws Exception
     */
    @Transactional(rollbackFor = MyException.class)
    public void save10() throws Exception {
        User user = new User();
        user.setName("10");
        user.setAge(10);
        userDao.save(user);
        throw new Exception("test save10");
    }
}

