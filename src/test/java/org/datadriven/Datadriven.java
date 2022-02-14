package org.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datadriven {
	public static FileInputStream fs;
	public static Workbook w;
	public static Sheet sh1;
	public static Row r1;
	public static Cell c1;

	String path = null;

	Datadriven(String path) {
		this.path = path;
	}

	public int getRowCount(String sheetname) throws IOException {
		fs = new FileInputStream(path);
		w = new XSSFWorkbook(fs);
		sh1 = w.getSheet(sheetname);
		int rowcount = sh1.getLastRowNum();
		fs.close();
		return rowcount;
	}

	public int getCellCount(String sheetname, int rowno) throws IOException {
		fs = new FileInputStream(path);
		w = new XSSFWorkbook(fs);
		sh1 = w.getSheet(sheetname);
		Row c1 = sh1.getRow(rowno);
		int cellcount = c1.getLastCellNum();
		fs.close();
		return cellcount;

	}

	public String getcelldat(String sheetname, int rowno, int colum) throws IOException {
		fs = new FileInputStream(path);
		w = new XSSFWorkbook(fs);
		sh1 = w.getSheet(sheetname);
		Row c1 = sh1.getRow(rowno);
		Cell cell = c1.getCell(colum);

		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data = formatter.formatCellValue(cell);
		} catch (Exception e) {
			data = "";
		}
		fs.close();
		return data;
	}

	public void setCellData(String sheetname, int rowno, int colum, String data) throws IOException {
		fs = new FileInputStream(path);
		w = new XSSFWorkbook(fs);
		sh1 = w.getSheet(sheetname);
		Row r1 = sh1.getRow(rowno);
		Cell cell = r1.createCell(colum);
		cell.setCellValue(data);
		FileOutputStream fo = new FileOutputStream(path);
		w.write(fo);
		fs.close();
		fo.close();

	}
}
