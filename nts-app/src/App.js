// src/App.js

import React from 'react';
import { useSelector } from 'react-redux';
import Header from './components/Header';
import Footer from './components/Footer';
import UserData from './components/UserData';
import Prodaja from './components/Prodaja';
import Servis from './components/Servis';
import Home from './components/Home';
import About from './components/About';

const App = () => {
    const activeComponent = useSelector(state => state.activeComponent); // Uzmi aktivnu komponentu iz stanja

    const renderComponent = () => {
        switch (activeComponent) {
            case 'UserData':
                return <UserData />;
            case 'Prodaja':
                return <Prodaja />;
            case 'Servis':
                return <Servis />;
            case 'About':
                return <About />;
            case 'Home':
            default:
                return <Home />;
        }
    };

    return (
        <div>
            <Header />
            <main className="container mt-4">
                {renderComponent()} {/* Prikazuje samo aktivnu komponentu */}
            </main>
            <Footer />
        </div>
    );
};

export default App;
