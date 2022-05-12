package axiomq.com.starwars.controllers;

import axiomq.com.starwars.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@CrossOrigin
public class FileUploadController {


    @PostMapping("/api/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file){
        try{
            createDirIfNotExists();
            byte[] bytes = new byte[0];
            bytes = file.getBytes();
            Files.write(Paths.get(FileUtil.folderPath + file.getOriginalFilename()), bytes);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("File uploaded successfully: " + file.getOriginalFilename() + "!");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body("Exception occurred for: " + file.getOriginalFilename() + "!");
        }
    }

    private void createDirIfNotExists(){
        File directory = new File(FileUtil.folderPath);
        if(!directory.exists()){
            directory.mkdir();
        }
    }

    @GetMapping("/api/files")
    public ResponseEntity<String[]> getListFiles(){
        return ResponseEntity.status(HttpStatus.OK)
                .body((new java.io.File(FileUtil.folderPath).list()));
    }
}
