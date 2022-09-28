/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel;

import java.sql.Date;
import java.util.Map;

public class EmployeeFactory {
  
  // prevent direct instantiation - this is an all-static factory class
  private EmployeeFactory() {
  }
  
  /**
   * TODO: given the input map, create and return the correct object (with its properties set).
   * If the input map's "type" value is not "HE" or "SE", throw IllegalArgumentException with a suitable message.
   */
  public static Employee createEmployee(Map<String,String> inputMap)
  throws IllegalArgumentException {
    // return value
    Employee emp = null;
    if (!inputMap.get("type").equals("SE") || !inputMap.get("type").equals("HE")) {
      throw new IllegalArgumentException("Employee must be hourly or salaried");
    } else {
      String nameOfEmployee = inputMap.get("name");
      Date empHireDate = Date.valueOf(inputMap.get("hireDate"));
    // TODO: 9/26/2022 If type is equal to "HE", then read (and parse) rate and hours from
    //  inputMap.
      }
    // TODO: 9/26/2022 If type is equal to "SE", then read (and parse) salary from inputMap.
    // TODO: 9/26/2022 Create an instance of HourlyEmployee or SalariedEmployee, with the
    //  values read from inputMap.
    return emp;
  }
}
