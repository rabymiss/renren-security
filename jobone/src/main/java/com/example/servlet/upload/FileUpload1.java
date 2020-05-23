package com.example.servlet.upload;



import com.example.servlet.controler.CpnMsg;
import com.example.servlet.entity.CpnMsgEn;
import com.example.servlet.entity.File2;
import com.example.servlet.entity.User;
import com.example.servlet.repository.CpnmsgDao;
import com.example.servlet.repository.FileDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;


//............................
@RestController
public class FileUpload1 {

    private final String fileBaseDirect="";
    private  final Path fileBasePath1;
// File file=new File();
    private List<String> data=new ArrayList<String>();
    private List<String> datacook=new ArrayList<String>();
    public FileUpload1(){
        this.fileBasePath1=Path.of(fileBaseDirect);


    }


    @GetMapping("/{fileName}")

    public ResponseEntity loadFile(@PathVariable String fileName){

        Path path =fileBasePath1.resolve(fileName);
        Resource resource=null;
        try {
            resource=new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return     ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=\""+resource.getFilename()+"\"")
                .body(resource);

    }

    @RequestMapping ("updown12")
        public User upload(@RequestParam("files")MultipartFile[] files, @RequestParam Map<String,String>params ){
        data.clear();
        InputStream inputStream = FileUpload1.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CpnmsgDao cpnmsgDao=sqlSession.getMapper(CpnmsgDao.class);

for (MultipartFile multipartFile:files) {



    String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename());
  String  filename1=UUID.randomUUID()+filename;
  data.add(filename1);
    System.out.println("UUID"+filename1);
    Path path = Path.of(fileBaseDirect + filename1);


    try {
        Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);


    } catch (IOException e) {
        e.printStackTrace();
    }



}
        String x=params.get("description");

        String str=x.replace("\"","");
        CpnMsgEn cpnMsgEn=new CpnMsgEn();
        if (data.size()!=0){
            cpnMsgEn.setIcon(data.get(0));
        }

        cpnMsgEn.setWorkin(str);
User user=new User();
user.setUsername(cpnMsgEn.getIcon());

        cpnmsgDao.update(cpnMsgEn);
        System.out.println("更新cpn"+cpnMsgEn);
sqlSession.commit();
sqlSession.close();
        System.out.println("返回的------------"+user);
return user;

    }
    @RequestMapping ("updown/cook")
    public void uploadcook(@RequestParam("files")MultipartFile[] files,@RequestParam Map<String,String>params ){
datacook.clear();
        InputStream inputStream = CpnMsg.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CpnmsgDao cpnmsgDao=sqlSession.getMapper(CpnmsgDao.class);
        FileDao fileDao=sqlSession.getMapper(FileDao.class);


//        AddCookRepository addCookRepository=sqlSession.getMapper(AddCookRepository.class);
//        CookShowEntity cookShowEntity=new CookShowEntity();
        for (MultipartFile multipartFile:files) {



            String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            String  filename1=UUID.randomUUID()+filename;

            datacook.add(filename1);
            Path path = Path.of(fileBaseDirect + filename1);


            try {
                Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);


            } catch (IOException e) {
                e.printStackTrace();
            }



        }

        String x=params.get("description");
        File2 file2=new File2();
        String str=x.replace("\"","");
        CpnMsgEn cpnMsgEn=new CpnMsgEn();
        cpnMsgEn.setIcon(datacook.get(0));
        cpnMsgEn.setWorkin(str);
        file2.setF1(datacook.get(0));
        fileDao.save(file2);
        cpnmsgDao.update(cpnMsgEn);
        sqlSession.commit();
        sqlSession.close();


    }
}

