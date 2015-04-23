package br.com.oeloganalyzer.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import br.com.oeloganalyzer.io.LogFileReader;
import br.com.oeloganalyzer.model.LogLine;

public class LogController {

	public static void main(String[] args) throws IOException {
		
		LogFileReader lfr = new LogFileReader();
		List<LogLine> loglines = lfr.readLogFile(args[0]);
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		for (LogLine logLine : loglines) {
			System.out.println(sdf.format(logLine.getDateTime().getTime()) + " " + 
							 			  logLine.getPid() + " " + 
							 			  logLine.getThreadNumber() + " " +
							 			  logLine.getMessageType() + " " +
							 			  logLine.getProcessType() + " " +
							 			  logLine.getUserNumber() + " " +
							 			  logLine.getMessageNumber() + " " +
							 			  logLine.getMessage()
 							 			  ) ;
			
		}
		
	}
	
}

