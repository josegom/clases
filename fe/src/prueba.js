import React, { Component } from 'react';

import 'whatwg-fetch';

import MultipleSelectBox from 'react-multiple-select-box';

import { career, city, region } from './configs';
import axios from "axios";


export default class MultiSelect extends React.Component {
	constructor(props, context) {
        super(props, context);
        this.state = {
            options: career,
			value: [],
			isLoading: true

        };
	}
	


	 createOptions(x){
		return( {
			"id": x._links.alumno.href,
			"text": x.nombre
		});
	}

	componentDidMount() {

		 this.setState({isLoading: true});
			   axios.get('http://localhost:8081/api/alumnos')
					.then(res => {
					const alumnos = res.data._embedded.alumnos;
					console.log(alumnos);
					const options = alumnos.map(x => this.createOptions(x)
					);
					console.log("options",options);
					this.setState({ options: options,isLoading: false });
					});
	  }


    render() {
		console.log("STATE", this.state.options);
		console.log("Career", career);

		if (this.state.isLoading) {
			return <p>Loading...</p>;
		}else {
        return (
            <div className="container">
                <MultipleSelectBox
				    label="Selecciona alumnos"
                    options={this.state.options}
                    value={this.state.value}
                    nameText="career"
                />
            </div>
		)
	}
}
}

