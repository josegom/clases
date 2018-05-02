import React from "react";
import ReactDOM from "react-dom";
import Alumnos from "./alumnos/alumnos";
import Clase from "./clases/clase";

import Calendario from "./calendario/calendario"

import { Router, Route, hashHistory,Redirec,Switch } from "react-router";
import { BrowserRouter,Link } from "react-router-dom";

import axios from "axios";

import style from './style.css'

axios.defaults.baseURL = 'http://localhost:8081';

const router = (
  <BrowserRouter>
  <div>
  <nav>
  <ul class="menu" id="menu"> 
    <li class="menu"><Link to='/'>Home</Link></li>
    <li class="menu"><Link to='/alumnosList'>Listado alumnos</Link></li>
    <li class="menu"><Link to='/altaClases'>Alta de Clases</Link></li>
    <li class="menu"><Link to='/Calendario'>Calendario</Link></li>
  </ul>
</nav>
 
  <main>
 <Switch>      
      <Route path='/alumnosList' component={Alumnos} />
      <Route path='/altaClases'  component={Clase} />
      <Route path='/Calendario'  component={Calendario} />


      </Switch>
      </main>
      </div>
      </BrowserRouter>
  
);


ReactDOM.render(
  router,
  document.getElementById("app")
);




