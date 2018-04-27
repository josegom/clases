package com.josegom.logic;

import com.josegom.clases.logic.ClasesLogic;
import junit.framework.TestCase;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.stream.Collectors;

public class ClasesLogicTest extends TestCase {
    

  public void testDoSomething()  {
      ClasesLogic clasesLogic = new ClasesLogic();
      LocalDate fInicio =  LocalDate.of(2018, Month.MARCH,19);
      LocalDate fFin =  LocalDate.of(2018, Month.APRIL,25);


      DayOfWeek dia = DayOfWeek.MONDAY;
      Collection<LocalDate> lunes = clasesLogic.getDays(fInicio, fFin, dia).collect(Collectors.toList());
      assertEquals(6, lunes.size());
      assert(true);
  }

  }