import * as React from 'react';
import axios from "axios";
import MultiSelectBox from '../MultiSelectBox/MultiSelectBox';


export default class Clase extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      id: "",
      dia : "",
      descripcion: "",
      materia: "",
      hora_inicio: "",
      hora_fin: "",
      fecha_inicio: "",
      fecha_fin: "",
      options: [],
			value: [],
			isLoading: true
      };

    this.handleInputChange = this.handleInputChange.bind(this);
     this.handleSubmit = this.handleSubmit.bind(this);
    }


    createOptions(x){
      return( {
        "value": x._links.alumno.href,
        "desc": x.nombre
      });
      }

  
    componentDidMount() {

      this.setState({isLoading: true});
            axios.get('http://localhost:8081/api/alumnos')
                 .then(res => {
                 const alumnos = res.data._embedded.alumnos;                                      
                 const options = alumnos.map(x => this.createOptions(x));
                 this.setState({ options: options,isLoading: false });
                 });
   }




  handleInputChange(event) {
    const target = event.target;
    const value = target.type === "checkbox" ? target.checked : target.value;
    const name = target.name;
    this.setState({
      [name]: value
    });
  }


  handleSubmit(event) { 
    alert(this.state.dia);

    event.preventDefault();
        axios.post('/api/clase', {
          dia : this.state.dia,
          descripcion: this.state.descripcion,
          materia: this.state.materia,
          hora_inicio: this.state.hora_inicio,
          hora_fin: this.state.hora_fin,
          fecha_inicio: this.state.fecha_inicio,
          fecha_fin: this.state.fecha_fin
        }
          )
          .then(res => {
            console.log(res);
            console.log(res.data);
          })
  }


render() {
  if (this.state.isLoading) {
    return <p>Loading...</p>;
}else{
    return (
      <form onSubmit={this.handleSubmit} class="form1">
        <label for="materia" class="materia">Materia:</label>
           <select value={this.state.materia} name="materia" onChange={this.handleInputChange}>
              <option value="Salsa Avanzada">Salsa Avanzada</option>
              <option value="Salsa Intermedia">Salsa Intermedia</option>
           </select>
        
         <label for="descripcion" class="descripcion"> Descripci&oacute;n: </label>
         <input type="text" name="descripcion" value={this.state.descripcion} onChange={this.handleInputChange} />
                
         <label for="hora_inicio" class="hora_inicio">Hora Inicio:</label>
         <input type="text" name="hora_inicio" value={this.state.hora_inicio} onChange={this.handleInputChange} />
          
           <label for="hora_fin" class="hora_fin">Hora Fin:</label>
           <input type="text" name="hora_fin" value={this.state.hora_fin} onChange={this.handleInputChange} />
          
           <label for="fecha_inicio" class="fecha_inicio">Fecha Inicio:</label>
           <input type="text" name="fecha_inicio" value={this.state.fecha_inicio} onChange={this.handleInputChange} />

           <label for="fecha_fin" class="fecha_fin">Fecha Fin:</label>
           <input type="text" name="fecha_fin" value={this.state.fecha_fin} onChange={this.handleInputChange} />

          <label for="dia" class="dia">D&iacute;a de la Semana</label>
              <select value={this.state.dia} name="dia" onChange={this.handleInputChange}>
                <option value="Monday">Lunes</option>
                <option value="Tuesday">Martes</option>
                <option value="Wednesday">Mi&eacute;rcoles</option>
                <option value="Thursday">Jueves</option>
                <option value="Friday">Viernes</option>
                <option value="Saturday">S&aacute;bado</option>
                <option value="Sunday">Domingo</option>
              </select>
              <label for="alumnos" class="alumno">Selecciona alumnos</label>
                        <MultiSelectBox                      
                      options= {this.state.options}
                      labelKey="desc"
                      valueKey="value"
                      onChange=""            
                    />            
              
        <input type="submit" value="Submit" />
      </form>
    );
  }
  }

}


