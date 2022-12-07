import React,{useState, useEffect} from 'react';
import './style/tableRelatorios.css'

export default function TableRelatorios(props) {

    const [value, setValue] = useState(props.value);
    const [date, setDate] = useState(props.date);

    return(
        <>
            <tr>
                <td>{date}</td>
                <td className={value < 0 ? 'valueSpent' : 'valueGain'}>R$ {Number(value).toFixed(2)}</td>
            </tr>
        </>
    );
}