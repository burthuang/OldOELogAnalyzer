package br.com.oeloganalyzer.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import br.com.oeloganalyzer.model.LogLineFactory;
import br.com.oeloganalyzer.model.LogLine;

public class LogFileReader {

	public List<LogLine> readLogFile(String fileName) throws IOException {

		List<LogLine> list = new ArrayList<LogLine>();

		InputStream is = new FileInputStream(fileName);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String line = br.readLine();

		while (line != null) {

			if (line == null || line.isEmpty() || line.length() < 50) {
				line = br.readLine();
				continue;
			}
			
			LogLineFactory llf = new LogLineFactory();
			
			LogLine logLine = llf.getLogLine(line);
			
			//System.out.println(logLine);
			
			if (logLine != null)
				list.add(logLine);
				
			line = br.readLine();
		}

		br.close();

		return list;

	}

}
