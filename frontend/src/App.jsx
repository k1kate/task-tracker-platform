import { useState } from 'react'
import { Routes, Route } from "react-router-dom";
import SetupPage from "./pages/SetupPage.jsx";
import './index.css'
import LoginPage from "./pages/LoginPage.jsx";
import AdminPanelPage from "./pages/AdminPanelPage.jsx";
// import './styles/main.css'
// import '/styles/setup.css'


function App() {
return (
    <Routes>
        <Route path="/" element={<SetupPage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/admin" element={<AdminPanelPage />} />
    </Routes>
)
}

export default App;
