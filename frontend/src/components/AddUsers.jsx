import React from "react";
import '../styles/admin.css'
import Table from "./Table.jsx";
import Input from "./Input.jsx";
import BtnSq from "./BtnSq.jsx";


function Users() {

    return (
        <div>
            <label className='text-h'>Добавление участников</label>
            <div className='container-search'>
                <Input text_placeholder='Поиск' icon='/img/Search_alt.png'></Input>
                <BtnSq icon='/img/Add_round.png'></BtnSq>
            </div>

            <Table></Table>
        </div>
    )
}

export default Users;