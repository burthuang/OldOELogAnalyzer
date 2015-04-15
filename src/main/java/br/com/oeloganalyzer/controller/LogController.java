package br.com.oeloganalyzer.controller;

import java.io.IOException;
import java.util.List;

import br.com.oeloganalyzer.model.LogLine;
import br.com.oeloganalyzer.io.LogFileReader;

public class LogController {

	public static void main(String[] args) throws IOException {
		LogFileReader lfr = new LogFileReader();
		List<LogLine> loglines = lfr.readLogFile(args[0]);
		
		System.out.println("BACK TO THE CONTROLLER");

		for (LogLine logLine : loglines) {
			System.out.println(logLine.getDateTime() + " " + logLine.getPid() + " " + logLine.getThreadNumber()) ;
			
		}
		
	}
	
}
