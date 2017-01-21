package com.prits.importexportapi.service;

import jxl.Workbook;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.lang.Boolean;

/**
 * Created by 3ppat on 1/21/2017.
 */
@Service
public class ExcelExportService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelExportService.class);

    public WritableWorkbook createExcelOutput(HttpServletResponse response) {
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
       /* sheet.addCell(new Label(4, 0, " Header 5",cf));
        sheet.addCell(new Label(5, 0, " Header 6",cf));
        sheet.addCell(new Label(6, 0, " Header 7",cf));
        sheet.addCell(new Label(7, 0, " Header 8",cf));
        sheet.addCell(new Label(8, 0, " Header 9",cf));
        sheet.addCell(new Label(9, 0, " Header 10",cf));
        sheet.addCell(new Label(10, 0, " Header 11",cf));*/
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
            /*sheet.addCell(new Label(5, rowNo, "Col Data " + (rowNo + 5)));
            sheet.addCell(new Label(6, rowNo, "Col Data " + (rowNo + 6)));
            sheet.addCell(new Label(7, rowNo, "Col Data " + (rowNo + 7)));
            sheet.addCell(new Label(8, rowNo, "Col Data " + (rowNo + 8)));
            sheet.addCell(new Label(9, rowNo, "Col Data " + (rowNo + 9)));
            sheet.addCell(new Label(10, rowNo, "Col Data " + (rowNo + 10)));*/

        }


    }
}