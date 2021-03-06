/**
 * Here defined all required classes for excel creation.
 */
package com.springiot.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.Resource;

import com.springiot.constant.CustomerService;

import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 * This class is used for create the xlsx file. For create xlsx file here used
 * the apache lib.
 * 
 * @author TTPL
 *
 */
public class ExcelDailySideStand {
	/**
	 * This constructor is used for create the xlsx templateExcelFile. For
	 * create xlsx templateExcelFile here used the apache lib.
	 */
	public ExcelDailySideStand() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * From this method return XSSFWorkbook object, this class is used for
	 * create the xlsx templateExcelFile. This object is used in DROOL
	 * templateExcelFile(drl templateExcelFile).
	 * 
	 * @return , return the XSSFWorkbook object.
	 * @throws IOException
	 */
	public XSSFWorkbook getXSSFWorkbook(CustomerService customerService) throws IOException {

		// ClassLoader classLoader = getClass().getClassLoader();
		// FileInputStream templateExcelFile = new FileInputStream(
		// new
		// File(classLoader.getResource("Templates/TemplateDailyReportHorn.xlsx").getFile()));

		/* This object required for create xlsx templateExcelFile. */
		Resource resource = customerService.getResource("classpath:com/springiot/excel/TemplateDailyReportSS.xlsx");

		InputStream is = resource.getInputStream();

		XSSFWorkbook workbook = new XSSFWorkbook(is);
		return workbook;

	}

