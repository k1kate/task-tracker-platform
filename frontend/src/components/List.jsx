import { useState } from "react";
import '../styles/admin.css'

export default function List({ initialItems, placeh}) {
    const [items, setItems] = useState(initialItems);
    const [value, setValue] = useState("");

    const addItem = () => {
        if (!value.trim()) return;

        const newItem = {
            id: Date.now(),   // уникальный id
            text: value
        };

        setItems([newItem, ...items]);
        setValue("");
    };

    const removeItem = (id) => {
        setItems(items.filter(item => item.id !== id));
    };

    return (
        <div className="container-list-1">


            <input
                className="list-input "
                value={value}
                onChange={(e) => setValue(e.target.value)}
                onKeyDown={(e) => e.key === "Enter" && addItem()}
                placeholder={placeh}
            />

            <ul className="list">
                {items.map((item, index) => (
                    <li key={item.id} className="list__item">
                        {item.text}
                        <span className="icon-close" onClick={() => removeItem(item.id)}>✕</span>
                    </li>
                ))}
            </ul>
        </div>
    );
}
