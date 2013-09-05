package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.service.SmsService;

@Service("smsService")
public class SmsServiceImpl implements SmsService {

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public void sendSms(String number, String message) {
    String urlSend =
        "http://bulksms.mysmsmantra.com:8080/WebSMS/SMSAPI.jsp?username=jaganstu&password=1091976&sendername=jobs&mobileno=918860146478&message=Test again...";

    String report =
        "http://bulksms.mysmsmantra.com:8080/WebSMS/sentreport.jsp?username=jaganstu&password=1091976&fromdate=01-09-2013&todate=02-09-2013";

    String balanace =
        "http://bulksms.mysmsmantra.com:8080/WebSMS/balance.jsp?username=jaganstu&password=1091976&fromdate=15-08-2013&todate=01-09-2013";

    ResponseEntity<String> data = restTemplate.exchange(report, HttpMethod.GET, null, String.class);

    System.err.println("...data..." + data.getBody());
  }

}
