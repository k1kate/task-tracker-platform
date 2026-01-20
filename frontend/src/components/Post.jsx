import React from "react";
import '../styles/admin.css'
import List from "./List.jsx";
import Button from "./Button.jsx";


function Post() {
    const positions = [
        { id: 1, text: "Аналитик" },
        { id: 2, text: "Разработчик" },
        { id: 3, text: "Тестировщик" }
    ];

    return (
        <div className='container-structure'>
            <label className='text-h'>Добавление должностей</label>
            <List initialItems={positions} placeh='Название должности'></List>
            <Button text='Сохранить'></Button>
        </div>
    )
}

export default Post;