package com.prits.importexportapi.web;

import com.prits.importexportapi.service.ExcelExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by 3ppat on 1/21/2017.
 */
@RestController
public class ExcelExportController {

    @Autowired
    private ExcelExportService excelExportService;

    @RequestMapping(value="/download", method= RequestMethod.GET, produces = "application/vnd.ms-excel")
    public ResponseEntity<InputStreamResource> downloadExcelOutputExl(HttpServletResponse response){

        excelExportService.createExcelOutput(response);
        return null;
    }
}
