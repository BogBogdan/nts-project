import React from 'react';
import { Navbar, Nav } from 'react-bootstrap';
import { useDispatch } from 'react-redux';
import { setActiveComponent } from '../redux/actions';

const Header = () => {
    const dispatch = useDispatch();

    const handleNavClick = (component) => {
        dispatch(setActiveComponent(component));
    };

    return (
        <Navbar bg="light" expand="lg">
            <Navbar.Brand href="#home">NTSApp</Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
            <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="mr-auto">
                    <Nav.Link href="#home" onClick={() => handleNavClick('Home')}>Pocetna</Nav.Link>
                    <Nav.Link href="#about" onClick={() => handleNavClick('About')}>O nama</Nav.Link>
                    <Nav.Link href="#user-data" onClick={() => handleNavClick('UserData')}>User Data</Nav.Link>
                    <Nav.Link href="#prodaja" onClick={() => handleNavClick('Prodaja')}>Prodaja</Nav.Link>
                    <Nav.Link href="#servis" onClick={() => handleNavClick('Servis')}>Servis</Nav.Link>
                </Nav>
            </Navbar.Collapse>
        </Navbar>
    );
};

export default Header;
