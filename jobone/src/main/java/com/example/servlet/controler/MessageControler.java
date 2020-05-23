package com.example.servlet.controler;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.example.servlet.entity.User;
import com.example.servlet.repository.UserRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;

@RestController
public class MessageControler {

    @RequestMapping("user/update")
    public void updaepassword(@RequestBody User user) {
        InputStream inputStream = Login.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserRepository userRepository = sqlSession.getMapper(UserRepository.class);

        userRepository.update(user);
        sqlSession.commit();
        sqlSession.close();
        System.out.println("修改密码"+user);

    }
    @RequestMapping("user/login/message")
    public User loginmessage(@RequestBody User user) {
        String accessKeyId="LTAI4G9rvwoZmBXTaqNL2osp";
        String accessSecret="7BEe7G10pMnDDWRkg62b3wAPJwOYaO";
        String str="";
        for (int i=0;i<6;i++){
            str +=(int)Math.floor(Math.random()*10);

        }
        System.out.println("code------------"+str);


        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou",accessKeyId,accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", user.getUsername());
        request.putQueryParameter("SignName", "蓝汛");
        request.putQueryParameter("TemplateCode", "SMS_189613123");
        request.putQueryParameter("TemplateParam", "{\"code\":\""+str+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }



        InputStream inputStream = Login.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
        User user2 = new User(user.getUsername(),str );
        userRepository.save(user2);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(user2);
        return user;

    }

    @RequestMapping("user/login/forget")
    public User loginfor(@RequestBody User user) {

        String accessKeyId="LTAI4G9rvwoZmBXTaqNL2osp";
        String accessSecret="7BEe7G10pMnDDWRkg62b3wAPJwOYaO";
        String str="";
        for (int i=0;i<6;i++){
            str +=(int)Math.floor(Math.random()*10);

        }
        System.out.println("code------------"+str);


        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou",accessKeyId,accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", user.getUsername());
        request.putQueryParameter("SignName", "美食时间");
        request.putQueryParameter("TemplateCode", "SMS_189613123");
        request.putQueryParameter("TemplateParam", "{\"code\":\""+str+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }



        InputStream inputStream = Login.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
        User user2 = new User(user.getUsername(),str );
        userRepository.savefor(user2);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(user2);
        return user;

    }

    @RequestMapping("user/login/for")
    public User loginforaa(@RequestBody User user) {
        InputStream inputStream = Login.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
        Long count = userRepository.findUserfor(user.getUsername(), user.getPassword());
        User user2 = new User(count.toString(), count.toString());

        if (count==1){
            userRepository.deleteusertttttuu(user);
            sqlSession.commit();
            sqlSession.close();
        }

        System.out.println(count);

        System.out.println(user);
        return user2;

    }

}
