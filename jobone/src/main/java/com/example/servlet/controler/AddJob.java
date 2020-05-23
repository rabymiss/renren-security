package com.example.servlet.controler;

import com.example.servlet.entity.JobMessage;
import com.example.servlet.entity.JobReturn;
import com.example.servlet.entity.MessageAll;
import com.example.servlet.repository.JobMessageAll;
import com.example.servlet.repository.JobRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;

@RestController
public class AddJob {


    @RequestMapping("add/job")
    public JobReturn login(@RequestBody JobMessage jobMessage) {
        JobReturn respVo = new JobReturn();
        respVo.setErrmsg("成功");
        respVo.setErrno(200);
        InputStream inputStream = AddJob.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        JobRepository jobRepository = sqlSession.getMapper(JobRepository.class);
        JobMessageAll jobMessageAll=sqlSession.getMapper(JobMessageAll.class);
        MessageAll messageAll=new MessageAll();
        messageAll.setGood1(jobMessage.getUuid());
        jobMessageAll.sava(messageAll);
            jobRepository.save(jobMessage);
            System.out.println(jobMessage);
            sqlSession.commit();
            sqlSession.close();

        return respVo;
    }

    @RequestMapping("delete/job")
    public JobReturn delete(@RequestBody JobMessage jobMessage) {
        JobReturn respVo = new JobReturn();
        respVo.setErrmsg("成功");
        respVo.setErrno(200);
        InputStream inputStream = AddJob.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        JobRepository jobRepository = sqlSession.getMapper(JobRepository.class);
        JobMessageAll jobMessageAll=sqlSession.getMapper(JobMessageAll.class);
        MessageAll messageAll=new MessageAll();
        messageAll.setGood1(jobMessage.getUuid());
        jobMessageAll.deleteby(messageAll);
        jobRepository.deleteby(jobMessage);
        System.out.println("删除--------+"+jobMessage+messageAll);
        sqlSession.commit();
        sqlSession.close();

        return respVo;
    }
}
