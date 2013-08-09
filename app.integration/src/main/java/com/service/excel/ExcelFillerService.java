/*
 * Copyright (C) 2013 , Inc. All rights reserved 
 */
package com.service.excel;

import java.util.List;

import com.service.util.ExcelRendererModel;

/**
 * The Interface ExcelFillerService.
 *
 * @author  
 */
public interface ExcelFillerService {
   
   /**
    * Fill report.
    *
    * @param excelRendererModel the excel renderer model
    * @param targetValues the target values
    */
   void fillReport(ExcelRendererModel excelRendererModel,List<List<Object>> targetValues );
  
  
}
