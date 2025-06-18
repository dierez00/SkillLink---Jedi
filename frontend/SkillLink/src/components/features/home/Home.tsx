import React from "react";

const Home = () => {
  return (
    <div className="w-full min-h-screen flex items-center justify-center bg-gradient-to-br from-gray-900 to-gray-800">
      <div className="text-center p-6 max-w-4xl">
        <h1 className="text-5xl font-bold mb-6 bg-clip-text text-transparent bg-gradient-to-r from-purple-400 to-pink-400">
          Bienvenido a nuestra plataforma
        </h1>
        <p className="text-xl text-gray-300 mb-8">
          Descubre todas las funcionalidades que tenemos para ofrecerte
        </p>
        <div className="flex justify-center space-x-4">
          <a 
            href="/register" 
            className="px-8 py-3 bg-gradient-to-r from-purple-500 to-pink-500 text-white rounded-lg font-medium hover:shadow-lg transition-all"
          >
            Comenzar
          </a>
          <a 
            href="/login" 
            className="px-8 py-3 border border-gray-600 text-gray-300 rounded-lg font-medium hover:bg-gray-800 transition-colors"
          >
            Iniciar sesión
          </a>
        </div>
      </div>
    </div>
  );
};

export default Home;