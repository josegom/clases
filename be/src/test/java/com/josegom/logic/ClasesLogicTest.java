package com.josegom.logic;

import com.josegom.clases.logic.ClasesLogic;
import junit.framework.TestCase;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.stream.Collectors;

public class ClasesLogicTest extends TestCase {
    

  public void testFilterDays()  {
      ClasesLogic clasesLogic = new ClasesLogic();

      DayOfWeek dia = DayOfWeek.MONDAY;
      Collection<LocalDate> lunes = clasesLogic.getDays(LocalDate.of(2018, Month.MARCH,19),
          LocalDate.of(2018, Month.APRIL,25), dia).collect(Collectors.toList());
      assertEquals(6, lunes.size());
      assert(true);
  }

    public void testFilterDaysFirstIsMonday()  {

        ClasesLogic clasesLogic = new ClasesLogic();

        DayOfWeek dia = DayOfWeek.MONDAY;
        Collection<LocalDate> lunes = clasesLogic.getDays(LocalDate.of(2018, Month.MAY,7),
            LocalDate.of(2018, Month.JUNE,13), dia).collect(Collectors.toList());
        assertEquals(6, lunes.size());
        assert(true);
    }

    public void testFilterDaysFirstNotIsMonday()  {

        ClasesLogic clasesLogic = new ClasesLogic();

        DayOfWeek dia = DayOfWeek.MONDAY;
        Collection<LocalDate> lunes = clasesLogic.getDays(LocalDate.of(2018, Month.MAY,8),
            LocalDate.of(2018, Month.JUNE,13), dia).collect(Collectors.toList());
        assertEquals(5, lunes.size());
        assert(true);
    }


    public void testFilterDaysFinalIsMonday()  {

        ClasesLogic clasesLogic = new ClasesLogic();

        DayOfWeek dia = DayOfWeek.MONDAY;
        Collection<LocalDate> lunes = clasesLogic.getDays(LocalDate.of(2018, Month.MAY,8),
            LocalDate.of(2018, Month.JUNE,25), dia).collect(Collectors.toList());
        assertEquals(7, lunes.size());
        assert(true);
    }

    public void testFilterDaysFinalIsNotMonday()  {

        ClasesLogic clasesLogic = new ClasesLogic();

        DayOfWeek dia = DayOfWeek.MONDAY;
        Collection<LocalDate> lunes = clasesLogic.getDays(LocalDate.of(2018, Month.MAY,9),
            LocalDate.of(2018, Month.JUNE,24), dia).collect(Collectors.toList());
        assertEquals(6, lunes.size());
        assert(true);
    }

    public void testFilterDaysBothMondays()  {

        ClasesLogic clasesLogic = new ClasesLogic();

        DayOfWeek dia = DayOfWeek.MONDAY;
        Collection<LocalDate> lunes = clasesLogic.getDays(LocalDate.of(2018, Month.MAY,7),
            LocalDate.of(2018, Month.JUNE,25), dia).collect(Collectors.toList());
        assertEquals(8, lunes.size());
        assert(true);
    }


    }