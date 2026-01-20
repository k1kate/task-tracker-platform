import '../styles/login.css'
import CardGlass from "../components/CardGlass.jsx";
import Input from "../components/Input.jsx";
import Button from "../components/Button.jsx";

function LoginPage() {
    return (
        <div>
            <CardGlass>
                <div className='login-container1'>
                    <CardGlass>
                        <div className='login-container2'>
                            <label className='card-title-2 login-lb'>АВТОРИЗАЦИЯ</label>
                            <Input icon='/img/Key.png' text_placeholder='Логин'/>
                            <Input icon='/img/User.png' text_placeholder='Пароль'/>
                            <Button text='Войти'></Button>
                        </div>


                    </CardGlass>
                    <img src='/img/ill2.png' className='ill'/>
                </div>
            </CardGlass>
        </div>
    )
}

export default LoginPage;
