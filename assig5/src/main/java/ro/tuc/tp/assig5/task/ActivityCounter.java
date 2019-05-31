package ro.tuc.tp.assig5.task;
import java.util.Map;
import java.util.stream.Collectors;

public class ActivityCounter {
	
	public static Map<String, Long> count() {
		return MonitoredDataRetriever.getMonitoredData()
				.stream().collect(Collectors.groupingBy(data -> data.getActivity(), Collectors.counting()));
	}
}
