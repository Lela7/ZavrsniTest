import React from "react";
import Axios from './../../apis/Axios';
import { Row, Col, Button, Table, Form } from 'react-bootstrap'
import './../../index.css';
import { withParams, withNavigation } from '../../routeconf'

class Utakmice extends React.Component {

    constructor(props) {
        super(props);

        this.pageNo = 0;
        this.totalPages = 0;

          const search= {
        reprezentacijaAId: "",
        reprezentacijaBId: ""
    }

        this.state= {
            utakmice: [],
            reprezentacije: [],
            utakmicaId:"",
            brA:"",
            brB:"",
            reprezentacijaA:"",
            reprezentacijaB:"",
            //dodala sam ove reprezentacija,jer pokusavam da napravim dugme koje me vodi na strelca
            reprezentacijaAId:"",
            reprezentacijaBId:"",
            search: search
            // hideSearch: true
        };

        
    

  


    }

    componentDidMount(){
        this.getUtakmice(0)
        this.getReprezentacije()  //Da mi izbaci listu reprezentacija u search delu
    }


    async getUtakmice(newPageNo){

        let config = {
          params: {
            reprezentacijaAId: this.state.search.reprezentacijaAId,
            reprezentacijaBId: this.state.search.reprezentacijaBId,
            pageNo: newPageNo
          }
        }

  
        
        try {
            let result = await Axios.get("/utakmice", config);
            this.pageNo = newPageNo;
            this.totalPages = result.headers['total-pages']
            this.setState({
                utakmice: result.data
            })
        } catch (error) {
            console.log(error);
            alert('Error occured please try again!');
        }
    }

    // getUtakmice() {
    //     let config ={
    //         params: {
                
    //             reprezentacijaAId: this.state.search.reprezentacijaAId,
    //             reprezentacijaBId: this.state.search.reprezentacijaBId,
    //             pageNo: newPageNo

    //         }
    //     }

    //     Axios.get('/utakmice', config)
    //     .then(res => {
    //         // handle success
    //         this.pageNo = newPageNo;
    //         this.totalPages = result.headers['total-pages']
    //         console.log(res);
    //         this.setState({
    //             utakmice: res.data,
    //         });
    //     })
    //     .catch(error => {
    //         // handle error
    //         console.log(error);
    //         alert('Error occured please try again!');
    //     });
    // }

    goToAdd() {
        this.props.navigate("/utakmice/add");
    }

    // goToStrelac(id) {
    //     this.props.navigate("/igraci/strelac"+ id)
    // }

    
    deleteFromState(utakmicaId) {
        var utakmice = this.state.utakmice;
        utakmice.forEach((element, index) => {
            if (element.id === utakmicaId) {
                utakmice.splice (index, 1);
                this.setState({ utakmice: utakmice});
            }
        });

    }

   

      getReprezentacije() { //Da mi izbaci listu reprezentacija u search delu
        Axios.get("/reprezentacije")
        .then((response)=>{
            this.setState({reprezentacije:response.data});
        })
        .catch((err=>{console.log(err)}));
      } 

      getReprezentacijeStringFromList(list) { //Ovo ne znam za cega je
        return list.map (element => element.naziv).join(',');
      }

    
    onInputChange(event) {
        const name = event.target.name;
        const value = event.target.value

        let search = this.state.search;
        search[name] = value;

        this.setState({ search })
    }

    // onInputChangeA(e) {

    //     let reprezentacijaAId=e.target.value;
    //     let reprezentacijaA = this.state.reprezentacije.find((reprezentacijaA) => reprezentacijaA.id == reprezentacijaAId);
    
    //     let utakmica= this.state.utakmica;
    //     utakmica.reprezentacijaA= reprezentacijaA;

    //     this.setState({utakmica: utakmica});
    //     this.isInputValid()
    // }

    // onInputChangeB(e) {

    //     let reprezentacijaBId=e.target.value;
    //     let reprezentacijaB = this.state.reprezentacije.find((reprezentacijaB) => reprezentacijaB.id == reprezentacijaBId);
    
