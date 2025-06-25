import { useEffect, useState } from "react";
import { Link, useLocation, useNavigate } from "react-router-dom";
import { MagnifyingGlass, Bell, CaretDown } from "@phosphor-icons/react";
import logo from "../../assets/images/Rayo.png";

const Header = () => {
  const navigate = useNavigate();
  const location = useLocation();

  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [username, setUsername] = useState("Usuario");
  const [showDropdown, setShowDropdown] = useState(false);
  const [userImage, setUserImage] = useState("");


  
  useEffect(() => {
    const token = localStorage.getItem("token");
    const name = localStorage.getItem("username");
    let image = localStorage.getItem("userImage"); 

    if (!image) {
      image = "https://i.pravatar.cc/150?img=3";
      localStorage.setItem("userImage", image);
    }
    setIsLoggedIn(!!token);
    if (name) setUsername(name);
    if (image) setUserImage(image);
  }, [location]);

  const handleLogout = () => {
    localStorage.removeItem("token");
    localStorage.removeItem("username");
    localStorage.removeItem("userImage");
    navigate("/login");
  };

  return (
    <header className="flex items-center justify-between border-b border-gray-200 px-10 py-3">
      <div className="flex items-center gap-8">
        <Link to="/" className="flex items-center gap-2 text-[#121416]">
          <img src={logo} alt="Logo" className="size-6" />
          <h2 className="text-lg font-bold tracking-[-0.015em]">Skill Link</h2>
        </Link>

        {isLoggedIn && (
          <nav className="flex items-center gap-9">
            <Link to="/" className="text-sm font-medium text-[#121416]">
              Home
            </Link>
            <Link to="/my-learning" className="text-sm font-medium text-[#121416]">
              Mi aprendizaje
            </Link>
            <Link to="#" className="text-sm font-medium text-[#121416]">
              Wishlist
            </Link>
            <Link to="/courses-page" className="text-sm font-medium text-[#121416]">
              Cursos
            </Link>
          </nav>
        )}
      </div>

      <div className="flex items-center gap-6">
        <label className="min-w-40 max-w-64 h-10 hidden sm:block">
          <div className="flex items-stretch rounded-xl h-full">
            <div className="flex items-center justify-center pl-4 text-[#6a7581] bg-[#f1f2f4] rounded-l-xl">
              <MagnifyingGlass size={24} />
            </div>
            <input
              placeholder="Buscar"
              className="w-full bg-[#f1f2f4] px-4 text-base text-[#121416] rounded-r-xl border-none focus:outline-none"
            />
          </div>
        </label>

        <button className="rounded-full bg-[#f1f2f4] h-10 w-10 flex items-center justify-center text-[#121416]">
          <Bell size={20} />
        </button>

        {isLoggedIn ? (
          <div className="relative">
            <button
              className="flex items-center gap-2 focus:outline-none"
              onClick={() => setShowDropdown(!showDropdown)}
            >
              <div
                className="rounded-full size-10 bg-center bg-cover"
                style={{
                  backgroundImage: `url(${userImage || "https://lh3.googleusercontent.com/a-/default-user.png"})`,
                }}
              ></div>
              <CaretDown size={16} />
            </button>

            {showDropdown && (
              <div className="absolute right-0 mt-2 bg-white shadow-lg rounded-md overflow-hidden z-50 w-48">
                <div className="px-4 py-3 border-b border-gray-100 text-sm text-gray-800 font-medium">
                  {username}
                </div>
                <Link
                  to="/my-profile"
                  className="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100"
                  onClick={() => setShowDropdown(false)}
                >
                  Mi perfil
                </Link>
                <button
                  onClick={handleLogout}
                  className="w-full text-left px-4 py-2 text-sm text-gray-700 hover:bg-gray-100"
                >
                  Cerrar sesión
                </button>
              </div>
            )}
          </div>
        ) : (
          <div className="flex items-center gap-4">
            <Link
              to="/login"
              className={`text-sm ${
                location.pathname === "/login"
                  ? "font-bold text-[#121416] border-b-2 border-[#121416]"
                  : "text-[#121416]"
              }`}
            >
              Iniciar Sesión
            </Link>
            <Link
              to="/create-account"
              className={`text-sm ${
                location.pathname === "/create-account"
                  ? "font-bold text-[#121416] border-b-2 border-[#121416]"
                  : "text-[#121416]"
              }`}
            >
              Registrarse
            </Link>
            <button
              onClick={() => navigate("/create-account")}
              className="bg-[#121416] text-white px-4 py-2 rounded-md text-sm font-bold"
            >
              Prueba Gratis
            </button>
          </div>
        )}
      </div>
    </header>
  );
};

export default Header;
