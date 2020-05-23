package com.example.servlet.controler;

import com.example.servlet.entity.JobMessage;
import com.example.servlet.entity.MessageAll;
import com.example.servlet.entity.RespVo;
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
public class SaveJobAll {

    @RequestMapping("add/job/message")
    public RespVo login(@RequestBody MessageAll messageAll) {

        RespVo respVo = new RespVo();
        respVo.setErrmsg("成功");
        respVo.setErrno(200);
        InputStream inputStream = SaveJobAll.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        JobMessageAll jobMessageAll = sqlSession.getMapper(JobMessageAll.class);

        JobRepository jobRepository=sqlSession.getMapper(JobRepository.class);
        JobMessage jobMessage=new JobMessage();
        jobMessage.setUuid(messageAll.getGood1());
        jobMessage.setUsername(messageAll.getGood2());
        jobMessage.setJobPay(messageAll.getJobPay());
        jobMessage.setJobName(messageAll.getJobName());
        jobMessage.setJobConditionTwo(messageAll.getConditionTwo());
        jobMessage.setJobConditionOne(messageAll.getConditionOne());
        jobMessage.setImage(messageAll.getCpnImage());
        jobMessage.setCpnName(messageAll.getCpnName1());
        jobRepository.update(jobMessage);
        jobMessageAll.update(messageAll);
        System.out.println("收到的信息------------------"+messageAll);
        sqlSession.commit();
        sqlSession.close();
        return respVo;
    }


}
