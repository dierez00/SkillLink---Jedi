import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";
import './App.css'

function App() {
  return (
    <Router>
      
      <Navbar />
      <main className="container mx-auto p-4">
        
        <h1 className="text-2xl font-bold mb-4">Bienvenidos</h1>
        <p>Equipo Jedi</p>
      </main>
      <Footer />
    </Router>
  );
}

export default App
