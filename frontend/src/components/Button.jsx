import React from "react";


function Button({text}) {
    return (

            <a className="click-btn btn-style902" href="#">
                <div className="block"><span></span></div>
                <span data-name="hover">{text}</span>
                <span data-name="me"></span>
            </a>

    )
}

export default Button;