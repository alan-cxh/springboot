package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.UUID;

/**
 * 单个或者多文件上传功能
 * Created by Alan on 2017/12/1.
 */
@Controller
@RequestMapping("file")
public class FileController {


    private String fileAddress;

    @RequestMapping("/fileUploadUI")
    public String fileUploadUI(){
        return "fileUpload";
    }


    /**
     * 提取上传方法为公共方法
     * @param uploadDir 上传文件目录
     * @param file 上传对象
     * @throws Exception
     */
    private void executeUpload(String uploadDir,MultipartFile file) throws Exception
    {

        file.getOriginalFilename(); // 获取上传的文件名
        //文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //上传文件名
        String filename = UUID.randomUUID() + suffix;
        //服务器端保存的文件对象
//        File serverFile = new File(uploadDir + filename);
//        此处 文件名：file.getOriginalFilename()，以此为文件名保存到硬盘下，因此每次保存文件时原则是新文件覆盖旧文件
        File serverFile = new File(uploadDir + file.getOriginalFilename());
        //将上传的文件写入到服务器端文件内
        file.transferTo(serverFile);
    }
    /**
     * 单个文件上传
     * @return
     */
//    @ResponseBody
    @RequestMapping(value = "/simpleFileUpload", method = RequestMethod.POST)
    public  String upload(HttpServletRequest request, MultipartFile file, Model model)
    {
        String filename = file.getOriginalFilename();
        if (filename != null && !"".equals(filename)){
            model.addAttribute("filename", filename);
        }

        try {
            //上传目录地址
//            String uploadDir ="E:///java//workspace//springboot//src//main//webapp//upload/";
            String uploadDir = "E:///upload/";
            //如果目录不存在，自动创建文件夹
            File dir = new File(uploadDir);
            if(!dir.exists())
            {
                dir.mkdir();
            }
            //调用上传方法
            executeUpload(uploadDir, file);
        } catch (Exception e) {
            //打印错误堆栈信息
            e.printStackTrace();
            return "error/404";
        }
        return "fileUpload";
    }

    @ResponseBody
    @RequestMapping(value = "/multiFileUpload", method = RequestMethod.POST)
    public  String uploads(HttpServletRequest request,MultipartFile[] file)
    {
        try {
            //上传目录地址
            String uploadDir = request.getSession().getServletContext().getRealPath("/") +"upload/";
            //如果目录不存在，自动创建文件夹
            File dir = new File(uploadDir);
            if(!dir.exists())
            {
                dir.mkdir();
            }
            //遍历文件数组执行上传
            for (int i = 0; i< file.length; i++) {
                if(file[i] != null) {
                    //调用上传方法
                    executeUpload(uploadDir, file[i]);
                }
            }
        } catch (Exception e) {
            //打印错误堆栈信息
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }

    @RequestMapping("download")
    public String download(HttpServletResponse response) {

        return  null;
    }

}
