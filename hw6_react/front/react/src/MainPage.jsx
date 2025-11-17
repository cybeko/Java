import { Navigate } from 'react-router-dom'

function MainPage({ token }) {
    if (!token) {
        return <Navigate to="/login" replace />
    }

    const handleLogout = () => {
        localStorage.removeItem('token')
        window.location.reload()
    }

    return (
        <div className="app-container">
            <div className="form-card">
                <h1 className="form-title">Main Page</h1>
                <p>You've been authorized. Welcome to main page</p>
                <button
                    className="submit-btn"
                    onClick={handleLogout}
                    style={{ marginTop: '1rem' }}
                >Logout</button>
            </div>
        </div>
    )
}
export default MainPage
