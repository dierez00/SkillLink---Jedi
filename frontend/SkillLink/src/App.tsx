import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Header from "./components/Header/Header";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";
import Login from "./features/auth/Login";
import Home from "./components/Home/Home";
import Register from "./features/auth/Register";
import { UserProvider } from "./components/contexts/UserContext/UserContext";

function App() {
  return (
    <UserProvider>
      <Router>
        <Header children={<Navbar />} />

        <main>
          <Routes>
            <Route path="/" element={<h1 className="text-2xl font-bold mb-4">Bienvenidos</h1>} />
            <Route path="/login" element={<Login />} />
            <Route path="/register" element={<Register />} />
            <Route path="/home" element={<Home />} />

          </Routes>
        </main>
        <Footer />
      </Router>
    </UserProvider>
  );
}

export default App
