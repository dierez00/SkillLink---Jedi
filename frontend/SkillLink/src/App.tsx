import { Route, Routes } from "react-router-dom";
import DefaultLayout from "./components/common/DefaultLayout";
import CreateAcount from "./pages/CreateAcount";
import Home from "./pages/Home";
import Login from "./pages/Login";
import MyLearning from "./components/features/learning/MyLearning";
import CourseDetails from "./components/features/courses/CourseDetails";
import CourseLesson from "./components/features/courses/CourseLesson";
import { CoursesPage } from "./pages/CoursesPage";
import { Toaster } from "react-hot-toast";
import ProtectedRoute from "./components/features/auth/ProtectedRoute";

function App() {
  return (
    <>
      <Routes>
        <Route element={<DefaultLayout />}>
          <Route index element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path="/create-account" element={<CreateAcount />} />
          
          {/* Rutas protegidas - solo accesibles con autenticación */}
          <Route element={<ProtectedRoute />}>
            <Route path="/my-learning" element={<MyLearning />} />
            <Route path="/courses/:id" element={<CourseDetails />} />
            <Route path="/course" element={<CourseLesson />} />
            <Route path="/courses-page" element={<CoursesPage />} />
          </Route>
        </Route>
      </Routes>
      
      {/* Configuración de notificaciones */}
      <Toaster
        position="top-center"
        toastOptions={{
          duration: 3000,
          style: {
            background: '#363636',
            color: '#fff',
          },
        }}
      />
    </>
  );
}

export default App;