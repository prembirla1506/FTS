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
import com.cts.fms.batch.dto.EventSummaryDetails;
import com.cts.fms.batch.scheduler.FmsCtsTaskScheduler;

@Service
public class EventSummaryBatchService {
	private static final Logger LOGGER = LoggerFactory.getLogger(FmsCtsTaskScheduler.class);
	@Autowired
	private BatchService batchService;

	public void readExcelFileforEvnetDetails(String excelFilePath) {
		System.out.println("file path" + excelFilePath);

		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(excelFilePath);
				Workbook workbook = new XSSFWorkbook(inputStream);

			Sheet firstSheet = workbook.getSheetAt(1);
			Iterator<Row> rowIterator = firstSheet.iterator();

			rowIterator.next(); // skip the header row
			List<EventSummaryDetails> listEventDetails = new ArrayList<EventSummaryDetails>();

			while (rowIterator.hasNext()) {
				Row nextRow = rowIterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				EventSummaryDetails eventDetailsObj = new EventSummaryDetails();

				while (cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();
					DataFormatter formatter = new DataFormatter();
					int columnIndex = nextCell.getColumnIndex();
					switch (columnIndex) {
					case 0:
						eventDetailsObj.setConuncilName(
								formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));
						break;
					case 1:
						eventDetailsObj.setEventName(
								formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));
					case 2:
						eventDetailsObj.setEventDescription(
								formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));
					case 3:
						eventDetailsObj.setEventDate(
								formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));
					case 4:
						eventDetailsObj.setEmployeeId(
								formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));
					case 5:
						eventDetailsObj.setEmployeeName(
								formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));
					case 6:
						eventDetailsObj.setVoluntersHours(
								formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));
					case 7:
						eventDetailsObj.setTotalTravelHour(
								formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));
					case 8:
						eventDetailsObj.setLivesImpacted(
								formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));
					case 9:
						eventDetailsObj.setBusineesUnit(
								formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));
					case 10:
						eventDetailsObj.setStatus(
								formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));
					case 11:
						eventDetailsObj.setIiepCategory(
								formatter.formatCellValue(firstSheet.getRow(nextRow.getRowNum()).getCell(columnIndex)));
					}
				}

				listEventDetails.add(eventDetailsObj);
			}

			batchService.InsertIntoDataBaseEventSummary(listEventDetails);
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


