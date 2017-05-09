package com.fengze.mybatis.mapper;

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
 * Created by Administrator on 2017/5/8.
 */
@Slf4j
public class UserMapperTest {

    SqlSessionFactory sqlSessionFactory;
    SqlSession session;

    @Before
    public void setUp() throws Exception {
        //配置路径..
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
        UserDo userDo = new UserDo();
        userDo.setUserId(1001L);

        UserMapper mapper=session.getMapper(UserMapper.class);

        UserDo user = mapper.queryById(userDo);

        log.info("User : {}" , user);
    }

    @Test
    public void findById() throws Exception {
        UserMapper mapper=session.getMapper(UserMapper.class);

        UserDo user = mapper.findById(1000);

        log.info("User : {}" , user);
    }

    @Test
    public void queryByList() throws Exception {
        UserDo userDo = new UserDo();
        userDo.setAddress("南");

        UserMapper mapper=session.getMapper(UserMapper.class);

        List<UserDo> list = mapper.queryByList(userDo);

        for (UserDo user : list){
            log.info("User : {}" , user);
        }
    }

    @Test
    public void addUser() throws Exception {
        UserDo userDo=new UserDo();

        userDo.setUserName("abcd");
        userDo.setPassword("1234567");
        userDo.setRealName("赵六2");
        userDo.setEmail("1234567@qq.com");
        userDo.setCellphone("15518000001");
        userDo.setAddress("河南郑州0");
        userDo.setUserType("0");

        UserMapper mapper=session.getMapper(UserMapper.class);

        Integer res = mapper.addUser(userDo);

        log.info("新增影响行数 : {}",res);
    }

    @Test
    public void modifyUser() throws Exception {
        UserDo userDo = new UserDo();

        userDo.setUserId(1007L);
        userDo.setPassword("000000");

        UserMapper mapper = session.getMapper(UserMapper.class);

        Integer res = mapper.modifyUser(userDo);

        log.info("新增影响行数 : {}",res);
    }

    @Test
    public void delUser() throws Exception {
        UserDo userDo = new UserDo();

        userDo.setUserId(1002L);

        UserMapper mapper = session.getMapper(UserMapper.class);

        Integer res = mapper.delUser(userDo);

        log.info("新增影响行数 : {}",res);
    }

}