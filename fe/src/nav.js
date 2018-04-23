

import React from "react";
import { Nav, NavItem, NavLink } from 'reactstrap';




export default class Navbar extends React.Component{
  render () {
    return (
      <Nav>
        <NavItem>
            <NavLink href="/pagina">Home</NavLink>
          </NavItem>
          <NavItem>
            <NavLink href="/otraPagina">otraPagina</NavLink>
          </NavItem>
      </Nav>
    );
  }
}

