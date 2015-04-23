package br.com.oeloganalyzer.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LogLineFactory {

	public LogLineFactory() {
		
		
		
	}
	
	
	public LogLine getLogLine(String line) {
		
		Calendar dateTime;
		int pid;
		int threadNumber;
		int messageType;
		String processType;
		int userNumber;
	    String messageNumber;
	    String message;

	    //System.out.println("Em LogLineFactory, line = " + line + " dayMonth: " + line.substring(9, 11));
	    
		LogLine logLine = new LogLine();
		
		dateTime = Calendar.getInstance();
		String tmpDay = line.substring(9,11).trim();
		String tmpMonth = line.substring(6,8).trim();
		String tmpYear = line.substring(1,5).trim();
		dateTime.set(Calendar.DAY_OF_MONTH, Integer.parseInt(tmpDay));
		dateTime.set(Calendar.MONTH, Integer.parseInt(tmpMonth) - 1);
		dateTime.set(Calendar.YEAR, Integer.parseInt(tmpYear));
		logLine.setDateTime(dateTime);
		
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//System.out.println("data calculada: " + sdf.format(dateTime.getTime()));
		
		//System.out.println("Setado Dia: " + dateTime.get(Calendar.DAY_OF_MONTH));
		//System.out.println("Setado Mes: " + dateTime.get(Calendar.MONTH));
		//System.out.println("Setado Ano: " + dateTime.get(Calendar.YEAR));
		
		String tmpPid = line.substring(33, 42);
		if (!tmpPid.isEmpty()) { 
			logLine.setPid(Integer.parseInt(tmpPid.trim()));
		 }
		
		String thread = line.substring(46, 51);
		if (!thread.isEmpty()) { 
			logLine.setThreadNumber(Integer.parseInt(thread.trim()));
		 }
		
		String tmpMessageType = line.substring(52, 53);
		if (!tmpMessageType.isEmpty()) {
			logLine.setMessageType(tmpMessageType);
		}

		String tmpProcessType = line.substring(54, 61);
		if (!tmpProcessType.isEmpty()) {
			logLine.setProcessType(tmpProcessType);
		}

		String tmpUserNumber = line.substring(64, 65).trim();
		if (!tmpUserNumber.isEmpty()) {
			logLine.setUserNumber(Integer.parseInt(tmpUserNumber));
		}

		String tmpMessageNumber = line.substring(65, 71);
		if (!tmpMessageNumber.isEmpty()) {
			logLine.setMessageNumber(tmpMessageNumber);
		}

		String tmpMessage = line.substring(73, line.length() - 1);
		if (!tmpMessage.isEmpty()) {
			logLine.setMessage(tmpMessage);
		}
		
		return logLine;
		
	}
	
}
