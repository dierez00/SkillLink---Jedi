import { Route, Routes } from "react-router-dom";
import DefaultLayout from "./components/common/DefaultLayout";
import CreateAcount from "./pages/CreateAcount";
import Home from "./pages/Home";
import Login from "./pages/Login";

function App() {
  return (
    <Routes>
      <Route element={<DefaultLayout />}>
        <Route index element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/create-account" element={<CreateAcount />} />
      </Route>
    </Routes>
  );
}

export default App;
