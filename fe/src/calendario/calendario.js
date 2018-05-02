import React, { Component } from "react";
import { render } from "react-dom";
import axios from "axios";
import BigCalendar from "react-big-calendar";
import moment from "moment";
import "react-big-calendar/lib/css/react-big-calendar.css";




moment.locale("es");
BigCalendar.momentLocalizer(moment);

  const allViews = Object.keys(BigCalendar.Views).map(k => BigCalendar.Views[k]);

export default class Calendario extends Component {
  state = {
    view: "week",
    date: new Date(2015, 3, 12),
   // width: 500
    event: [],
    isLoading: true
  };


  constructor(props) {
    super(props);
    this.state = {
      date: new Date(2015, 3, 12),
      view: "month",
      event: [],
      isLoading: true
    };
  }

  componentDidMount() {
    window.addEventListener("resize", () => {
      /*this.setState({
        width: window.innerWidth,
        height: window.innerHeight
      });*/
    });
     this.setState({isLoading: true});
           axios.get('http://localhost:8081/api/event')
                .then(res => {
                  this.setState({ event: res.data });
                });
             this.setState({isLoading: false});
  }



  render() {

 if (this.state.isLoading) {
        return (<p>Loading...</p>);
      }else{
        return (
          <div style={{ height: 700 }}>
            <BigCalendar
              selectable
              style={{ height: 500, width: this.state.width }}
              toolbar={true}
              events={this.state.event}
              step={60}
              timeslots={8}
              views={allViews}
              defaultView={this.state.view}
              onView={() => {}}
              scrollToTime={new Date(1970, 1, 1, 6)}
              defaultDate={this.state.date}
              onNavigate={date => this.setState({ date })}
            />
          </div>
        );
    }
  }
}

