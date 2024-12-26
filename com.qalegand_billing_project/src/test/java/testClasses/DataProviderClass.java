package testClasses;

import org.testng.annotations.Test;

import utility.ExcelReadClass;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
  

  @DataProvider(name = "UnsuccessfulLogin")
  public Object[][] dp() throws IOException {
    return new Object[][] {
      new Object[] { ExcelReadClass.getStringdata(1, 0), ExcelReadClass.getIntegerdata(1, 1) },
      new Object[] { ExcelReadClass.getStringdata(2, 0), ExcelReadClass.getStringdata(2, 1) },
      new Object[] { ExcelReadClass.getStringdata(3, 0), ExcelReadClass.getIntegerdata(3, 1) },
    };
  }
}
