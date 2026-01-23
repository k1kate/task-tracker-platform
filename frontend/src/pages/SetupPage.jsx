import CardGlass from '../components/CardGlass.jsx'
import Input from '../components/Input.jsx'
import { useState } from "react";
import api from "../api/api.js";
import Button from "../components/Button.jsx";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function SetupPage() {
    const [url, setUrl] = useState("");
    const [user, setUser] = useState("");
    const [password, setPassword] = useState("");

    const sendHost = async () => {
        if (!url || !user || !password) {
            toast.warn("Заполните все поля!");
            return;
        }
        try {
            const db = { url, user, password };
            const res = await api.post("/api/database/migration", db);
            console.log(res.data)
            if (res.data.success) {
                toast.success(res.data.message); // зеленый toast
            } else {
                toast.error(res.data.message); // красный toast
            }

        } catch (e) {
            console.error(e);
            toast.error("Ошибка отправки: " + e.message);
        }
    };

    return (
        <div className="container-3">
            <ToastContainer
                toastStyle={{width: '400px'}}
                position="top-right"
                autoClose={5000}
                hideProgressBar={false}
                newestOnTop={false}
                closeOnClick
                rtl={false}
                pauseOnFocusLoss
                draggable
                pauseOnHover
            />

            <CardGlass>
                <div className="container-1">
                    <div className="container-2">
                    <label className="card-title">Введите хост PostgreSQL, например: localhost</label>

                        <Input
                            icon="/img/link.png"
                            value={url}
                            onChange={e => setUrl(e.target.value)}
                            required
                        />
                    </div>

                    <div className="container-2">
                    <label className="card-title">username</label>

                        <Input
                            icon="/img/User.png"
                            value={user}
                            onChange={e => setUser(e.target.value)}
                            required
                        />
                    </div>
                    <div className="container-2">
                    <label className="card-title">password</label>

                        <Input
                            icon="/img/Key.png"
                            type="password"
                            value={password}
                            onChange={e => setPassword(e.target.value)}
                            required
                        />

                    </div>

                    <Button text='Готово' onClick={sendHost} ></Button>

                </div>

            </CardGlass>

        </div>
    )
}

export default SetupPage;
