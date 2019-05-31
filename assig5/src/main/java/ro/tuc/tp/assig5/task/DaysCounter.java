package ro.tuc.tp.assig5.task;

import java.util.stream.Collectors;

public class DaysCounter {

	@SuppressWarnings("deprecation")
	public static long countDays() {
		return MonitoredDataRetriever.getMonitoredData()
				.stream().collect(Collectors.groupingBy(data -> data.getStartTime().getDate(), Collectors.counting())).size();
	}
}
