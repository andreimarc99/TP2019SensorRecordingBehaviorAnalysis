package ro.tuc.tp.assig5.task;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ro.tuc.tp.assig5.MonitoredData;

public class MonitoredDataRetriever {

	public static ArrayList<MonitoredData> getMonitoredData() {
		ArrayList<MonitoredData> data = new ArrayList<MonitoredData>();
		File f = new File("Activities.txt");
		try {
			Stream<String> lineStr = Files.lines(f.toPath());
			return (ArrayList<MonitoredData>) lineStr.map(line -> {
				String[] lineData = new String[3];
				lineData = line.split("\t\t");
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				try {
					return new MonitoredData(format.parse(lineData[0]), format.parse(lineData[1]), lineData[2]);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return null;
			}).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
}
