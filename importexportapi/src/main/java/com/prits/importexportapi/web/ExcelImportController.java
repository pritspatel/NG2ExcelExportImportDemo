package com.prits.importexportapi.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by 3ppat on 1/22/2017.
 */
@RestController
public class ExcelImportController {

    private static final Logger logger = LoggerFactory.getLogger(ExcelImportController.class);

    @RequestMapping(value="/upload", method= RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public @ResponseBody String uploadFile(HttpServletRequest request, HttpServletResponse response){
    //public @ResponseBody   String handleFileUpload(@RequestParam("file") MultipartFile file){

        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        Iterable<String> fileNames = (Iterable<String>) req.getFileNames();
        for(String fname : fileNames){
            logger.info("*************** File name : " + fname);
        }
        /*logger.info("Uploading file to path : {}",System.getProperty("java.io.tmpdir"));
        String path = "c:\\tmp\\uploads\\";
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(path + file.getName() + "-uploaded.xls" )));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + file.getName() + " into " + path + "-uploaded !";
            } catch (Exception e) {
                return "You failed to upload " + path + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + path + " because the file was empty.";
        }*/

        return "success";
    }



}
