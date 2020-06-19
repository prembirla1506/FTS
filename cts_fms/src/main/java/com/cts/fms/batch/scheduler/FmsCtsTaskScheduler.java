package com.cts.fms.batch.scheduler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cts.fms.batch.dto.EventPocDetails;
import com.cts.fms.batch.service.BatchService;
import com.cts.fms.batch.service.EventDetailsBatchService;
import com.cts.fms.batch.service.EventNotAttendedService;
import com.cts.fms.batch.service.EventSummaryBatchService;
import com.cts.fms.batch.service.EventUnregisterService;
import com.cts.fms.utility.FmsUtility;

@Component
public class FmsCtsTaskScheduler {
	private static final Logger LOGGER = LoggerFactory.getLogger(FmsCtsTaskScheduler.class);
	@Autowired
	private BatchService batchService;
	
	@Autowired
	private EventDetailsBatchService eventDetailsBatchService;
	
	@Autowired
	private EventSummaryBatchService eventSummaryBatchService;
	
	@Autowired
	private EventNotAttendedService eventNotAttendedService;
	
	@Autowired
	private EventUnregisterService eventUnregisterService;

	@Scheduled(fixedRate = 100000)
	public String run() {
		String excelFilePath = "D:\\work_prem\\cognizant\\input_data\\FTS.xlsx";
		String movedFileName = "FTS" + FmsUtility.getDateInDDMMYYYY(new Date()) + ".xlsx";
		String moveFilePath = "D:\\work_prem\\cognizant\\input_data\\processed\\" + movedFileName;
		try {
			
		eventDetailsBatchService.readExcelFileforEvnetDetails(excelFilePath);
		
		eventSummaryBatchService.readExcelFileforEvnetDetails(excelFilePath);
		eventUnregisterService.readExcelFileforEvnetDetails(excelFilePath);
		eventNotAttendedService.readExcelFileforEvnetDetails(excelFilePath);
		
		
		this.moveFileTOProcessed(excelFilePath, moveFilePath);
		} catch (Exception e) {
			LOGGER.info("EXception #################### ");
		}

		return moveFilePath;

	}

	private void moveFileTOProcessed(String sourceFile, String destinationFile) {
		Path temp = null;
		try {
			temp = Files.move(Paths.get(sourceFile), Paths.get(destinationFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOGGER.info("Exception #################### ");
		}

		if (temp != null) {
			System.out.println("File renamed and moved successfully");
		} else {
			System.out.println("Failed to move the file");
		}
	}

}
