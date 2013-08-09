/*
 * Copyright (C) 2013 , Inc. All rights reserved
 */
package com.service.excel.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.util.Assert;

import com.service.excel.ExcelLayoutService;
import com.service.util.ExcelRendererModel;

/**
 * The Class AbstractExcelLayoutService.
 *
 * @author  
 */
public abstract class AbstractExcelLayoutService implements ExcelLayoutService {

  /**
   * Builds the report.
   *
   * @param excelRendererModel the excel renderer model
   * @see com.service.excel.ExcelLayoutService#buildReport(com.service.util.ExcelRendererModel)
   */
  @Override
  public void buildReport(final ExcelRendererModel excelRendererModel) {

    HSSFSheet worksheet = excelRendererModel.getWorksheet();
    List<String> columns = excelRendererModel.getColumns();
    Assert.isTrue(CollectionUtils.isNotEmpty(columns), "Columns cannot be empty.");
    // Set column widths
    for (int i = 0; i < columns.size(); i++) {
      worksheet.setColumnWidth(i, excelRendererModel.getColumnWidth());
    }

    buildTitle(excelRendererModel);
    buildHeaders(excelRendererModel);
  }

  /**
   * Builds the headers.
   *
   * @param excelRendererModel the excel renderer model
   */
  public abstract void buildHeaders(ExcelRendererModel excelRendererModel);


  /**
   * Builds the title.
   *
   * @param excelRendererModel the excel renderer model
   */
  public abstract void buildTitle(ExcelRendererModel excelRendererModel);

}
