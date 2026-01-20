import React from "react";
import '../styles/main.css'


function Input({icon, text_placeholder}) {
    return (
        <div>
            <div className="input-wrapper">
                <img src={icon} alt="icon" className="icon-img"/>
                <input type="text" placeholder={text_placeholder} className="fancy-input card-title"/>

            </div>
        </div>
    )
}

export default Input;