import { cn } from "clsx-for-tailwind";
import MainWidth from "../common/MainWidth";

const Footer = () => {
  return (
    <footer
      className={cn(
        "h-[250px] bg-[#7C7D7A] py-10",
        "shadow-[0_-1px_8px_black]",
      )}
    >
      <MainWidth
        className={cn(
          "flex justify-between flex-wrap items-start",
          "[&>*]:text-white",
        )}
      >
        <p className={cn("text-xl")}>
          Proyecto creato por el equipo “Jedi” para la AlumniThon
        </p>

        <div>
          <h4 className={cn("font-bold mb-3")}>Frond-End</h4>

          <p>Nombre</p>
          <p>Nombre</p>
          <p>Nombre</p>
        </div>

        <div>
          <h4 className={cn("font-bold mb-3")}>Back-End</h4>

          <p>Nombre</p>
          <p>Nombre</p>
        </div>
      </MainWidth>
    </footer>
  );
};

export default Footer;
