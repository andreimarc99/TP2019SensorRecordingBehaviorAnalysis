package ro.tuc.tp.assig5.task;

import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import ro.tuc.tp.assig5.MonitoredData;

public class EntireActivityDurationCalculator {

	public static Map<String, List<MonitoredData>> getActivities() {
		return MonitoredDataRetriever.getMonitoredData().stream().collect(Collectors.groupingBy(d -> d.getActivity()));
	}

	@SuppressWarnings("deprecation")
	public static HashMap<String, Time> calculate() {
		HashMap<String, Time> activities = new HashMap<String, Time>();

		for (Entry<String, List<MonitoredData>> list : getActivities().entrySet()) {
			Time interval = new Time(0);
			long overallDuration = 0;
			for (MonitoredData data : list.getValue()) {
				long duration = data.getEndTime().getTime() - data.getStartTime().getTime();
				overallDuration += duration;
			}

			interval.setHours((int) (TimeUnit.MILLISECONDS.toSeconds(overallDuration) / 3600));
			interval.setMinutes(
					(int) ((TimeUnit.MILLISECONDS.toSeconds(overallDuration) / 60 - interval.getHours() * 60)));
			interval.setSeconds((int) (TimeUnit.MILLISECONDS.toSeconds(overallDuration) - interval.getHours() * 3600
					- interval.getMinutes() * 60));
			activities.put(list.getKey(), interval);
		}
		return activities;
	}
}
