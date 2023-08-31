import React from "react";
import Axios from "../../apis/Axios";
import { Button, Col, Form, Row } from 'react-bootstrap';
import { withNavigation, withParams } from '../../routeconf'

class EditUtakmica extends React.Component{
state = {
    utakmicaId: -1,
    utakmicaBrA: "",
    utakmicaBrB: "",
    // utakmicaReprezentacijaAId:"",
    // utakmicaReprezentacijaBId: "",
    // reprezentacije: [],
    // utakmicaReprezentacijaAIgraci: [],
    // utakmicaReprezentacijaBIgraci:[]
}

componentDidMount() {
    var id = this.props.params.id
    this.getUtakmicaById(id)
    // this.getReprezentacije()
    // this.getReprezentacijaAIgraci()
    // this.getReprezentacijaBIgraci()
}

getUtakmicaById(utakmicaId) {
    Axios.get("/utakmice/" + utakmicaId)
    .then(res => {
        console.log(res)
        this.setState( {
            utakmicaId: res.data.id,
            utakmicaBrA: res.data.brA,
            utakmicaBrB: res.data.brB
        })
    
    } )
    .catch(err => console.log(err))
}

edit(utakmicaId) {
    var params = {
        "id": this.state.utakmicaId,
        "brA": this.state.utakmicaBrA++,
        "brB": this.state.utakmicaBrB
    }
    Axios.put("/utakmice/" + this.state.utakmicaId, params)
    .then(res => {
        console.log(res)
        //ovde mozda da navigira na strelca gola,a ne na utakmice
        this.props.navigate("/reprezentacije")
    })
    .catch(error => {
        console.log(error)
    })
}
render() {
return (
    <Row>
    <Col xs="12" sm="10" md="8">
            <h1>Strelac gola</h1>
            <Form>
            {/* <Form.Group>
                    <Form.Label htmlFor="igracId">Strelac gola</Form.Label>
                    <Form.Control as="select" id="igracId"  onChange={event=>this.igracSelectionChanged(event)}>
                        <option>{this.state.reprezentacijaAIgracId}</option>
                        {
                            this.state.igraci.map((igrac) => {
                                return(
                                    <option key={igrac.id} value={igrac.id}>{igrac.ime}{igrac.prezime}</option>
                                )
                            })
                        }
                    </Form.Control><br/>
                   </Form.Group> */}
   {/* { 
    this.state.igraci.map((igrac) => {
        return(
            <option key={igrac.id} value={igrac.id}>{igrac.ime}{igrac.prezime}</option>
        )
   } 
    )} */}


            <Button onClick={() => this.edit(this.state.utakmicaId)}>Dodaj gol</Button>
                </Form>
     </Col>
            </Row>
    
  
)}

}

export default withParams(withNavigation(EditUtakmica))