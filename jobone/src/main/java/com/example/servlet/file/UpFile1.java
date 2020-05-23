package com.example.servlet.file;//package com.example.servlet.file;
//
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.UrlResource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.ResponseEntity;
//import org.springframework.jdbc.datasource.init.ScriptUtils;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.StandardCopyOption;
//@RestController
//public class UpFile1 {
//
//  private final String  fileBaseDirector="f:";
//
//    private final Path fileBasePath;
//
//    public UpFile1() {
//        this.fileBasePath = Path.of(fileBaseDirector);
//    }
//
//    @GetMapping("/{fileName}")
//    public  ResponseEntity loadFile(@PathVariable String fileName){
//        Path path=fileBasePath.resolve(fileName);
//        Resource resource= null;
//        try {
//            resource = new UrlResource(path.toUri());
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//
//        return  ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=\""+resource.getFilename()+"\"")
//                .body(resource);
//    }
//
//
//
//
//
//
//
//@PostMapping("/upload1")
//public ResponseEntity upload(@RequestParam("file")MultipartFile file){
//        String fileName= StringUtils.cleanPath(file.getOriginalFilename());
//        Path path=Path.of(fileBasePath +fileName);
//    try {
//        Files.copy(file.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//    return ResponseEntity.ok("OK");
//}
//}
