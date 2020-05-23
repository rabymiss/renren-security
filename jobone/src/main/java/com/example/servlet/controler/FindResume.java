package com.example.servlet.controler;

import com.example.servlet.entity.*;
import com.example.servlet.repository.ResumeRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.List;

@RestController
public class FindResume {
    @RequestMapping("find/mesume/byid")
    public JobReturn findbyid(@RequestBody User user) {
        JobReturn jobReturn = new JobReturn();
        jobReturn.setErrmsg("成功");
        jobReturn.setErrno(200);
        InputStream inputStream = FindResume.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ResumeRepository resumeRepository =sqlSession.getMapper(ResumeRepository.class);
        Resume resume=new Resume();
        resume.setCpnid(user.getUsername());
        List<Resume> list = resumeRepository.findAllby(resume);
        System.out.println("寻找简历---------------"+resume);
        jobReturn.setData(list);
        sqlSession.commit();
        sqlSession.close();
        return jobReturn;
    }
    @RequestMapping("save/resume")
    public JobReturn saveresume(@RequestBody Resume resume) {
        JobReturn jobReturn = new JobReturn();
        jobReturn.setErrmsg("成功");
        jobReturn.setErrno(200);
        InputStream inputStream = FindResume.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ResumeRepository resumeRepository =sqlSession.getMapper(ResumeRepository.class);
       resumeRepository.save(resume);
        System.out.println("上传简历---------------"+resume);

        sqlSession.commit();
        sqlSession.close();
        return jobReturn;
    }
    @RequestMapping("delete/resume/uuid")
    public JobReturn deleteesume(@RequestBody User user) {
        JobReturn jobReturn = new JobReturn();
        jobReturn.setErrmsg("成功");
        jobReturn.setErrno(200);
        InputStream inputStream = FindResume.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ResumeRepository resumeRepository =sqlSession.getMapper(ResumeRepository.class);
        Resume resume=new Resume();
        resume.setUuid(user.getUsername());
        resume.setCpnid(user.getPassword());
        resume.setT1(user.getPassword());
        resumeRepository.deletebyuuid(resume);

        System.out.println("删除---------------"+user);
        System.out.println("删除---------------"+resume);

        sqlSession.commit();
        sqlSession.close();
        return jobReturn;
    }


//    个人操作.......................................................................
@RequestMapping("savep/resume/uuid")
public JobReturn savep(@RequestBody PersonResume personResume) {
    JobReturn jobReturn = new JobReturn();
    jobReturn.setErrmsg("成功");
    jobReturn.setErrno(200);
    InputStream inputStream = FindResume.class.getClassLoader().getResourceAsStream("config.xml");
    SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    ResumeRepository resumeRepository =sqlSession.getMapper(ResumeRepository.class);
    resumeRepository.updatep(personResume);

    System.out.println("上传---简历------------"+personResume);
    sqlSession.commit();
    sqlSession.close();
    return jobReturn;
}

    @RequestMapping("findp/resume/uuid")
    public List<PersonResume> findp(@RequestBody PersonResume personResume) {
        JobReturn jobReturn = new JobReturn();
        jobReturn.setErrmsg("成功");
        jobReturn.setErrno(200);
        InputStream inputStream = FindResume.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ResumeRepository resumeRepository =sqlSession.getMapper(ResumeRepository.class);
        List<PersonResume>list=resumeRepository.findAllbyp(personResume);
        System.out.println("查找---------------"+personResume);
        sqlSession.commit();
        sqlSession.close();
        return list;
    }




}
