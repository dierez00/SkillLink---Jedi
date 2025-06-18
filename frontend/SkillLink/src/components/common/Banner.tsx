import { cn } from "clsx-for-tailwind";
import MainWidth from "../layout/MainWidth";
import Button from "./Button";

const Banner = () => {
  return (
    <article className={cn("text-center")}>
      <MainWidth className={cn("px-8")}>
        <h2 className={cn("text-[65px] font-bold text-center leading-[80px]")}>
          Donde las <span className={cn("text-[#65CEEB]")}>habilidades</span>{" "}
          Encuentran <span className={cn("text-[#64DB68]")}>proyectos</span>
        </h2>
      </MainWidth>
      <MainWidth className={cn("mt-8")}>
        <p className={cn("text-[22px] text-center ")}>
          Únete a una comunidad de creadores, mentores y aprendices. Conecta con
          personas que comparten tus ineteréses y colabora en proyectos
          innovadores y lleva tus habilidades al siguiente nivel.
        </p>
        <Button
          style="tertiary"
          className={cn("h-[46px] text-[25px] px-5 mt-8")}
        >
          Ingresar
        </Button>
      </MainWidth>
    </article>
  );
};

export default Banner;
