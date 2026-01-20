import { useState } from 'react'
// import './App.css'
import CardGlass from '../components/CardGlass.jsx'
import Input from '../components/Input.jsx'
// import '../styles/main.css'
// import '../styles/setup.css'


function SetupPage() {
    return (
        <div>
            <CardGlass>
                <div className="container-1">
                    <label className="card-title">Введите хост и порт PostgreSQL, например: localhost:5432</label>
                    <div className="container-2">
                        <Input  icon="/img/link.png"/>
                        <button className="input-button">
                            <img src='/img/right.png' alt="btn-icon" className="button-img"/>
                        </button>
                    </div>

                </div>

            </CardGlass>
        </div>
    )
}

export default SetupPage;
