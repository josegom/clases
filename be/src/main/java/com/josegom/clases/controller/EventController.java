package com.josegom.clases.controller;

import com.josegom.clases.model.Evento;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EventController  {


    @GetMapping("/api/event")
    public Collection<Evento> getEventos(HttpServletRequest request) {
        Collection<Evento> col = new ArrayList<>();
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Evento ev1 = new Evento("ev1",df.parse("23/04/2015 11:00"),df.parse("23/04/2015 12:00"));
            col.add(ev1);
            Evento ev2 = new Evento("ev2",df.parse("23/04/2015 12:00"),df.parse("23/04/2015 13:00"));
            col.add(ev2);
            Evento ev3 = new Evento("Mi evento rest",df.parse("04/04/2015 12:00"),df.parse("04/04/2015 13:00"));
            col.add(ev3);
            Evento ev4 = new Evento("Mi evento rest 2",df.parse("04/04/2015 14:00"),df.parse("04/04/2015 15:00"));
            col.add(ev4);
            Evento ev5 = new Evento("Mi evento rest 3",df.parse("04/04/2015 15:00"),df.parse("04/04/2015 16:00"));
            col.add(ev5);
            Evento ev6 = new Evento("Mi evento rest 4",df.parse("04/04/2015 16:00"),df.parse("04/04/2015 17:00"));
            col.add(ev6);
            Evento ev7 = new Evento("Mi evento rest 5",df.parse("04/04/2015 18:00"),df.parse("04/04/2015 19:00"));
            col.add(ev7);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return col;
    }


}

