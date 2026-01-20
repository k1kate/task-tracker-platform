import React from "react";
import '../styles/admin.css'
import BtnSq from "./BtnSq.jsx";


function Table() {
    return (


        <div className="container-table">
            <table className="demo-table">
                <thead>
                <tr>
                    {/*<td>Участник</td>*/}
                    {/*<td>Роль</td>*/}
                    {/*<td>Редактировать</td>*/}
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>


                </tr>
                </thead>
                <tbody>

                <tr className='tr-cont'>
                    <td className='profile-out'>
                        <div className="profile">
                            <img src="https://randomuser.me/api/portraits/men/41.jpg" alt=""/>
                            <div className="info">
                                <div className="title text-mini">James D. Young</div>
                                <div className="username text-mini">@JamesYoung</div>
                            </div>
                        </div>
                    </td>
                    <td className='role-out'>
                        <div className="role text-mini-table">
                            Участник
                        </div>
                    </td>
                    <td className='role-out'>
                        <div className="role text-mini-table">
                            Разработчик
                        </div>
                    </td>
                    <td className='edit-out'>
                        <BtnSq icon='/img/Element.png'></BtnSq>
                    </td>
                </tr>


                </tbody>
            </table>
        </div>
    )
}

export default Table;