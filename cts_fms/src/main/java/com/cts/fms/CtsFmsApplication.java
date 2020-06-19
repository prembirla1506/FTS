package com.cts.fms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.engine.jdbc.batch.spi.Batch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cts.fms.batch.dto.EventPocDetails;
import com.cts.fms.batch.model.EventDetails;
import com.cts.fms.batch.model.PocDetails;
import com.cts.fms.batch.service.BatchService;

@SpringBootApplication
@EnableScheduling
public class CtsFmsApplication {

	@Autowired
	private static BatchService batchService;
	public static void main(String[] args) {
		SpringApplication.run(CtsFmsApplication.class, args);

	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/eventData").allowedOrigins("http://localhost:8088");
				registry.addMapping("/eventDashboard").allowedOrigins("http://localhost:8088");
				registry.addMapping("/eventSummary").allowedOrigins("http://localhost:8088");
				registry.addMapping("/submitFeedback").allowedOrigins("http://localhost:8088");
				
			}
		};
	}

}
