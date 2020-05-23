package com.example.servlet.controler;//package com.example.servlet.controler;
//
//import com.example.servlet.socket.Sendother;
//import lombok.SneakyThrows;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//public class Socket {
//    public static   List<Sendother>list=new ArrayList<>();
//
//    @RequestMapping("doing/socket")
//    public void info() {
//
//
//        System.out.println("。。。。。。。。。。。。线程已启动。。。。。。。。。。。。。。。。。。。。");
//        ServerSocket servert= null;
//        try {
//            servert = new ServerSocket(1000);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        while (true){
//            java.net.Socket socket= null;
//            try {
//                socket = servert.accept();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Sendother sendother=new Sendother(socket);
//            String address=socket.getInetAddress().getHostAddress();
//            System.out.println(address);
//            list.add(sendother);
//            System.out.println("新用户加入");
//            System.out.println("当前在线人数"+list.size());
//            new Thread(sendother).start();
//        }
//
//
//        //  new ChatServer().start();
//
//    }
//
//
//
//}
//
