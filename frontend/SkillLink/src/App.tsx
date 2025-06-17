import './App.css'
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";

function App() {

  return (
    <Router>
      <Navbar />
      <main className="container mx-auto p-4">
        <Routes>
          <Route path="/" element={<h1 className="text-2xl">Home Page</h1>} />
          
        </Routes>

      </main>
      <Footer />
    </Router>
    
  );
}

export default App;
