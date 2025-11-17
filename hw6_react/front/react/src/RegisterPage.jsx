import { useState } from 'react'
import { useNavigate } from 'react-router-dom'

function RegisterPage() {
    const [formData, setFormData] = useState({ login: '', password: '', confirmPassword: '' })
    const [response, setResponse] = useState('')
    const [loading, setLoading] = useState(false)
    const navigate = useNavigate()

    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value })
    }

    const handleSubmit = async (e) => {
        e.preventDefault()
        if (formData.password !== formData.confirmPassword) {
            setResponse('Passwords do not match')
            return
        }
        setLoading(true)
        setResponse('')


        try {
            const res = await fetch('http://localhost:8080/api/register', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(formData),
            })

            const data = await res.json()

            if (data.success) {
                setResponse(data.message)
                setTimeout(() => navigate('/login'), 1000)
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
                <h1 className="form-title">Register</h1>
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
                    <div className="input-group">
                        <label htmlFor="confirmPassword" className="label">Confirm Password</label>
                        <input
                            type="password"
                            id="confirmPassword"
                            name="confirmPassword"
                            value={formData.confirmPassword}
                            onChange={handleChange}
                            required
                            className="input"
                            disabled={loading}
                        />
                    </div>

                    <button type="submit" className={`submit-btn ${loading ? 'disabled' : ''}`} disabled={loading}>
                        {loading ? 'Registering...' : 'Register'}
                    </button>

                    {response && (
                        <div className={`response ${response.includes('Помилка') ? 'error' : 'success'}`}>
                            {response}
                        </div>
                    )}
                </form>
            </div>
        </div>
    )
}

export default RegisterPage
