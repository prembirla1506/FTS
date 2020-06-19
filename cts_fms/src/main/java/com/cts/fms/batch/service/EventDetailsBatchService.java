package com.cts.fms.batch.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.fms.batch.dto.EventPocDetails;
import com.cts.fms.batch.scheduler.FmsCtsTaskScheduler;

@Service
public class EventDetailsBatchService {
	private static final Logger LOGGER = LoggerFactory.getLogger(FmsCtsTaskScheduler.class);
	@Autowired
	private BatchService batchService;

	public void readExcelFileforEvnetDetails(String excelFilePath) {

		System.out.println("file path" + excelFilePath);

		FileInputStream inputStream = null;
		try {

			
				inputStream = new FileInputStream(excelFilePath);
			

			Workbook workbook = new XSSFWorkbook(inputStream);

			Sheet firstSheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = firstSheet.iterator();

			rowIterator.next(); // skip the header row
			List<EventPocDetails> listEventDetails = new ArrayList<EventPocDetails>();

			while (rowIterator.hasNext()) {
				Row nextRow = rowIterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				EventPocDetails eventDetailsObj = new EventPocDetails();

				while (cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();
					DataFormatter formatter = new DataFormatter();
					int columnIndex = nextCell.getColumnIndex();
					// System.out.print("
					// "+formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex))+"
					// ");

					// System.out.println("row num=="+nextRow.getRowNum()+" "+"colum
					// indes=="+columnIndex+" column value==
					// "+formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));

					switch (columnIndex) {
					case 0:
						eventDetailsObj.setEventID(
								formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));
						break;
					case 1:
						eventDetailsObj.setMonth(
								formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));
					case 2:
						eventDetailsObj.setBaseLocation(
								formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));
					case 3:
						eventDetailsObj.setBenificialryName(
								formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));
					case 4:
						eventDetailsObj.setVenueAddress(
								formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));
					case 5:
						eventDetailsObj.setConuncilName(
								formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));
					case 6:
						eventDetailsObj.setProject(
								formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));
					case 7:
						eventDetailsObj.setCategory(
								formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));
					case 8:
						eventDetailsObj.setEventName(
								formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));
					case 9:
						eventDetailsObj.setEventDescription(
								formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));
					case 10:
						eventDetailsObj.setEventDate(
								formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));
					case 11:
						eventDetailsObj.setTotalNoOfVolunteres(
								formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));
					case 12:
						eventDetailsObj.setVoluntersHours(
								formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));
					case 13:
						eventDetailsObj.setTotalTravelHour(
								formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));
					case 14:
						eventDetailsObj.setAllVolunteerHour(
								formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));
					case 15:
						eventDetailsObj.setLivesImpacted(
								formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));
					case 16:
						eventDetailsObj.setActivityType(
								formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));
					case 17:
						eventDetailsObj.setStatus(
								formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));
					case 18:
						eventDetailsObj.setPocId(
								formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));
					case 19:
						eventDetailsObj.setPocName(
								formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));
					case 20:
						eventDetailsObj.setPocEmail(
								formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));

					}

				}

				listEventDetails.add(eventDetailsObj);
			}

			batchService.InsertIntoDataBase(listEventDetails);

			workbook.close();
			

		}
		 catch (FileNotFoundException e) {
				LOGGER.info("File NOt FOund----");

			}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
