import type { ReactNode } from "react";
export interface User {
    id: string;
    name: string;
    email: string;
    role: "admin" | "user" | "guest" | "mentor";
}

export interface UserContextType {
    user: User | null;
    login: (userData: User) => void;
    logout: () => void;
}

export interface UserProviderProps {
        children: ReactNode;
}