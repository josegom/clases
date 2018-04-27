package com.josegom.clases.logic;


import java.time.DayOfWeek;
import  java.time.LocalDate;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jmgomez on 27/04/18.
 */
public class ClasesLogic {
    public Stream<LocalDate> getDays(LocalDate fInicio, LocalDate fFin, DayOfWeek dia) {
        return fInicio.datesUntil(fFin).filter(x -> x.getDayOfWeek().equals(dia));

    }
}
