import React from "react";

const Navbar = () => (
  <nav className="fixed top-0 left-0 w-full bg-gradient-to-r from-white via-gray-100 to-gray-200 backdrop-blur-md bg-opacity-60 text-gray-900 p-4 z-50 border-b border-gray-300">
    <div className="container mx-auto flex justify-between items-center">
      <div className="text-xl font-semibold text-gray-900">SkillLink</div>
      <ul className="flex space-x-6 text-base">
        <li>
          <a href="#inicio" className="text-gray-900 hover:underline">Inicio</a>
        </li>
        <li>
          <a href="#servicios" className="text-gray-900 hover:underline">Sdfg</a>
        </li>
        <li>
          <a href="#contacto" className="text-gray-900 hover:underline">Contacto</a>
        </li>
      </ul>
    </div>
  </nav>
);

export default Navbar;
