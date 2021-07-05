package com.xu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@RestController
public class FileController {
    @RequestMapping("/upload1")
    public String upload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        String uploadFileName = file.getOriginalFilename();

        if ("".equals(uploadFileName)) {
            return "redirect:/index.jsp";
        }
        System.out.println(uploadFileName);

        String path = request.getServletContext().getRealPath("/upload");
        File realPath = new File(path);
        if (!realPath.exists()) {
            realPath.mkdir();
        }
        System.out.println(realPath);

        InputStream is = file.getInputStream();
        OutputStream os = new FileOutputStream(new File(realPath, uploadFileName));

        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len=is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
            os.flush();
        }
        os.close();
        is.close();
        return "redirect:/index.jsp";
    }

    public String upload2(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        String path = request.getServletContext().getRealPath("/upload");
        File realPath = new File(path);
        if (!realPath.exists()) {
            realPath.mkdir();
        }
        System.out.println(realPath);
        file.transferTo(new File(realPath + "/" + file.getOriginalFilename()));
        return "redirect:/index.jsp";
    }
    @RequestMapping("/download")
    public String downloads(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String path = request.getServletContext().getRealPath("/upload");
        String fileName = "test1.sh";
        response.reset();//设置页面不缓存，清空buffer
        response.setCharacterEncoding("UTF-8");
        response.setContentType("multipart/form-data");

        response.setHeader("Content-Disposition", "attachment;filename="
        + URLEncoder.encode(fileName, "UTF-8"));

        File file = new File(path, fileName);
        InputStream input = new FileInputStream(file);
        OutputStream out = response.getOutputStream();
        byte[] buff = new byte[1024];
        int index = 0;
        while ((index=input.read(buff)) != -1) {
            out.write(buff, 0, index);
            out.flush();
        }
        out.close();
        input.close();
        return "OK";
    }
}
