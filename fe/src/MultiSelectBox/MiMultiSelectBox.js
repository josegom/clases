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
                   const alumnos = res.data._embedded.alumnos;                                      
                   const options = alumnos.map(x => this.createOptions(x)
                   );
                   console.log("options",options);
                   const pp = [
                    { desc: "Item 1", value: "1" },
                    { desc: "Item 2", value: "2" },
                    { desc: "Item 3", value: "3" }
                  ];
                   console.log("Esto es", pp);
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

