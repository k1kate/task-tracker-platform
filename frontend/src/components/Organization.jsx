import React from "react";
import '../styles/admin.css'
import List from "./List.jsx";
import Input from "./Input.jsx";
import Button from "./Button.jsx";


function Organization() {
    return (
        <div className='container-organization'>
            <label className='text-h'>Информация о организации</label>
            <div className='container-organization-2'>
                <div className='container-organization-1'>
                    <label className='text-mini'>Название организации:</label>
                    <Input icon='/img/Element.png'></Input>
                </div>

                <div className='container-organization-1'>
                    <label className='text-mini'>Количество приоритетов:</label>
                    <Input icon='/img/Lightning.png'></Input>
                </div>

                <div className='container-organization-1'>
                    <label className='text-mini'>Длительность спринта (недели):</label>
                    <Input icon='/img/Dashboard.png'></Input>
                </div>

                <div className='container-organization-1'>
                    <label className='text-mini'>Длительности релиза (в спринтах):</label>
                    <Input icon='/img/Dashboard.png'></Input>
                </div>


            </div>

             <Button text='Сохранить'></Button>
        </div>
    )
}

export default Organization;