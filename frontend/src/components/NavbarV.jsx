import React from "react";
import '../styles/admin.css'

function NavbarV({ onSelect }) {
    return (
        <div className='nav-cont'>
            <ul className='menu'>
                <li>
                    <a onClick={() => onSelect("org")}>
                        <img src="/img/Briefcase.png"/>
                        <span>Организация</span>
                    </a>
                </li>
                <li>
                    <a onClick={() => onSelect("structure")}>
                        <img src="/img/Settings%20slider.png"/>
                        <span>Структура</span>
                    </a>
                </li>
                <li>
                    <a onClick={() => onSelect("status")}>
                        <img src="/img/Trending%20up.png"/>
                        <i className="ai-file"></i>
                        <span>Статусы</span>
                    </a>
                </li>
                <li>
                    <a onClick={() => onSelect("post")}>
                        <img src="/img/Wrench.png"/>
                        <span>Должности</span>
                    </a>
                </li>

                <li>
                    <a onClick={() => onSelect("task")}>
                        <img src="/img/File.png"/>
                        <span>Задачи</span>
                    </a>
                </li>


                <li>
                    <a onClick={() => onSelect("users")}>
                        <img src="/img/Users.png"/>
                        <span>Участники</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img src="/img/Star.png"/>
                        <span>Администрирование</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img src="/img/User1.png"/>
                        <span>Профиль</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img src="/img/Home.png"/>
                        <span>Главная</span>
                    </a>
                </li>

            </ul>

        </div>
    )
}

export default NavbarV;