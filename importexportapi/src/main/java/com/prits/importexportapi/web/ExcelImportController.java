package com.prits.importexportapi.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by 3ppat on 1/22/2017.
 */
@RestController
public class ExcelImportController {

    private static final Logger logger = LoggerFactory.getLogger(ExcelImportController.class);

    @RequestMapping(value="/upload", method= RequestMethod.POST)
    public @ResponseBody   String handleFileUpload(@RequestParam("file") MultipartFile file){

        logger.info("Uploading file to path : {}",System.getProperty("java.io.tmpdir"));
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
        }
    }



}
