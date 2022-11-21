import React, {useState} from 'react';
import "../style/highSpents.css";

function HighSpents(props) {

    const [name, setName] = useState(props.name);
    const [value, setValue] = useState(props.value);
    const [date, setDate] = useState(props.date);

    return(
        <>
            <div className='spents-container'>
                <h1 className='title-container'>Últimos gastos</h1>
                <div className='spents-box'>
                    <div className='spent'>
                        <span>
                            <i class="fa-solid fa-house"></i>
                            <p>fasdas</p>
                        </span>
                    </div>
                    <div>
                        <span className='spent-value'>R$ -1420.00</span>
                    </div>
                </div>
            </div>
        </>
    );
}

export default HighSpents;