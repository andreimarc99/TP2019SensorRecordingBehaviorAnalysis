package ro.tuc.tp.assig5.task;

import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

public class ActivitiesPerDayCounter {

	@SuppressWarnings("deprecation")
	public static Map<Date, Map<String, Long>> count() {
		return MonitoredDataRetriever.getMonitoredData().stream().collect(Collectors.groupingBy(data -> 
		new Date(data.getStartTime().getYear(), data.getStartTime().getMonth(), data.getStartTime().getDate()),
                Collectors.groupingBy(data -> data.getActivity(), 
                Collectors.counting())));
	}
}
