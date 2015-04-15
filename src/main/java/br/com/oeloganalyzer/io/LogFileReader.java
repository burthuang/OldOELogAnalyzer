package br.com.oeloganalyzer.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.com.oeloganalyzer.model.LogLine;

public class LogFileReader {

	public List<LogLine> readLogFile(String fileName) throws IOException {

		List<LogLine> list = new ArrayList<LogLine>();

		InputStream is = new FileInputStream(fileName);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String line = br.readLine();

		while (line != null) {
			// System.out.println(line);

			if (line == null || line.isEmpty() || line.length() < 50) {
				line = br.readLine();
				continue;
			}

				LogLine logLine = new LogLine();
				logLine.setDateTime(line.substring(0, 30));

				String pid = line.substring(33, 42);
				if (!pid.isEmpty()) { 
					logLine.setPid(Integer.parseInt(pid.trim()));
				 }
				
				String thread = line.substring(46, 50);
				if (!thread.isEmpty()) { 
					logLine.setThreadNumber(Integer.parseInt(thread.trim()));
				 }

				
				
				list.add(logLine);
				
			line = br.readLine();
		}

		br.close();

		return list;

	}

}
