import { useState } from 'react'
import { useNavigate } from 'react-router-dom'

function LoginPage({ setToken }) {
    const [formData, setFormData] = useState({ login: '', password: '' })
    const [response, setResponse] = useState('')
    const [loading, setLoading] = useState(false)
    const navigate = useNavigate()

    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value })
    }

    const handleSubmit = async (e) => {
        e.preventDefault()
        setLoading(true)
        setResponse('')

        try {
            const res = await fetch('http://localhost:8080/api/login', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(formData),
            })

            const data = await res.json()

            if (data.success) {
                localStorage.setItem('token', data.token)
                setToken(data.token)
                navigate('/')
            } else {
                setResponse(data.message)
            }
        } catch (err) {
            setResponse('Помилка: ' + err.message)
        } finally {
            setLoading(false)
        }
    }

    return (
        <div className="app-container">
            <div className="form-card">
                <h1 className="form-title">Login</h1>
                <form onSubmit={handleSubmit} className="form">
                    <div className="input-group">
                        <label htmlFor="login" className="label">Login</label>
                        <input
                            type="text"
                            id="login"
                            name="login"
                            value={formData.login}
                            onChange={handleChange}
                            required
                            className="input"
                            disabled={loading}
                        />
                    </div>
                    <div className="input-group">
                        <label htmlFor="password" className="label">Password</label>
                        <input
                            type="password"
                            id="password"
                            name="password"
                            value={formData.password}
                            onChange={handleChange}
                            required
                            className="input"
                            disabled={loading}
                        />
                    </div>

                    <button type="submit" className={`submit-btn ${loading ? 'disabled' : ''}`} disabled={loading}>
                        {loading ? 'Вхід...' : 'Увійти'}
                    </button>

                    {response && (
                        <div className={`response ${response.includes('Помилка') ? 'error' : 'success'}`}>
                            {response}
                        </div>
                    )}
                    <div style={{ marginTop: '1rem', textAlign: 'center' }}>
                        <button
                            className="submit-btn"
                            onClick={() => navigate('/register')}
                            disabled={loading}
                        >
                            Don't have an account? Register
                        </button>
                    </div>
                </form>
            </div>
        </div>
    )
}

export default LoginPage
