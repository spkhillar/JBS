package com.service.util;

import java.math.BigInteger;
import java.security.SecureRandom;

public final class RandomPasswordGenerator {

  private static SecureRandom random = new SecureRandom();

  private RandomPasswordGenerator() {

  }

  public static String rndPassword() {
    return new BigInteger(32, random).toString(32);
  }
}
