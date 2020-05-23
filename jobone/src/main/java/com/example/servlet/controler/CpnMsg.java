package com.example.servlet.controler;

import com.example.servlet.entity.CpnMsgEn;
import com.example.servlet.entity.JobReturn;
import com.example.servlet.repository.CpnmsgDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CpnMsg {

    @RequestMapping("add/cpn")
    public JobReturn login(@RequestBody CpnMsgEn cpnMsgEn) {
        JobReturn respVo = new JobReturn();
        respVo.setErrmsg("成功");
        respVo.setErrno(200);
        InputStream inputStream = AddJob.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CpnmsgDao cpnmsgDao=sqlSession.getMapper(CpnmsgDao.class);

        cpnmsgDao.update(cpnMsgEn);
        System.out.println("更新cpn"+cpnMsgEn);
        sqlSession.commit();
        sqlSession.close();

        return respVo;
    }
    @RequestMapping("find/cpn")
    public List<CpnMsgEn> find(@RequestBody CpnMsgEn cpnMsgEn) {
        JobReturn respVo = new JobReturn();
        respVo.setErrmsg("成功");
        respVo.setErrno(200);
        InputStream inputStream = AddJob.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CpnmsgDao cpnmsgDao=sqlSession.getMapper(CpnmsgDao.class);

       List<CpnMsgEn>list=new ArrayList<>();
       list= cpnmsgDao.findcpn(cpnMsgEn);
        System.out.println("搜索"+list);
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

}
