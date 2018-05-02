import React, { Component } from 'react';

import MultiSelectBox from './MultiSelectBox';
import axios from 'axios';

import Calendario from "../calendario/calendario"


export default class MiMultiSelectBox extends React.Component {

    constructor(props, context) {
        super(props, context);
        this.state = {
            options: [],
			value: [],
			isLoading: true

        };
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
                                                     
                   const options = res.data._embedded.alumnos.map(x => this.createOptions(x)
                   );                                
                   this.setState({ options: options,isLoading: false });
                   });
     }



    render() {
        if (this.state.isLoading) {
            return <p>Loading...</p>;
        }else{
        return (
            <MultiSelectBox
            addAllLabel="Nuevisimo"
            options= {this.state.options}
            labelKey="desc"
            valueKey="value"
            onChange=""            
          />          
        )
    }
	
    }
}

