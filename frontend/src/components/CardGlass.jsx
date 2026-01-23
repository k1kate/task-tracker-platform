import React from "react";
import '../styles/setup.css'

function CardGlass({ children, classname}) {
    return (
        <div className={`glass card-setup ${classname}`}>
            {children}
        </div>
    )
}

export default CardGlass;