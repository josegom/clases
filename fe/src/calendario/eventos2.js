import * as React from 'react';
import axios from "axios";


export default class Eventos2 extends React.Component {





  public getEventos() {
       return (
       axios.get('http://localhost:8080/api/event')
            .then(res => { eventos = res.data});
            );

    }


}

