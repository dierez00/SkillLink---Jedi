import { cn } from "clsx-for-tailwind";
import { useState } from "react";
import { Link, useLocation, useNavigate } from "react-router-dom";
import menu from "../../assets/images/menu.png";
import lightning from "../../assets/images/Rayo.png";
import Button from "../ui/Button";
import MainWidth from "../ui/MainWidth";

const Header = () => {
  const [showMenu, setShowMenu] = useState(false);

  const navigate = useNavigate();
  const location = useLocation();

  // const handleLoginButton = () => {
  //   navigate("/login");
  // };
  const handleCreateAccountButton = () => {
    navigate("/create-account");
  };

  return (
    <header
      className={cn(
        "bg-black h-[70px] shadow-[0_3px_5px_gray]",
        "max-[290px]:h-[150px]",
      )}
    >
      <MainWidth
        className={cn(
          "relative flex justify-between items-center flex-wrap",
          "h-full ",
        )}
      >
        <Link to={"/"} className={cn("flex gap-2.5")}>
          <img src={lightning} alt="Imagen de un rayo" />

          <h1 className={cn("text-3xl text-white font-bold select-none")}>
            Skill Link
          </h1>
        </Link>

        <button
          type="button"
          className={cn(
            "border-white border-[1px] rounded-md min-[600px]:hidden",
          )}
          onClick={() => {
            setShowMenu(!showMenu);
          }}
        >
          <img src={menu} alt="Menú desplegable" />
        </button>
        <div
          className={cn(
            "flex gap-4 flex-wrap justify-center items-center text-gray-200",
            "max-[600px]:absolute max-[600px]:top-20 max-[600px]:bg-black/65",
            "max-[600px]:h-[200px] max-[600px]:flex-col ",
            showMenu ? "max-[600px]:right-2" : "max-[600px]:right-full",
            "max-[600px]:px-3.5 max-[600px]:rounded-md",
          )}
        >
          {/* <Button onClick={handleLoginButton}>Iniciar sesión</Button> */}
          <Link
            to={"/login"}
            className={cn(
              "py-1.5 transition-all",
              location.pathname === "/login" &&
                "font-bold text-white border-b-2 border-white",
            )}
          >
            Iniciar Sesión
          </Link>

          <Link
            to={"/create-account"}
            className={cn(
              "py-1.5 transition-all",
              location.pathname === "/create-account" &&
                "font-bold text-white border-b-2 border-white",
            )}
          >
            Registrarse
          </Link>

          <Button style="primary" onClick={handleCreateAccountButton}>
            Prueba Gratis
          </Button>
        </div>
      </MainWidth>
    </header>
  );
};

export default Header;
