/*
 * Copyright (C) 2013 , Inc. All rights reserved
 */
package com.web.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

/**
 * The Class DomainObjectMapper.
 *
 * @author  
 */
public class DomainObjectMapper {

  /**
   * List entities.
   *
   * @param pages the pages
   * @return the list
   */
  public static List<Object> listEntities(final Page<?> pages) {
    List<Object> list = new ArrayList<Object>();
    for (Object baseEntity : pages) {
      list.add(baseEntity);
    }
    return list;
  }
}
