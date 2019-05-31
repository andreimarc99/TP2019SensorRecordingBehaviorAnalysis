package ro.tuc.tp.assig5.task;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.stream.Stream;

public class DurationCalculator {
	private static int i = 0;

	@SuppressWarnings("deprecation")
	public static HashMap<Integer, Date> calculate() {
		HashMap<Integer, Date> result = new HashMap<Integer, Date>();
		File f = new File("Activities.txt");
		try (Stream<String> lineStr = Files.lines(f.toPath())) {
			lineStr.forEach(line -> {
				String[] lineData = new String[3];
				lineData = line.split("\t\t");
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					Date startDate = format.parse(lineData[0]);
					Date endDate = format.parse(lineData[1]);
					Date duration = new Date(endDate.getYear() - startDate.getYear(),
							endDate.getMonth() - startDate.getMonth(),
							endDate.getDay() - startDate.getDay(),
							endDate.getHours() - startDate.getHours(),
							endDate.getMinutes() - startDate.getMinutes(),
							endDate.getSeconds() - startDate.getSeconds()
							);
					result.put(++i, duration);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
