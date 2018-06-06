package org.myazure.schedule;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ScheduleMananger {
	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory
			.getLogger(ScheduleMananger.class);

	public ScheduleMananger() {
	}

	@Scheduled(cron = "0/1 * *  * * ? ")
	protected void secScanner() {
	}

	@Scheduled(cron = "0/30 * *  * * ? ")
	protected void thirtySecScanner() {
	}

	@Scheduled(cron = "0 0/1 *  * * ? ")
	protected void minScanner() {
	}

	@Scheduled(cron = "0 0/10 *  * * ? ")
	protected void tenMinScanner() {
	}

	@Scheduled(cron = "0 0/30 *  * * ? ")
	protected void halfHourScanner() {
	}

	@Scheduled(cron = "0 0 0/1  * * ? ")
	protected void hourScanner() {
	}

	@Scheduled(cron = "0 0 0 0/1 * ? ")
	protected void daylyScanner() {
	}

}
