import type { HeaderInterface } from "./HeaderInterface";

export const Header: React.FC<HeaderInterface> = ({ children }) => {
    return (
        <header>{children}</header>
    )
}

export default Header;