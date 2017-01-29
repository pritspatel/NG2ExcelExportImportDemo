package com.prits.importexportapi.service;

import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.Boolean;

/**
 * Created by 3ppat on 1/21/2017.
 */
@Service
public class ExcelExportService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelExportService.class);


    public void generateExcel(HttpServletResponse response) throws IOException {
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("new sheet");

        // Create a row and put some cells in it. Rows are 0 based.
        Row row = sheet.createRow((short) 0);
        // Create a cell and put a value in it.
        Cell cell = row.createCell(0);
        cell.setCellValue(1);

        Cell cell1 = row.createCell(1);
        cell1.setCellValue("40-GHI");

        CellRangeAddressList addressList = new CellRangeAddressList(0, 0, 0, 0);
        DVConstraint dvConstraint = DVConstraint.createExplicitListConstraint(
                new String[]{"10", "20", "30"});
        DataValidation dataValidation = new HSSFDataValidation(addressList, dvConstraint);
        dataValidation.setSuppressDropDownArrow(false);
        sheet.addValidationData(dataValidation);

        CellRangeAddressList addressList1 = new CellRangeAddressList(0, 0, 1, 1);
        DVConstraint dvConstraint1 = DVConstraint.createExplicitListConstraint(
                new String[]{"40--GHI", "50--DEF", "60--ABC"});
        DataValidation dataValidation1 = new HSSFDataValidation(addressList1, dvConstraint1);
        dataValidation1.setSuppressDropDownArrow(false);
        sheet.addValidationData(dataValidation1);


        response.setContentType("application/vnd.ms-excel");

        response.setHeader("Content-Disposition", "attachment; filename=" + "test.xls");

        wb.write(response.getOutputStream());
        wb.close();


    }
    /*public WritableWorkbook createExcelOutput(HttpServletResponse response) {
        String fileName = "Excel_Output.xls";
        WritableWorkbook writableWorkbook = null;
        try {
            response.setContentType("application/vnd.ms-excel");

            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

            writableWorkbook = Workbook.createWorkbook(response.getOutputStream());

            WritableSheet excelOutputsheet = writableWorkbook.createSheet("Excel Output", 0);
            addExcelOutputHeader(excelOutputsheet);
            writeExcelOutputData(excelOutputsheet);

            writableWorkbook.write();
            writableWorkbook.close();

        } catch (Exception e) {
            LOGGER.error("Error occured while creating Excel file", e);
        }

        return writableWorkbook;
    }

    private void addExcelOutputHeader(WritableSheet sheet) throws RowsExceededException, WriteException {
        // create header row
        WritableCellFormat cf = new WritableCellFormat();
        cf.setLocked(true);
        sheet.addCell(new Label(0, 0, "Header 1", cf));
        sheet.addCell(new Label(1, 0, " Header 2",cf));
        sheet.addCell(new Label(2, 0, " Header 3",cf));
        sheet.addCell(new Label(3, 0, " Header 4",cf));
        sheet.getSettings().setProtected(Boolean.TRUE);

    }

    private void writeExcelOutputData(WritableSheet sheet) throws RowsExceededException, WriteException {

        WritableCellFormat unlocked = new WritableCellFormat();
        unlocked.setLocked(false);

        for (int rowNo = 1; rowNo <= 10; rowNo++) {
            sheet.addCell(new Label(0, rowNo, "Col Data " + (rowNo + 0),unlocked));
            sheet.addCell(new Label(1, rowNo, "Col Data " + (rowNo + 1),unlocked));
            sheet.addCell(new Label(2, rowNo, "Col Data " + (rowNo + 2),unlocked));
            sheet.addCell(new Label(3, rowNo, "Col Data " + (rowNo + 3),unlocked));
            sheet.addCell(new Label(4, rowNo, "Col Data " + (rowNo + 4),unlocked));
        }


    }*/
}