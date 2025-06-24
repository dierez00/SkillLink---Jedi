import { createContext, useEffect, useState } from "react";
import type {
  User,
  UserContextType,
  UserProviderProps,
} from "./UserContextInterface";

export const UserContext = createContext<UserContextType | undefined>(
  undefined,
);

export const UserProvider = ({ children }: UserProviderProps) => {
  const [user, setUser] = useState<User | null>(null);

  useEffect(() => {
    const fetchedUser: User = {
      id: "123",
      name: "Juan Pérez",
      email: "juan@example.com",
      role: "user",
    };
    setUser(fetchedUser);
  }, []);

  const login = (userData: User) => {
    setUser(userData);
  };

  const logout = () => {
    setUser(null);
  };

  const contextValue: UserContextType = {
    user,
    login,
    logout,
  };

  return (
    <UserContext.Provider value={contextValue}>{children}</UserContext.Provider>
  );
};
