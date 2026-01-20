import React from "react";
import '../styles/admin.css'
import List from "./List.jsx";
import Button from "./Button.jsx";


function AddTasks() {
    const tasks = [
        { id: 1, text: "Задача" },
        { id: 2, text: "Баг" },
        { id: 3, text: "Доработка" }
    ];

    return (
        <div className='container-structure'>
            <label className='text-h'>Типы задач</label>
            <List initialItems={tasks} placeh='Название задачи'></List>
            <Button text='Сохранить'></Button>
        </div>
    )
}

export default AddTasks;