package com.fengze.mybatis.dao;

import com.fengze.mybatis.domain.UserDo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Administrator on 2017/5/5.
 */
@Slf4j
public class UserDaoTest {

    SqlSessionFactory sqlSessionFactory;
    SqlSession session;

    @Before
    public void setUp() throws Exception {
        //配置路径
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
        //打开session
        session=sqlSessionFactory.openSession();
        //默认创建session是false，手动提交事务，如果设置为true，则自动提交
        //false : 开启事务 ;  true : 关闭事务 ;
        session = sqlSessionFactory.openSession(true);
    }

    @After
    public void tearDown() throws Exception {
        session.close();
    }

    @Test
    public void queryById() throws Exception {
        UserDo userDo=new UserDo();
        userDo.setUserId(1000L);

        UserDo user = session.selectOne("user.queryById",userDo);

        log.info("UserDo : {}",user);
    }

    @Test
    public void findById() throws Exception {
        UserDo user = session.selectOne("user.findById",1000);

        log.info("UserDo : {}",user);
    }

    @Test
    public void queryByList() throws Exception {
        UserDo userDo=new UserDo();
        userDo.setAddress("南");
        List<UserDo> list=session.selectList("user.queryByList",userDo);
        for (UserDo user:list){
            log.info("UserDo : {}",user);
        }
    }

    @Test
    public void addUser() throws Exception {
        UserDo userDo=new UserDo();

        userDo.setUserName("照照");
        userDo.setPassword("123456");
        userDo.setRealName("赵六");
        userDo.setEmail("123456@qq.com");
        userDo.setCellphone("15518000000");
        userDo.setAddress("河南郑州");
        userDo.setUserType("0");

        Integer res = session.insert("user.addUser",userDo);

        //默认情况下mybatis是手动提交的(开启事务的)
        //session.commit();

        log.info("新增影响行数 : {}",res);
    }

    @Test
    public void modifyUser() throws Exception {
        UserDo userDo=new UserDo();

        userDo.setUserId(1002L);
        userDo.setPassword("aaaaaa");

        Integer res = session.update("user.modifyUser",userDo);

        //session.commit();

        log.info("修改影响行数 : {}",res);
    }

    @Test
    public void delUser() throws Exception {
        UserDo userDo=new UserDo();

        userDo.setUserId(1002L);

        Integer res = session.delete("user.delUser",userDo);

        //session.commit();

        log.info("修改影响行数 : {}",res);
    }

}