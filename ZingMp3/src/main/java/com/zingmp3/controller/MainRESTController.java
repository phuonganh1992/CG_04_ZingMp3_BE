package com.zingmp3.controller;

import com.zingmp3.model.Form;
import com.zingmp3.model.UploadForm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin("*")
public class MainRESTController {
    @Value("${UPLOAD_URL}")
    private String UPLOAD_DIR;

//    private static String UPLOAD_DIR="D:\\Module4_Java_Web_Spring\\AJAX\\0108_demo\\image\\";

//    @PostMapping("/rest/uploadMultiFiles")
//    public ResponseEntity<?> multiUploadFileModel(@ModelAttribute UploadForm form) {
//        System.out.println("Description:" + form.getDescription());
//        String result = null;
//        try {
//            result = this.saveUploadedFiles(form.getFiles());
//        } catch (IOException e) {
//            e.printStackTrace();
//            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<String>("Uploaded to: <br/>" + result, HttpStatus.OK);
//
//    }
//
//    private String saveUploadedFiles(MultipartFile[] files) throws IOException {
//        File uploadDir = new File(UPLOAD_DIR);
//        uploadDir.mkdirs();
//        StringBuilder sb = new StringBuilder();
//        for (MultipartFile file : files) {
//            if (file.isEmpty()) {
//                continue;
//            }
//            String uploadFilePath = UPLOAD_DIR + "/" + file.getOriginalFilename();
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get(uploadFilePath);
//            Files.write(path, bytes);
//            sb.append(uploadFilePath).append("<br/>");
//        }
//        return sb.toString();
//    }

    @PostMapping("/rest/upload")
    public ResponseEntity<?> multiUploadFileModel2(Form form) {
//        User user = new User();
//        user.setName(form.getName());
//        user.setImageUrls(form.getFile().getOriginalFilename());
//        MultipartFile image = form.getFile();
//        String fileName = image.getOriginalFilename();
        MultipartFile file=form.getFile();

        String filename=file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(),
                    new File(UPLOAD_DIR + filename)); // coppy ảnh từ ảnh nhận được vào thư mục quy định,
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(filename, HttpStatus.OK);

    }
}