    //     let utakmica= this.state.utakmica;
    //     utakmica.reprezentacijaB= reprezentacijaB;

    //     this.setState({utakmica: utakmica});
    //     this.isInputValid()
    // }


    renderSearchForm() {
        return (
            <>
             <Form style={{ width: "99%" }}>
             <Row>
                    <Col>
                        <Form.Group>
                            <Form.Label>Reprezentacija A</Form.Label>
                            <Form.Select name="reprezentacijaAId" onChange={(e)=>this.onInputChange(e)}>
                            <option value=""></option>
                            {this.state.reprezentacije.map((reprezentacijaA)=>{
                                return(
                                    <option key={reprezentacijaA.id} value={reprezentacijaA.id}>{reprezentacijaA.skraceniNaziv}</option>
                                );
                            })}
                        </Form.Select>
                        </Form.Group>
                    </Col>


                    <Col>
                        <Form.Group>
                            <Form.Label>Reprezentacija B</Form.Label>
                            <Form.Select name="reprezentacijaBId" onChange={(e)=>this.onInputChange(e)}>
                            <option value=""></option>
                            {this.state.reprezentacije.map((reprezentacijaB)=>{
                                return(
                                    <option key={reprezentacijaB.id} value={reprezentacijaB.id}>{reprezentacijaB.skraceniNaziv}</option>
                                );
                            })}
                        </Form.Select>
                        </Form.Group>
                    </Col>

                           { /* Ovako sam uradila kad sam pravila Novu utakmicau: */}
                    {/* <Form.Select name="reprezentacijaB" onChange={event => this.reprezentacijaBSelectionChanged(event)}>
                                    <option></option>
                                    {
                                        this.state.reprezentacije.map((reprezentacijaB) => {
                                            return (
                                                <option key={reprezentacijaB.id} value={reprezentacijaB.id}>{reprezentacijaB.skraceniNaziv}</option>
                                            )
                                        })
                                    }
                                </Form.Select> */}


                   
                </Row>
                <br></br>
                <Button className="mt-3" onClick={() => this.getUtakmice()}>Pretraga</Button>


             </Form>

            </>
        )
    }


    render() {
        return (
            <Col>
                <Row><h1>Utakmice</h1></Row>

                <div>
                {this.renderSearchForm()}
                </div>
                <br></br>
                <br></br>





                {/* <div>
                    <label>
                    <input type="checkbox" onChange={()=>this.setState({hideSearch: !this.state.hideSearch})}/>
                        Show Search
                    </label>
                </div>
                <Row hidden={this.state.hideSearch} >
                    {this.renderSearchForm()}
                </Row>
                <br/> */}

                {/* {window.localStorage['role']=='ROLE_ADMIN'?
                <Row><Col>
                <Button onClick={() => this.goToAdd() }>Nova utakmica</Button>
                </Col></Row>: null} */}


<div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">
    <div>
  <Button onClick={() => this.goToAdd()}>
            Nova Utakmica
          </Button>
    
    </div>
    <div >
  <Button disabled={this.pageNo===0} 
                  onClick={()=>this.getUtakmice(this.pageNo-1)}
                  className="mr-3">Prethodna</Button>
                <Button disabled={this.pageNo==this.totalPages-1} onClick={()=>this.getUtakmice(this.pageNo+1)}>Sledeca</Button>
    </div>
</div>
             
                
                

                <Row><Col>
                <Table style={{marginTop: 5}}>
                <thead>
                <tr>
                <th>Reprezentacija A</th>
                <th>Reprezentacija B</th>
                <th>Golovi A</th>
                <th>Golovi B</th>
                <th></th>
                </tr>
                </thead>
                <tbody>
                    {this.renderUtakmice()}
                </tbody>
                </Table>
                </Col></Row>


                <div>
{/* ovde treba da klikom na dugme da nam izbaci preko alert-a najboljeg strelca */}
<Button onClick={() => this.goToNajboljiStrelac()}>
          Najbolji Strelac
        </Button>
  
</div>
            </Col>


        );
    }


