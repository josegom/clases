package com.josegom.clases.model;

import java.util.Date;


public class Evento {

    private String title ="";
    private Date start;
    private Date end;


    public Evento(String title, Date start, Date end) {

        this.title = title;
        this.start = start;
        this.end = end;
    }



    public String getTitle() {
        return title;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
