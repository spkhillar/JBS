package com.service.test;

import org.junit.Test;

import com.service.util.RandomPasswordGenerator;

public class RandomPasswordGeneratorTest {

  @Test
  public void test() {

    for (int i = 0; i < 5; i++) {
      String rnd = RandomPasswordGenerator.rndPassword();
      System.err.println("...RandomPasswordGeneratorTest..." + rnd);
    }

  }
}
