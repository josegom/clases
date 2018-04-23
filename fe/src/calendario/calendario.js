import React, { Component } from "react";
import { render } from "react-dom";
import eventos from "./eventos";
import BigCalendar from "react-big-calendar";
import moment from "moment";
import "react-big-calendar/lib/css/react-big-calendar.css";

moment.locale("en");
BigCalendar.momentLocalizer(moment);

  const allViews = Object.keys(BigCalendar.Views).map(k => BigCalendar.Views[k]);

export default class Calendario extends Component {
  state = {
    view: "month",
    date: new Date(2015, 3, 12),
   // width: 500
  };

  componentDidMount() {
    window.addEventListener("resize", () => {
      /*this.setState({
        width: window.innerWidth,
        height: window.innerHeight
      });*/
    });
  }

  render() {
    return (
      <div style={{ height: 700 }}>
        <button onClick={() => this.setState({ view: "day" })}>Day</button>
        <button onClick={() => this.setState({ view: "month" })}>Month</button>
        <BigCalendar
          style={{ height: 500, width: this.state.width }}
          toolbar={false}
          events={eventos}
          step={60}
          timeslots={8}
          views={allViews}
          view={this.state.view}
          onView={() => {}}
          date={this.state.date}
          onNavigate={date => this.setState({ date })}
        />
      </div>
    );
  }
}