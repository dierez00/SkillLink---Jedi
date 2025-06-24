// src/components/Home/Home.tsx

import React, { useState, useEffect, useRef } from 'react';
import "../../styles/Home/home.css";

// Para mejor organización y tipado, definimos los datos de los slides aquí
const slidesData = [
    { id: 1, src: "https://placehold.co/1200x600/3b82f6/ffffff?text=Curso+de+React", alt: "Imagen de un curso sobre React" },
    { id: 2, src: "https://placehold.co/1200x600/10b981/ffffff?text=Curso+de+Python", alt: "Imagen de un curso sobre Python" },
    { id: 3, src: "https://placehold.co/1200x600/ef4444/ffffff?text=Diseño+Web+Moderno", alt: "Imagen de un curso sobre Diseño Web" },
    { id: 4, src: "https://placehold.co/1200x600/8b5cf6/ffffff?text=Marketing+Digital", alt: "Imagen de un curso sobre Marketing Digital" },
    { id: 5, src: "https://placehold.co/1200x600/f97316/ffffff?text=Bases+de+Datos+SQL", alt: "Imagen de un curso sobre SQL" }
];

const Home: React.FC = () => {
    // --- Estado y Referencias ---
    const [currentIndex, setCurrentIndex] = useState(1); // 1 para empezar en el primer slide "real"
    const [slideWidth, setSlideWidth] = useState(0);
    const [isTransitioning, setIsTransitioning] = useState(false);
    const [transitionEnabled, setTransitionEnabled] = useState(true);

    const trackRef = useRef<HTMLDivElement>(null);

    // --- Lógica del Bucle Infinito (declarativa) ---
    // Clonamos el primer y último slide a nivel de datos, no de DOM
    const lastClone = slidesData[slidesData.length - 1];
    const firstClone = slidesData[0];
    const extendedSlides = [lastClone, ...slidesData, firstClone];

    // --- Efectos (Lifecycle) ---

    // Efecto para calcular el ancho del slide y manejar el redimensionamiento de la ventana
    useEffect(() => {
        const calculateSlideWidth = () => {
            if (trackRef.current?.firstChild) {
                const width = (trackRef.current.firstChild as HTMLElement).getBoundingClientRect().width;
                setSlideWidth(width);
            }
        };

        calculateSlideWidth(); // Calcular al montar el componente
        window.addEventListener('resize', calculateSlideWidth);

        // Función de limpieza para remover el listener
        return () => {
            window.removeEventListener('resize', calculateSlideWidth);
        };
    }, []);

    // Efecto para manejar el "salto" al slide real después de llegar a un clon
    useEffect(() => {
        // Si la transición fue deshabilitada para hacer el salto, la reactivamos después de un breve instante.
        if (!transitionEnabled) {
            const timer = setTimeout(() => {
                setTransitionEnabled(true);
            }, 50); // Un pequeño delay para asegurar que el cambio de transform se aplique sin transición
            return () => clearTimeout(timer);
        }
    }, [transitionEnabled]);


    // --- Manejadores de Eventos ---

    const handlePrev = () => {
        if (isTransitioning) return;
        setIsTransitioning(true);
        setCurrentIndex(prev => prev - 1);
    };

    const handleNext = () => {
        if (isTransitioning) return;
        setIsTransitioning(true);
        setCurrentIndex(prev => prev + 1);
    };

    const handleDotClick = (index: number) => {
        if (isTransitioning) return;
        setIsTransitioning(true);
        setCurrentIndex(index + 1); // +1 por el clon al inicio
    };

    const handleTransitionEnd = () => {
        setIsTransitioning(false);

        // Si estamos en un clon, saltamos al slide real correspondiente sin animación
        if (currentIndex === 0) { // Si es el clon del final (a la izquierda)
            setTransitionEnabled(false); // Desactivar transición
            setCurrentIndex(slidesData.length);
        } else if (currentIndex === extendedSlides.length - 1) { // Si es el clon del inicio (a la derecha)
            setTransitionEnabled(false); // Desactivar transición
            setCurrentIndex(1);
        }
    };

    // --- Lógica de Renderizado ---

    // Calculamos el índice del punto activo basado en los slides originales
    const activeDotIndex = (currentIndex - 1 + slidesData.length) % slidesData.length;

    return (
        <section className="section_home">
            <div className="div_container_home container mx-auto px-4 py-6 max-w-6xl">
                {/* Nav */}
                <div>
                    <nav className="flex items-center space-x-8 text-gray-500">
                        <a href="#" className="nav-link-active py-2">Inicio</a>
                        <a href="#" className="hover:text-gray-800 py-2">Mi aprendizaje</a>
                        <a href="#" className="hover:text-gray-800 py-2">Continuar aprendiendo</a>
                    </nav>
                </div>

                {/* section top */}
                <div className="mt-10">
                    <section id="inicio">
                        <h1 className="text-3xl font-bold text-center mb-6">Top cursos esta semana</h1>

                        <div className="relative">
                            <div className="carousel-container shadow-xl mx-16">
                                <div
                                    className="carousel-track"
                                    ref={trackRef}
                                    style={{
                                        transform: `translateX(-${slideWidth * currentIndex}px)`,
                                        transition: transitionEnabled ? 'transform 0.5s ease-in-out' : 'none'
                                    }}
                                    onTransitionEnd={handleTransitionEnd}
                                >
                                    {extendedSlides.map((slide, index) => (
                                        <div className="carousel-slide" key={`${slide.id}-${index}`}>
                                            <img src={slide.src} alt={slide.alt} />
                                        </div>
                                    ))}
                                </div>
                            </div>

                            <button className="carousel-button prev" onClick={handlePrev}>&#10094;</button>
                            <button className="carousel-button next" onClick={handleNext}>&#10095;</button>
                        </div>

                        <div className="carousel-dots">
                            {slidesData.map((_, index) => (
                                <button
                                    key={index}
                                    className={`dot ${index === activeDotIndex ? 'active' : ''}`}
                                    onClick={() => handleDotClick(index)}
                                />
                            ))}
                        </div>
                    </section>
                </div>

                {/* más cursos */}
                <div>
                    <h2>Más cursos</h2>
                </div>
            </div>
        </section>
    );
};

export default Home;