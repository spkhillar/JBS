package com.service.test;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;

public class SimpleTest {

  @Test
  public void test() {

    Date date1 = DateUtils.addHours(new Date(), -24);
    Date startDate = DateUtils.truncate(date1, Calendar.HOUR_OF_DAY);
    startDate = DateUtils.truncate(startDate, Calendar.MINUTE);
    startDate = DateUtils.truncate(startDate, Calendar.SECOND);
    Date endDate = DateUtils.addHours(startDate, 23);
    endDate = DateUtils.addMinutes(endDate, 59);
    endDate = DateUtils.addSeconds(endDate, 59);
    System.err.println("..a..." + startDate + "...to..." + endDate);

  }
}
