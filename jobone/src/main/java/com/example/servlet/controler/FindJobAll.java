package com.example.servlet.controler;

import com.example.servlet.entity.*;
import com.example.servlet.repository.JobMessageAll;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.List;

@RestController
public class FindJobAll {

    @RequestMapping("find/all/message")
    public JobReturn info() {
        JobReturn jobReturn = new JobReturn();
        jobReturn.setErrmsg("成功");
        jobReturn.setErrno(200);
        InputStream inputStream = FindJobAll.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        JobMessageAll jobMessageAll = sqlSession.getMapper(JobMessageAll.class);
        List<MessageAll> list = jobMessageAll.findAll();
        System.out.println("查询工作信息---------------------------"+list);
        jobReturn.setData(list);
        sqlSession.commit();
        sqlSession.close();
        return jobReturn;
    }
    @RequestMapping("find/message/byid")
    public JobReturn find(@RequestBody User user) {
        JobReturn jobReturn = new JobReturn();
        jobReturn.setErrmsg("成功");
        jobReturn.setErrno(200);
        InputStream inputStream = FindJobAll.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        JobMessageAll jobMessageAll = sqlSession.getMapper(JobMessageAll.class);
        MessageAll messageAll=new MessageAll();
        messageAll.setGood1(user.getUsername());
       MessageAll list = jobMessageAll.findby(messageAll);
        System.out.println("查询工作信息---------------------------"+list);
        jobReturn.setData(list);
        sqlSession.commit();
        sqlSession.close();
        return jobReturn;
    }

}


