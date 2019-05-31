package ro.tuc.tp.assig5;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import ro.tuc.tp.assig5.task.ActivitiesPerDayCounter;
import ro.tuc.tp.assig5.task.ActivityCounter;
import ro.tuc.tp.assig5.task.DaysCounter;
import ro.tuc.tp.assig5.task.DurationCalculator;
import ro.tuc.tp.assig5.task.EntireActivityDurationCalculator;
import ro.tuc.tp.assig5.task.MonitoredDataRetriever;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("IN ORDER TO VIEW THE RESULTS DEPENDING ON THE TASKS, YOU NEED TO TYPE:\n\n"
				+ "\t1 - TASK 1\n\t2 - TASK 2\n\t3 - TASK 3\n\t4 - TASK 4\n\t5 - TASK 5\n\t6 - TASK 6\n");
		for (;;) {
			int task = scanner.nextInt();
			switch (task) {
				case 1:
					MonitoredDataRetriever.getMonitoredData().forEach(System.out::println);
					break;
				case 2:
					System.out.println(DaysCounter.countDays());
					break;
				case 3: 
					for (Entry<String, Long> e : ActivityCounter.count().entrySet()) {
						System.out.println(e.getKey() + " - " + e.getValue());
					} 
					break;
				case 4: 
					for (Entry<Date, Map<String, Long>> e : ActivitiesPerDayCounter.count().entrySet()) {
						try {
							DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
							System.out.println("-- " + f.format(e.getKey()) + " --" );
							for (Entry<String, Long> e1 : e.getValue().entrySet()) {
								System.out.println(e1.getKey() + " - " + e1.getValue());
							}
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}  
					break;
				case 5: 
					for (Entry<Integer, Date> e : DurationCalculator.calculate().entrySet()) {
						DateFormat f = new SimpleDateFormat("HH:mm:ss");
						System.out.println(e.getKey() + " - " + f.format(e.getValue()));
					}
					break;
				case 6: 
					for (Entry<String, Time> e : EntireActivityDurationCalculator.calculate().entrySet()) {
						System.out.println(e.getKey() + " - " + e.getValue());
					}
					break;
				case 0:
					System.out.println("Closing app...");
					scanner.close();
					System.exit(0);
				default: 
					System.out.println("Key not binded. Try again");
					break;
			}
			
		}
		
	}
}