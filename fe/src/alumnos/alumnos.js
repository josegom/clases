import * as React from 'react';
import axios from "axios";


export default class Alumnos extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      alumnos: [],
      isLoading: true
    };
    }



  componentDidMount() {
      this.setState({isLoading: true});
       axios.get('http://localhost:8090/api/alumnos')
            .then(res => {
              const alumnos = res.data._embedded.alumnos;
              this.setState({ alumnos: alumnos,isLoading: false });
            });
    }

        render() {
      const {alumnos, isLoading} = this.state;

      if (isLoading) {
        return <p>Loading...</p>;
      }

        return (

         <ul>
                  <h2>Alumnos List</h2>
                { alumnos.map(alumno => <li>{alumno.nombre}</li>) }
             </ul>
        );
        }

}

