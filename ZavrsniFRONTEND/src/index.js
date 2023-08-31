import React from 'react'
import { createRoot } from 'react-dom/client';
import { Link, Routes, Route, BrowserRouter as Router, Navigate } from 'react-router-dom';
import { Navbar, Nav, Container, Button } from 'react-bootstrap';
import Home from './components/Home';
import Login from './components/authorization/Login';
import {logout} from './services/auth';


import Utakmice from './components/utakmice/Utakmice';
import Reprezentacije from './components/reprezentacije/Reprezentacije';
import NovaUtakmica from './components/utakmice/NovaUtakmica';
import EditUtakmica from './components/utakmice/EditUtakmica';


 
class App extends React.Component {

  render(){
      const jwt = window.localStorage['jwt'];

      if(jwt){
        return(
          <>
          <Router>
            <Navbar expand bg="dark" variant="dark">
                  <Navbar.Brand as={Link} to="/">
                    FIFA World Cup 
                  </Navbar.Brand>

                  <Nav>

                    <Nav.Link as={Link} to="/utakmice">
                      Utakmice
                    </Nav.Link>

                    <Nav.Link as={Link} to="/reprezentacije">
                      Reprezentacije
                    </Nav.Link>

                    <Button onClick={()=>logout()}>Logout</Button>

                  </Nav>
                 
            </Navbar>
            <Container style={{paddingTop: "10px"}}>
              <Routes>
                <Route path="/" element={<Home/>}/>
                <Route path="/login" element={<Navigate replace to='/'/>}/>
                <Route path="/utakmice" element={<Utakmice/>}/>
                <Route path="/utakmice/add" element={<NovaUtakmica/>}/>
                <Route path="/reprezentacije" element={<Reprezentacije/>}/>
                <Route path="/utakmice/edit:id" element={<EditUtakmica/>}/>

                <Route path='*' element={<Navigate replace to='/'/>} />
              </Routes>
            </Container>
          </Router>
          </>
        );
      }else{
        return(
          <>
          <Router>
          <Navbar expand bg="dark" variant="dark">
                        <Navbar.Brand as={Link} to="/">
                            FIFA World Cup
                        </Navbar.Brand>
                        <Nav>

                          <Nav.Link as={Link} to="/utakmice">
                            Utakmice
                          </Nav.Link>

                          <Nav.Link as={Link} to="/login">
                            Login
                          </Nav.Link>

                        </Nav>
                    </Navbar>
                    <Container style={{paddingTop:"10px"}}>
                    <Routes>
                        <Route path="/" element={<Home/>}/>
                        <Route path="/utakmice" element={<Utakmice/>}/>
                        <Route path="/login" element={<Login/>}/>
                        <Route path='*' element={<Navigate replace to='/'/>} />
                    </Routes>
                    </Container>
            </Router>
          </>
        );
      }
  }
};

const rootElement = document.getElementById('root');
const root = createRoot(rootElement);

root.render(
  <App/>,
);