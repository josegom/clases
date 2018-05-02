package com.josegom.logic;

import com.josegom.clases.logic.ClasesLogic;
import com.josegom.clases.logic.LeccionLogic;
import junit.framework.TestCase;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.stream.Collectors;

public class LeccionLogicTest extends TestCase {
    

  public void testGenerateFecha()  {
      LeccionLogic leccionLogic = new LeccionLogic();
      LocalDate dia = LocalDate.of(2017,12,1);
      LocalTime hora = LocalTime.of(12,00);
      LocalDate ld = leccionLogic.generateFecha(dia, hora);
      assertEquals("1/12/2017 12:00",ld.format(DateTimeFormatter.ofPattern("dd/MM/yy HH:mm")));

  }



    }