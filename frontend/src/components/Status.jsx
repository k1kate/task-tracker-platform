import React from "react";
import '../styles/admin.css'
import List from "./List.jsx";
import Button from "./Button.jsx";


function Status() {
    const statuses = [
        { id: 1, text: "Анализ" },
        { id: 2, text: "Разработка" },
        { id: 3, text: "Тестирование" }
    ];

    return (
        <div className='container-structure'>
            <label className='text-h'>Статусы задач</label>
            <List initialItems={statuses} placeh='Название статуса'></List>
            <Button text='Сохранить'></Button>
        </div>
    )
}

export default Status;