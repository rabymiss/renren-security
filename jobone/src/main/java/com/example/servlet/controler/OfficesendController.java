package com.example.servlet.controler;


import com.example.servlet.entity.JobReturn;
import com.example.servlet.entity.Officesend;
import com.example.servlet.entity.RespVo;
import com.example.servlet.entity.User;
import com.example.servlet.repository.JobMessageAll;
import com.example.servlet.repository.OffiDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author southwind
 * @since 2020-05-18
 */
@RestController
public class OfficesendController {

    @RequestMapping("find/all/offi")
    public JobReturn findall(){
        JobReturn jobReturn = new JobReturn();
        jobReturn.setErrmsg("成功");
        jobReturn.setErrno(200);
        InputStream inputStream = OfficesendController.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OffiDao offiDao = sqlSession.getMapper(OffiDao.class);
        List<Officesend>list=offiDao.findall();
        jobReturn.setData(list);
        sqlSession.commit();
        sqlSession.close();
        return jobReturn;
    }
    @RequestMapping("save/offi")
    public JobReturn saveoffi(@RequestBody Officesend officesend){
        JobReturn jobReturn = new JobReturn();
        jobReturn.setErrmsg("成功");
        jobReturn.setErrno(200);
        InputStream inputStream = OfficesendController.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OffiDao offiDao = sqlSession.getMapper(OffiDao.class);
        offiDao.save(officesend);
        System.out.println("上传off--------------------"+officesend);
        sqlSession.commit();
        sqlSession.close();
        return jobReturn;
    }
    @RequestMapping("find/offi/by")
    public JobReturn findbyid(@RequestBody User user){
        JobReturn jobReturn = new JobReturn();
        jobReturn.setErrmsg("成功");
        jobReturn.setErrno(200);
        InputStream inputStream = OfficesendController.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OffiDao offiDao = sqlSession.getMapper(OffiDao.class);
        Officesend officesend=new Officesend();
        officesend.setT1(user.getUsername());
        System.out.println("上传人才--------------------"+user);
       List<Officesend>list= offiDao.findoffiby(officesend);
        System.out.println("查找offi--------------------"+list);
        jobReturn.setData(list);
        sqlSession.commit();
        sqlSession.close();
        return jobReturn;
    }
    @RequestMapping("delete/offi/by")
    public JobReturn deletebyid(@RequestBody User user){
        JobReturn jobReturn = new JobReturn();
        jobReturn.setErrmsg("成功");
        jobReturn.setErrno(200);
        InputStream inputStream = OfficesendController.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OffiDao offiDao = sqlSession.getMapper(OffiDao.class);
        Officesend officesend=new Officesend();
        officesend.setOfuuid(user.getUsername());
        officesend.setCpnid(user.getPassword());
        officesend.setT1(user.getPassword());
        offiDao.deleteby(officesend);
        System.out.println("删除--------------------"+officesend);
        sqlSession.commit();
        sqlSession.close();
        return jobReturn;
    }
    @RequestMapping("find/offi/bycpnid")
    public JobReturn findbycpnid(@RequestBody User user){
        JobReturn jobReturn = new JobReturn();
        jobReturn.setErrmsg("成功");
        jobReturn.setErrno(200);
        InputStream inputStream = OfficesendController.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OffiDao offiDao = sqlSession.getMapper(OffiDao.class);
        Officesend officesend=new Officesend();
        officesend.setCpnid(user.getUsername());
        System.out.println("上传企业--------------------"+user);
        List<Officesend>list= offiDao.findoffibycpnid(officesend);
        System.out.println("查找offi--------------------"+list);
        jobReturn.setData(list);
        sqlSession.commit();
        sqlSession.close();
        return jobReturn;
    }

}

