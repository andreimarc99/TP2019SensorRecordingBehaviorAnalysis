package ro.tuc.tp.assig5.task;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DurationCalculator {

	@SuppressWarnings("deprecation")
	public static ArrayList<Date> calculate() {
		File f = new File("Activities.txt");
		try (Stream<String> lineStr = Files.lines(f.toPath())) {
			return (ArrayList<Date>) lineStr.map(line -> {
				String[] lineData = new String[3];
				lineData = line.split("\t\t");
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					Date startDate = format.parse(lineData[0]);
					Date endDate = format.parse(lineData[1]);
					return new Date(endDate.getYear() - startDate.getYear(),
							endDate.getMonth() - startDate.getMonth(),
							endDate.getDay() - startDate.getDay(),
							endDate.getHours() - startDate.getHours(),
							endDate.getMinutes() - startDate.getMinutes(),
							endDate.getSeconds() - startDate.getSeconds()
							);
					
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return null;
			}).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
