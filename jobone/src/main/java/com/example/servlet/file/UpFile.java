package com.example.servlet.file;//package com.example.servlet.file;
//
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.core.io.InputStreamResource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.BufferedOutputStream;
//import java.io.FileOutputStream;
//import java.nio.file.FileSystem;
//
//@RestController
//public class UpFile {
//    @RequestMapping("/upload")
//    public String upload(@RequestParam("file") MultipartFile file) throws Exception {
//        String filePath =file.getOriginalFilename();
//        BufferedOutputStream outputStream=new BufferedOutputStream(new FileOutputStream(filePath));
//        outputStream.write(file.getBytes());
//        outputStream.flush();
//        outputStream.close();
//      String ss="成功";
//        return  ss;
//    }
//
//    @RequestMapping("/download")
//    public ResponseEntity download() throws Exception{
//
//        FileSystemResource fileSystem=new FileSystemResource("ic_food_dinner.png") ;
//        HttpHeaders headers=new HttpHeaders();
//        headers.add("Content-Disposition","attachment; filename=ic_food_dinner.png");
//        return  ResponseEntity.ok()
//                .header(String.valueOf(headers))
//                .contentLength(fileSystem.contentLength())
//                .contentType(MediaType.parseMediaType("application/octet-stream"))
//                .body(new InputStreamResource(fileSystem.getInputStream()));
//
//    }
//}
