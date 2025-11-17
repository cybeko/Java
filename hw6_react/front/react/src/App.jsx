import './App.css'
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom'
import { useState } from 'react'
import LoginPage from './LoginPage'
import RegisterPage from './RegisterPage'
import MainPage from './MainPage'

function App() {
    const [token, setToken] = useState(localStorage.getItem('token'))

    return (
        <Router>
            <Routes>
                <Route path="/" element={<MainPage token={token} />} />
                <Route path="/login" element={<LoginPage setToken={setToken} />} />
                <Route path="/register" element={<RegisterPage />} />
                <Route path="*" element={<Navigate to="/" replace />} />
            </Routes>
        </Router>
    )
}

export default App
