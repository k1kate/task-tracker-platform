import React from "react";
import '../styles/admin.css'
import List from "./List.jsx";
import Button from "./Button.jsx";


function Structure() {
    const departments = [
        { id: 1, text: "IT-отдел" },
        { id: 2, text: "Отдел разработки" },
        { id: 3, text: "Техническая поддержка" }
    ];

    return (
        <div className='container-structure'>
            <label className='text-h'>Добавление отделов</label>
            <List initialItems={departments} placeh='Название отдела'></List>
            <Button text='Сохранить'></Button>
        </div>
    )
}

export default Structure;