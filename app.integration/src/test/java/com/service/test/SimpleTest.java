package com.service.test;

import org.junit.Test;

import com.jpa.entities.enums.PaymentMode;

public class SimpleTest {

  @Test
  public void test() {

    System.err.println("..." + PaymentMode.valueOf("CHEQUE"));
  }
}
