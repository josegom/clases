import React from "react";
import ReactDOM from "react-dom";
import Alumnos from "./alumnos/alumnos";

function formatName(user) {
  return user.firstName + ' ' + user.lastName;
}

const user = {
  firstName: 'Harper',
  lastName: 'Perez'
};

const element = (
  <h1>
    Hello 3, {formatName(user)}!
    <Alumnos />
  </h1>
);


ReactDOM.render(
  element,
  document.getElementById('app')
);