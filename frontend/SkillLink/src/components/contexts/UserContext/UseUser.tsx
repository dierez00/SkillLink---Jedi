import { useContext } from "react";
import { UserContext } from "./UserContext";
import type { UserContextType } from "./UserContextInterface";

export const useUser = (): UserContextType => { 
    const context = useContext(UserContext);

    if (context === undefined) {
        // Lanza un error si el hook se usa fuera del proveedor/donde envolvemos en App
        throw new Error("useUser is outside of UserProvider. Please wrap your component in UserProvider/App.tsx");
    }

    return context;
};