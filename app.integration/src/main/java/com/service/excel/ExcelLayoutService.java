/*
 * Copyright (C) 2013 , Inc. All rights reserved 
 */
package com.service.excel;

import com.service.util.ExcelRendererModel;

/**
 * The Interface ExcelLayoutService.
 *
 * @author  
 */
public interface ExcelLayoutService {

  /**
   * Builds the report.
   *
   * @param excelRendererModel the excel renderer model
   */
  void buildReport(ExcelRendererModel excelRendererModel);
  
}