    // onInputChange(event) {
    //     const name = event.target.name;
    //     const value = event.target.value

    //     let search = this.state.search;
    //     search[name] = value;

    //     this.setState({ search })
    // }

    // renderSearchForm() {
    //     return (
    //         <>
    //         <Form style={{ width: "99%" }}>
    //             <Row><Col>
    //                 <Form.Group>
    //                 <Form.Select name="id" onChange={(e)=>this.onInputChange(e)}>
    //                         <option value=""></option>
    //                         {this.state.reprezentacije.map((reprezentacija)=>{
    //                             return(
    //                                 <option value={reprezentacija.id}>{reprezentacija}</option>
    //                             );
    //                         })}
    //                         </Form.Select>
    //                 </Form.Group>
    //             </Col></Row>

    //             <Row><Col>
    //                 <Form.Group>
    //                 <Form.Select name="id" onChange={(e)=>this.onInputChange(e)}>
    //                         <option value=""></option>
    //                         {this.state.reprezentacije.map((reprezentacija)=>{
    //                             return(
    //                                 <option value={reprezentacijaAId}>{reprezentacijaANaziv}</option>
    //                             );
    //                         })}
    //                         </Form.Select>
    //                 </Form.Group>
    //             </Col></Row>
    //             </Form>
    //           <Row><Col>
    //           <Button className="mt-3" onClick={() => this.getReprezentacije()}>Pretraga</Button>
    //       </Col></Row>
    //       </>
    


            
    //     );
    // }

    dodajA() {

         

        var params= {
            'id': this.state.utakmicaId,
            'brA':this.state.brA+1,
            'brB':this.state.brB,
            'reprezentacijaA':this.state.reprezentacijaA,
            'reprezentacijaB':this.state.reprezentacijaB
         };
         Axios.put('/utakmice/' + this.state.utakmicaId, params)
         .then(res => {
            console.log(res);
            alert('Gol je uspesno dodat!');
            this.props.navigate('igraci/strelac')
         })
         .catch(error => {
            // handle error
            console.log(error);
            alert('Error occured please try again!');
         });
         
         this.goToStrelac()
        // this.props.navigate("/igraci/strelac");
    }

 goToEdit(id) {
    this.props.navigate("/utakmice/edit"+id)

 }
    
    




      delete(utakmicaId) {
        Axios.delete('/utakmice/' + utakmicaId)
        .then(res => {
            console.log(res);
            alert('Utakmica je uspesno obrisana!');
            this.deleteFromState(utakmicaId);
        })
        .catch(error=> {
            console.log(error);
            alert('Javila se greska, molimo pokusajte ponovo!')
        })
    }


    renderUtakmice() {
        return this.state.utakmice.map((utakmica)=> {
            return(
               
             
                
                
               
            <tr key={utakmica.id}>
                <td>{utakmica.reprezentacijaANaziv}</td>
                <td>{utakmica.reprezentacijaBNaziv}</td>
                <td>{utakmica.brA}</td>
                <td>{utakmica.brB}</td>

                {/* {window.localStorage['role'] == 'ROLE_ADMIN' ?
                        [
                           
                        <td><Button variant="warning" onClick={() => this.dodajA(utakmica.brA)}>A+1</Button></td>,
                        <td><Button variant="warning" onClick={() => this.dodajB(utakmica.brB)}>B+1</Button></td>,
                        <td><Button variant="danger" onClick={() => this.delete(utakmica.id)}>Obrisi</Button></td>]
                        : null} */}

{/* <Button onClick={() => this.goToAdd()}>
            Nova Utakmica
          </Button> */}
                        <td><Button variant="warning" onClick={() => this.goToEdit(utakmica.id)}>A+1</Button></td>
                        <td><Button variant="warning" onClick={() => this.goToEdit(utakmica.id)}>B+1</Button></td>
                        <td><Button variant="danger" onClick={() => this.delete(utakmica.id)}>Obrisi</Button></td>

            </tr>
            
            
            )
        })
    }




 


    
  




}

export default withNavigation(withParams(Utakmice));
