import React from "react";


function Button({text, onClick}) {
    return (

        <a
            className="click-btn btn-style902"
            href="#"
            onClick={(e) => {
                e.preventDefault(); // чтобы страница не перезагружалась
                onClick();
            }}
        >
            <div className="block"><span></span></div>
            <span data-name="hover">{text}</span>
            <span data-name="me"></span>
        </a>

    )
}

export default Button;