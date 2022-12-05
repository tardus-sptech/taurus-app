import React, {useState, useEffect} from 'react';
import "../style/highSpents.css";

function HighSpents(props) {

    const [key, setKey] = useState(props.key);
    const [name, setName] = useState(props.name);
    const [value, setValue] = useState(props.value);
    const [date, setDate] = useState(props.date);
    const [category, setCategory] = useState(props.category);

    return(
        <>
            <div className='spents-container'>
                <div className='spents-box'>

                    <div className="spents-header">
                        <i 
                            className={value > 0 ? 'fa-solid fa-plus' : 'fa-solid fa-minus'}
                            style={{backgroundColor : value < 0 ? '#FF6C6C' : '#1ABD68' }}
                        ></i>
                        <p>{category == null ? 'Depósito' : category}</p>
                        <span>|</span>
                        <p>{date}</p>
                    </div>

                    <div className='spent'>
                        <span>
                            <p>{name}</p>
                        </span>
                    </div>
                    <div>
                        <span className={value < 0 ? 'spent-value' : 'gain-value'}>R$ {Number(value).toFixed(2)}</span>
                    </div>
                </div>
            </div>
        </>
    );
}

export default HighSpents;