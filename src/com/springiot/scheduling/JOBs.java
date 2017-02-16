package com.springiot.scheduling;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TimeZone;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.springiot.constant.Constant;
import com.springiot.response.TokenSPResponse;

public class JOBs extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext jobexecution) throws JobExecutionException {

		// System.out.println("Execute Jobs");
		// TokenExpire();
	}

	@SuppressWarnings("unused")
	private void TokenExpire() {
		Set<String> tokenKey = Constant.map.keySet();

		for (String string : tokenKey) {
			try {
				TokenSPResponse response = (TokenSPResponse) Constant.map.get(string);

				if (ConvertTime(response.getUtc_time().toString()) >= 5000) {
					Constant.map.remove(string);
					System.out.println("Remove Token");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	private long ConvertTime(String TokenTime) throws Exception {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date tokenGenerationDateTime = dateFormat.parse(TokenTime);

		DateFormat gmtFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		gmtFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

		Date currentDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(gmtFormat.format(new Date()));

		return differenceMin(currentDateTime, tokenGenerationDateTime);
	}

	private long differenceMin(Date currentDateTime, Date tokenGenerationDateTime) {
		long diff = currentDateTime.getTime() - tokenGenerationDateTime.getTime();

		long diffMinutes = diff / (60 * 1000);

		return diffMinutes;
	}

}