	/**
	 * This method is used for create the xlsx templateExcelFile with different
	 * sheets and data.In this method pass the required values like XSSFWorkbook
	 * object, xlsx templateExcelFile name(report name), templateExcelFile
	 * location(where the templateExcelFile will be create,in config
	 * templateExcelFile defined child templateExcelFile location), connection
	 * string(This is parent database connection string), processed report
	 * procedure(This is procedure function, this is used for add the processed
	 * report details).
	 * 
	 * In this method first set the data in object and object data write in
	 * created xlsx templateExcelFile. After created the xlsx templateExcelFile
	 * call the processed report procedure for update the processed report
	 * table. After created xlsx templateExcelFile return the boolean value
	 * true.
	 * 
	 * @param workbook
	 *            , This is the xlsx templateExcelFile object. This object
	 *            values pass from drl templateExcelFile.
	 * @param reportName
	 *            , This is the xlsx templateExcelFile name, this name is
	 *            defined in config templateExcelFile.
	 * @param fileLocation
	 *            , where the templateExcelFile will be create. In config
	 *            templateExcelFile defined child templateExcelFile location.
	 * @param connection
	 *            ,This is parent database connection string.
	 * @param processedReportPro
	 *            , This is procedure function which is defined in config
	 *            templateExcelFile. This is used for add the processed report
	 *            details.
	 * @return
	 */
	public String createExcel(XSSFWorkbook workbook, String reportName, String fileLocation) {

		try {
			// Initialize templateExcelFile object, and pass the xlsx
			// templateExcelFile location.
			File downloadExcelFile = new File(fileLocation);
			/**
			 * To check the if fileLocation exist or not
			 */
			if (!downloadExcelFile.exists()) {
				downloadExcelFile.mkdirs();
			}

			// initialize the templateExcelFile object for create xlsx
			// templateExcelFile in given location
			// File inputFile = new File("/home/ankita/Desktop/DailyHornReport"
			// + new Date() + ".xlsx");
			File inputFile = new File(downloadExcelFile.getAbsolutePath() + "/" + reportName + ".xlsx");

			/**
			 * To get the Data and write in the downloadExcelFile
			 */
			FileOutputStream out = new FileOutputStream(inputFile);
			workbook.write(out);
			out.close();
			System.out.println("Excel written successfully..");

			return inputFile.getAbsolutePath();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * To Set the data in Excel
	 * 
	 * @param workbook
	 *            ,to get the workbook to set data in it
	 * @param sheetName
	 *            ,The excelSetSheet name in which data will be set in ecxel
	 * @param dataList
	 *            ,The list of map containing data which is to be set
	 * @param reportHeader
	 *            ,Report Header to set the Header in Excel
	 * @return boolean , return boolean value weather data is set in excel or
	 *         not
	 * 
	 */
	@SuppressWarnings("unused")
	public boolean setSheetData(XSSFWorkbook workbook, String sheetName, List<Map<String, Object>> list,
			Map<String, Object> headerDataUrlMessageList) {
		try {
			// add the excelSetSheet name in xlsx templateExcelFile
			XSSFSheet excelSetSheet = workbook.getSheetAt(0);
			// add the Row in xlsx templateExcelFile from where data should be
			// inserted
			Row header = excelSetSheet.getRow(11);
			// for (int rowIndex = 0; rowIndex < reportHeader.size();
			// rowIndex++) {
			// header.createCell(rowIndex).setCellValue((String)
			// reportHeader.get(rowIndex));
			// }

			// Insert the data in xlsx templateExcelFile particular cell which
			// particular value of map

			CellStyle cellStyle = workbook.createCellStyle();
			CreationHelper createHelper = workbook.getCreationHelper();
			short dateFormat = createHelper.createDataFormat().getFormat("yyyy-MM-dd");
			cellStyle.setDataFormat(dateFormat);
			/**
			 * To set the template header data
			 */
			for (int rowIndex = 0; rowIndex < 15; rowIndex++) {
				Row row = excelSetSheet.getRow(rowIndex);

				switch (rowIndex) {
				case 2:
					row.getCell(5).setCellValue(String.valueOf(headerDataUrlMessageList.get("vendor_name")));
					row.getCell(9).setCellValue(String.valueOf(headerDataUrlMessageList.get("model")));
					break;
				case 3:
					row.getCell(5).setCellValue(String.valueOf(headerDataUrlMessageList.get("vendor_code")));

					row.getCell(9).setCellType(Cell.CELL_TYPE_STRING);
					row.getCell(9).setCellStyle(cellStyle);
					row.getCell(9).setCellValue(String.valueOf(headerDataUrlMessageList.get("report_date")));

					break;
				case 4:
					row.getCell(5).setCellValue(String.valueOf(headerDataUrlMessageList.get("part_name")));
					row.getCell(9).setCellValue(String.valueOf(headerDataUrlMessageList.get("inspection_lot_no")));

					break;
				case 5:
					row.getCell(5).setCellValue(String.valueOf(headerDataUrlMessageList.get("part_code")));
					row.getCell(9).setCellType(Cell.CELL_TYPE_STRING);
					row.getCell(9).setCellStyle(cellStyle);
					row.getCell(9).setCellValue(String.valueOf(headerDataUrlMessageList.get("lot_creation_date")));
					break;
				case 10:
					row.getCell(1)
							.setCellValue(String.valueOf(headerDataUrlMessageList.get("power_supply_specification")));
					row.getCell(2).setCellValue(String.valueOf(headerDataUrlMessageList.get("current_specification")));
					row.getCell(3).setCellValue(String.valueOf(headerDataUrlMessageList.get("degree_0_to_15")));
					row.getCell(4).setCellValue(String.valueOf(headerDataUrlMessageList.get("degree_16_to_35")));
					row.getCell(5).setCellValue(String.valueOf(headerDataUrlMessageList.get("degree_greater_than_35")));
					row.getCell(6).setCellValue(
							String.valueOf(headerDataUrlMessageList.get("degree_greater_than_equal_to_10")));
					row.getCell(7).setCellValue(String.valueOf(headerDataUrlMessageList.get("degree_upto_5")));
					row.getCell(8)
							.setCellValue(String.valueOf(headerDataUrlMessageList.get("volts_drop_16_specification")));

					break;

				case 11:
					row.getCell(1).setCellValue(String.valueOf(headerDataUrlMessageList.get("min_value_power_supply")));
					row.getCell(2).setCellValue(String.valueOf(headerDataUrlMessageList.get("min_value_current")));
					row.getCell(3).setCellValue(
							String.valueOf(headerDataUrlMessageList.get("min_value_condition_up_to_down_off_on")));
					row.getCell(6).setCellValue(
							String.valueOf(headerDataUrlMessageList.get("min_value_condition_down_to_up_off")));
					row.getCell(8).setCellValue(String.valueOf(headerDataUrlMessageList.get("min_value_drop_16v")));
					break;

				case 12:
					row.getCell(1).setCellValue(String.valueOf(headerDataUrlMessageList.get("max_value_power_supply")));
					row.getCell(2).setCellValue(String.valueOf(headerDataUrlMessageList.get("max_value_current")));
					row.getCell(3).setCellValue(
							String.valueOf(headerDataUrlMessageList.get("max_value_condition_up_to_down_off_on")));
					row.getCell(6).setCellValue(
							String.valueOf(headerDataUrlMessageList.get("max_value_condition_down_to_up_off")));
					row.getCell(8).setCellValue(String.valueOf(headerDataUrlMessageList.get("max_value_drop_16v")));

				case 13:
					row.getCell(1).setCellValue(String.valueOf(headerDataUrlMessageList.get("avg_value_power_supply")));
					row.getCell(2).setCellValue(String.valueOf(headerDataUrlMessageList.get("avg_value_current")));
					row.getCell(3).setCellValue(
							String.valueOf(headerDataUrlMessageList.get("avg_value_condition_up_to_down_off_on")));
					row.getCell(6).setCellValue(
							String.valueOf(headerDataUrlMessageList.get("avg_value_condition_down_to_up_off")));
					row.getCell(8).setCellValue(String.valueOf(headerDataUrlMessageList.get("avg_value_drop_16v")));
					break;
				case 14:
					row.getCell(1).setCellValue(String.valueOf(headerDataUrlMessageList.get("slot")));

					break;

				default:
					break;
				}

			}
			/**
			 * To set the Grid Data
			 */
			for (int rowIndex = 0; rowIndex < list.size(); rowIndex++) {

				Row dataRow = excelSetSheet.createRow(rowIndex + 16);
				dataRow.setRowStyle(excelSetSheet.getColumnStyle(rowIndex + 15));
				dataRow.getRowStyle();
				/**
				 * to get each row data
				 */
				Map<String, Object> excleRowListMap = (Map<String, Object>) list.get(rowIndex);

				// System.out.println(excleRowListMap);
				int cellIndex = 0;

				for (String key : excleRowListMap.keySet()) {

					String valueRes = String.valueOf(excleRowListMap.get(key));
					/**
					 * To handle the Null Value
					 */
					// if (valueRes == null) {
					// valueRes = "";
					// continue;
					// }

					/**
					 * To create cell and set the data accordingly
					 */

					try {

						int value = Integer.parseInt(valueRes);

						dataRow.createCell(cellIndex).setCellType(Cell.CELL_TYPE_NUMERIC);

						dataRow.createCell(cellIndex).setCellValue(value);

						System.out.println();
					} catch (Exception e) {

						try {

							double value = Double.parseDouble(valueRes);

							dataRow.createCell(cellIndex).setCellType(Cell.CELL_TYPE_NUMERIC);

							dataRow.createCell(cellIndex).setCellValue(value);

						} catch (Exception e2) {

							try {

								dataRow.createCell(cellIndex).setCellType(Cell.CELL_TYPE_STRING);

								dataRow.createCell(cellIndex).setCellValue(valueRes);

							} catch (Exception e3) {

								dataRow.createCell(cellIndex).setCellType(Cell.CELL_TYPE_BLANK);

								dataRow.createCell(cellIndex).setCellValue(valueRes);
							}

						}

					}
					/**
					 * to move to the next cell index
					 */
					cellIndex++;
				}

			}

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * To get date which will be append with the file name
	 * 
	 * @return
	 * @throws Exception
	 */
	public String endDate() throws Exception {
		DateFormat currentFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmss");

		String date = currentFormat.format(new Date());

		return date;

	}

	/**
	 * To convert the date in formatted way
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public String convertDate(Object date) throws ParseException {

		DateFormat currentFormat = new SimpleDateFormat("yyyy-MM-dd");

		// java.sql.Timestamp ts = (java.sql.Timestamp) date;
		String formatteddate = currentFormat.format(date);
		// String out = ts.toString();

		if (formatteddate != null) {

			return formatteddate;
		} else {
			return "";
		}
	}
}
