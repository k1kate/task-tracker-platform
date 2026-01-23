import React from "react";
import '../styles/main.css'


function Input({icon, text_placeholder, value, onChange, required=false}) {
    return (
        <div>
            <div className="input-wrapper">
                <img src={icon} alt="icon" className="icon-img"/>
                <input
                    placeholder={text_placeholder}
                    className="fancy-input card-title"
                    value={value}
                    onChange={onChange}
                    required={required}
                />

            </div>
        </div>
    )
}

export default Input;