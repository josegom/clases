import React from "react";
import ReactDOM from "react-dom";
import Alumnos from "./alumnos/alumnos";
import OtraPagina from "./otraPagina";
import App from "./app";

import { Router, Route, hashHistory,Redirec,Switch } from "react-router";
import { BrowserRouter,Link } from "react-router-dom";


const router = (
  <BrowserRouter>
  <div>
  <nav>
  <ul>
    <li><Link to='/'>Home</Link></li>
    <li><Link to='/alumnosList'>Listado alumnos</Link></li>
    <li><Link to='/otraPagina'>Schedule</Link></li>
  </ul>
</nav>
 
  <main>
 <Switch>      
      <Route path='/alumnosList' component={Alumnos} />
      <Route path='/otraPagina' component={OtraPagina} />
      </Switch>
      </main>
      </div>
      </BrowserRouter>
  
);
ReactDOM.render(
  router,
  document.getElementById("app")
);



