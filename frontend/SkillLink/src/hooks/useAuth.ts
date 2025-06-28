import { useEffect, useState } from "react";

export const useAuth = () => {
	const [isAuthenticated, setIsAuthenticated] = useState(false);

	useEffect(() => {
		const token = localStorage.getItem("authToken");
		setIsAuthenticated(!!token);
	}, []);

	return { isAuthenticated };
};
