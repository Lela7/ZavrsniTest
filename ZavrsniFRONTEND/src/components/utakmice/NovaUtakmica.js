import React from 'react';
import { Row, Col, Form, Button } from "react-bootstrap";
import Axios from '../../apis/Axios';
import { withNavigation } from '../../routeconf';

class NovaUtakmica extends React.Component{

    constructor(props) {
        super(props);

        let utakmica = {
            reprezentacijaA: null,
            reprezentacijaB: null,
            brA: 0,
            brB: 0

        }

        this.state= { utakmica: utakmica, reprezentacije: [], isValid: false};
    }

    componentDidMount() {
        this.getReprezentacije();
    
    }

    async getReprezentacije() {
        try {
            let result = await Axios.get("/reprezentacije");
            let reprezentacije= result.data;
            this.setState({ reprezentacije: reprezentacije});
            console.log("test1");
        }
        catch (error) {
            console.log(error);
            alert("Neuspesan uvoz reprezentacija");
        }
    }

    isInputValid() {
        if(this.state.utakmica.reprezentacijaA==null || this.state.utakmica.reprezentacijaB==null) {
            this.setState({isValid:false})
            return
        }
    }

    async create(e) {
        e.preventDefault();
        
        try {

            let utakmica= this.state.utakmica;
            let utakmicaDTO= {
                reprezentacijaANaziv: utakmica.reprezentacijaA.skraceniNaziv,
                reprezentacijaBNaziv: utakmica.reprezentacijaB.skraceniNaziv,
                reprezentacijaAId: utakmica.reprezentacijaA.id,
                reprezentacijaBId: utakmica.reprezentacijaB.id,
                brA: utakmica.brA,
                brB: utakmica.brB
            }

            let response =  await Axios.post("/utakmice", utakmicaDTO);
            this.props.navigate("/utakmice");
        } catch (error) {
            alert("Neuspesno dodavanje utakmice!")
        }
    }

    reprezentacijaASelectionChanged(e) {

        let reprezentacijaAId=e.target.value;
        let reprezentacijaA = this.state.reprezentacije.find((reprezentacijaA) => reprezentacijaA.id == reprezentacijaAId);
    
        let utakmica= this.state.utakmica;
        utakmica.reprezentacijaA= reprezentacijaA;

        this.setState({utakmica: utakmica});
        this.isInputValid()
    }

    reprezentacijaBSelectionChanged(e) {

        let reprezentacijaBId=e.target.value;
        let reprezentacijaB = this.state.reprezentacije.find((reprezentacijaB) => reprezentacijaB.id == reprezentacijaBId);
    
        let utakmica= this.state.utakmica;
        utakmica.reprezentacijaB= reprezentacijaB;

        this.setState({utakmica: utakmica});
        this.isInputValid()
    }

    // valueInputChanged(e) {
    //     let input = e.target;

    //     let name = input.name;
    //     let value = input.value;

    //     let utakmica = this.state.utakmica;
    //     utakmica[name] = value;

    //     this.setState({ utakmica: utakmica });
    //     this.isInputValid()
    // }

 render() {
    return(
        <Row>
            <Col></Col>
            <Col xs="12" sm="10" md="8">
                <h1>Nova Utakmica</h1>

                    <Form>
                           
                            <Form.Group>
                                <Form.Label>Reprezentacija A</Form.Label>
                                <Form.Select name="reprezentacijaA" onChange={event => this.reprezentacijaASelectionChanged(event)}>
                                    <option></option>
                                    {
                                        this.state.reprezentacije.map((reprezentacijaA) => {
                                            return (
                                                <option key={reprezentacijaA.id} value={reprezentacijaA.id}>{reprezentacijaA.skraceniNaziv}</option>
                                            )
                                        })
                                    }
                                </Form.Select><br />
                            </Form.Group>

                            <Form.Group>
                                <Form.Label>Reprezentacija B</Form.Label>
                                <Form.Select name="reprezentacijaB" onChange={event => this.reprezentacijaBSelectionChanged(event)}>
                                    <option></option>
                                    {
                                        this.state.reprezentacije.map((reprezentacijaB) => {
                                            return (
                                                <option key={reprezentacijaB.id} value={reprezentacijaB.id}>{reprezentacijaB.skraceniNaziv}</option>
                                            )
                                        })
                                    }
                                </Form.Select><br />
                            </Form.Group>


                            <Button disabled={this.state.isValid} onClick={(event) => { this.create(event); }}>Dodaj</Button>
                     </Form>

            </Col>
        </Row>
    )
 }   
}





export default withNavigation(NovaUtakmica);