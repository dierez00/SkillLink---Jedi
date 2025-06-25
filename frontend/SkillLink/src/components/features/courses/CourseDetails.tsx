import   { useState } from "react";
import { useParams } from "react-router-dom";

const course = {
  title: "Digital Marketing Fundamentals",
  description:
    "Este curso cubre los fundamentos del marketing digital: SEO, marketing de contenidos, redes sociales y email marketing. Aprende a crear campañas efectivas y analizar resultados.",
  instructor: "Dra. Emily Carter",
  duration: "8 semanas",
  level: "Principiante",
  enrollment: "1,250 estudiantes",
  progress: 25,
  modules: [
    {
      title: "Módulo 1",
      desc: "Introducción al Marketing Digital",
    },
    {
      title: "Módulo 2",
      desc: "SEO (Optimización para Motores de Búsqueda)",
    },
    {
      title: "Módulo 3",
      desc: "Estrategias de Marketing de Contenidos",
    },
    {
      title: "Módulo 4",
      desc: "Marketing en Redes Sociales",
    },
    {
      title: "Módulo 5",
      desc: "Campañas de Email Marketing",
    },
  ],
};

const tabs = ["Overview", "Modules", "Resources"];

const CourseDetails = () => {
  const { id } = useParams();
  const [activeTab, setActiveTab] = useState("Overview");

  return (
    <div className="flex min-h-screen bg-white">
      {/* Sidebar */}
      <aside className="w-80 min-h-[700px] flex flex-col justify-between bg-white p-4 border-r">
        <div>
          <div className="flex items-center gap-3 mb-8">
            <div className="size-4">
              {/* Logo */}
              <svg viewBox="0 0 48 48" fill="none" className="w-6 h-6 text-[#111418]">
                <circle cx="24" cy="24" r="20" fill="currentColor" />
              </svg>
            </div>
            <h2 className="text-[#111418] text-lg font-bold">EduLearn</h2>
          </div>
          <nav className="flex flex-col gap-3">
            <a href="#" className="text-[#111418] text-sm font-medium">
              Home
            </a>
            <a href="#" className="text-[#111418] text-sm font-medium">
              Courses
            </a>
            <a href="#" className="text-[#111418] text-sm font-medium font-bold bg-[#f0f2f5] rounded px-3 py-2">
              My Learning
            </a>
            <a href="#" className="text-[#111418] text-sm font-medium">
              Instructors
            </a>
          </nav>
        </div>
      </aside>

      {/* Main Content */}
      <main className="flex-1 flex flex-col max-w-[960px] mx-auto">
        {/* Breadcrumb */}
        <div className="flex flex-wrap gap-2 p-4">
          <a className="text-[#60758a] text-base font-medium" href="#">
            Courses
          </a>
          <span className="text-[#60758a] text-base font-medium">/</span>
          <span className="text-[#111418] text-base font-medium">{course.title}</span>
        </div>

        {/* Título y descripción */}
        <div className="flex flex-wrap justify-between gap-3 p-4">
          <div className="flex min-w-72 flex-col gap-3">
            <p className="text-[#111418] text-[32px] font-bold leading-tight">{course.title}</p>
            <p className="text-[#60758a] text-sm">{course.description}</p>
          </div>
        </div>

        {/* Tabs */}
        <div className="pb-3">
          <div className="flex border-b border-[#dbe0e6] px-4 gap-8">
            {tabs.map((tab) => (
              <button
                type="button"
                key={tab}
                className={`flex flex-col items-center justify-center border-b-[3px] pb-[13px] pt-4 ${
                  activeTab === tab
                    ? "border-b-[#111418] text-[#111418] font-bold"
                    : "border-b-transparent text-[#60758a] font-bold"
                }`}
                onClick={() => setActiveTab(tab)}
              >
                <p className="text-sm leading-normal tracking-[0.015em]">{tab}</p>
              </button>
            ))}
          </div>
        </div>

        {/* Tab Content */}
        {activeTab === "Overview" && (
          <>
            {/* Progreso */}
            <div className="flex flex-col gap-3 p-4">
              <div className="flex gap-6 justify-between">
                <p className="text-[#111418] text-base font-medium">Progreso del curso</p>
              </div>
              <div className="rounded bg-[#dbe0e6]">
                <div
                  className="h-2 rounded bg-[#111418]"
                  style={{ width: `${course.progress}%` }}
                ></div>
              </div>
              <p className="text-[#60758a] text-sm">{course.progress}% completado</p>
            </div>
            {/* Detalles */}
            <h3 className="text-[#111418] text-lg font-bold px-4 pb-2 pt-4">Detalles del curso</h3>
            <div className="p-4 grid grid-cols-[20%_1fr] gap-x-6">
              <div className="col-span-2 grid grid-cols-subgrid border-t border-t-[#dbe0e6] py-5">
                <p className="text-[#60758a] text-sm">Instructor</p>
                <p className="text-[#111418] text-sm">{course.instructor}</p>
              </div>
              <div className="col-span-2 grid grid-cols-subgrid border-t border-t-[#dbe0e6] py-5">
                <p className="text-[#60758a] text-sm">Duración</p>
                <p className="text-[#111418] text-sm">{course.duration}</p>
              </div>
              <div className="col-span-2 grid grid-cols-subgrid border-t border-t-[#dbe0e6] py-5">
                <p className="text-[#60758a] text-sm">Nivel</p>
                <p className="text-[#111418] text-sm">{course.level}</p>
              </div>
              <div className="col-span-2 grid grid-cols-subgrid border-t border-t-[#dbe0e6] py-5">
                <p className="text-[#60758a] text-sm">Inscritos</p>
                <p className="text-[#111418] text-sm">{course.enrollment}</p>
              </div>
            </div>
            <div className="flex px-4 py-3">
              <button type="button" className="flex min-w-[84px] max-w-[480px] cursor-pointer items-center justify-center overflow-hidden rounded-lg h-10 px-4 flex-1 bg-[#0c7ff2] text-white text-sm font-bold">
                <span className="truncate">Inscribirse</span>
              </button>
            </div>
          </>
        )}

        {activeTab === "Modules" && (
          <>
            <h3 className="text-[#111418] text-lg font-bold px-4 pb-2 pt-4">Módulos</h3>
            {course.modules.map((mod, idx) => (
              <div className="flex items-center gap-4 bg-white px-4 min-h-[72px] py-2" key={mod.title}>
                <div className="text-[#111418] flex items-center justify-center rounded-lg bg-[#f0f2f5] shrink-0 size-12">
                  {/* Icono círculo */}
                  <svg width="24" height="24" fill="currentColor">
                    <circle cx="12" cy="12" r="10" />
                  </svg>
                </div>
                <div className="flex flex-col justify-center">
                  <p className="text-[#111418] text-base font-medium">{mod.title}</p>
                  <p className="text-[#60758a] text-sm">{mod.desc}</p>
                </div>
              </div>
            ))}
          </>
        )}

        {activeTab === "Resources" && (
          <div className="p-4">
            <p className="text-[#60758a]">Aquí puedes agregar recursos, archivos o enlaces útiles del curso.</p>
          </div>
        )}
      </main>
    </div>
  );
};

export default CourseDetails;
