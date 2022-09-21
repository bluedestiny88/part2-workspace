package com.javatunes.personnel;

import static org.junit.Assert.*;

import java.sql.Date;
import org.junit.Before;
import org.junit.Test;

public class SalariedEmployeeTest {

  private SalariedEmployee emp;

  @Before
  public void setUp() {
    emp = new SalariedEmployee("Bill Gates", new Date(120, 2, 15), 110000.00);
  }

  @Test
  public void testPay() {
    assertEquals(110000, emp.pay(), 0.001);
  }

  @Test
  public void testPayTaxes() {
    double amount = 110000 * SalariedEmployee.SALARIED_TAX_RATE;
    assertEquals(amount, emp.payTaxes(), 0.001);
  }
}