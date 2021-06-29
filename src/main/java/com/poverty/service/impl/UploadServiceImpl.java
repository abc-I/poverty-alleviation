package com.poverty.service.impl;

import com.poverty.util.PathUtil;
import com.poverty.service.UploadService;
import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import com.spire.doc.Section;
import com.spire.doc.collections.SectionCollection;
import com.spire.doc.documents.Paragraph;
import com.spire.doc.fields.DocPicture;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.nio.file.Files;
import java.util.UUID;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/18 15:09
 */
@Service
public class UploadServiceImpl implements UploadService {

    @Resource
    private PathUtil pathUtil;

    /**
     * 上传图片
     *
     * @param file 文件保存对象
     * @return String
     */
    @Override
    public String uploadPicture(MultipartFile file) {
        String path = pathUtil.getImagePath();

        String fileName = upload(file, path);
        if (fileName != null) {
            return "/static/image/" + fileName;
        } else {
            return null;
        }
    }

    /**
     * 上传视频
     *
     * @param file 文件保存对象
     * @return String
     */
    @Override
    public String uploadVideo(MultipartFile file) {
        String path = pathUtil.getVideoPath();

        String fileName = upload(file, path);
        if (fileName != null) {
            return "/static/video/" + fileName;
        } else {
            return null;
        }
    }

    /**
     * 上传docx
     *
     * @param file file 文件保存对象
     * @return String
     */
    @Override
    public String uploadDocx(MultipartFile file) {
        // docx保存位置
        String docxBase = pathUtil.getDocxPath();
        String htmlBase = pathUtil.getHtmlPath();

        // 保存docx文件，获取文件名
        String fileName = upload(file, docxBase);
        // 判读是否上传成功
        if (fileName == null) {
            return null;
        }
        // 加载文件到document
        Document document = new Document(docxBase + fileName);

        // 获取保存的docx文件的文件名
        String prefix = fileName.substring(0, fileName.indexOf("."));
        // txt文件路径+文件名
        String txtPath = htmlBase + prefix + ".txt";

        // 将docx转换成html，以txt文件形式储存
        document.saveToFile(txtPath, FileFormat.Html);

        try (
                // 读取txt文件
                BufferedReader reader = new BufferedReader(new FileReader(txtPath));
                // 保存为html文件
                BufferedWriter writer = new BufferedWriter(new FileWriter(htmlBase + prefix + ".html"))
        ) {
            // 读取行
            String line;
            while ((line = reader.readLine()) != null) {
                // 修改图片路径后写出
                writer.write(line.replace("src=\"" + prefix + "_images",
                        "src=\"" + pathUtil.getBaseUrl() + "static/html/" + prefix + "_images"));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        // 删除txt文件
        File file1 = new File(txtPath);
        if (file1.exists()) {
            file1.delete();
        }

        return "/static/html/" + prefix + ".html";
    }

    /**
     * 解析请求对象
     *
     * @param file 文件保存对象
     * @param path 保存路径
     * @return boolean
     */
    private String upload(MultipartFile file, String path) {
        if (file == null || file.isEmpty()) {
            return null;
        }

        String name = file.getOriginalFilename();

        String suffix = null;
        if (name != null) {
            suffix = name.substring(name.lastIndexOf("."));
        }

        String fileName = UUID.randomUUID().toString().replace("-", "") + suffix;

        File placeFile = new File(path);
        if (!placeFile.exists()) {
            placeFile.mkdirs();
        }

        try (
                InputStream in = file.getInputStream();
                OutputStream out = new FileOutputStream(path + fileName)
        ) {
            int len;
            byte[] buffer = new byte[1024 * 1024];
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }

            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
