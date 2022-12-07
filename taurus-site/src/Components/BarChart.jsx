import React,{useState, useEffect} from "react";
import {Chart as ChartJs, BarElement, CategoryScale, LinearScale, Title, Legend, Tooltip} from 'chart.js';
import {Bar} from 'react-chartjs-2';
import api from "../api";
import { display } from "@mui/system";

ChartJs.register(
    CategoryScale,
    LinearScale,
    BarElement,
    Title,
    Legend,
    Tooltip
)

export default function BarChart(props){

    const [chart, setChart] = useState([]);

    const SPENT_URL = '/spenties/user';
    const GAIN_URL = '/gains/user';
    const idUser = sessionStorage.getItem('id');

    useEffect(() => {
        
        if(props.activeValue == true){
            const listGains = async (e) => {
                try {
                    const response = await api.get(`${GAIN_URL}/${idUser}`);
                    setChart(response.data);
                } catch (error) {
                    console.error(error);
                }
            }

            listGains();
        }else{
            const listSpents = async (e) => {
                try {
                    const response = await api.get(`${SPENT_URL}/${idUser}`);
                    setChart(response.data);
                } catch (error) {
                    console.error(error);
                }
            }

            listSpents();
        }

        console.log(props.activeValue)

    }, [SPENT_URL, idUser, GAIN_URL, props.activeValue])

    var data = {
        labels: chart?.map(x => x.created_at),
        datasets: [{
          label: `${props.activeValue ? 'Depósitos (R$)' : 'Gastos (R$)'}`,
          data: chart?.map(x => props.activeValue? Number(x.value) : Number(x.value) * - 1),
          backgroundColor: [
            props.activeValue ? 'rgba(0, 196, 157, 0.6)' : 'rgba(255, 108, 108, 0.6)'
          ],
          borderColor: [
            'rgb(255, 99, 132)'
          ],
          borderWidth: 1
        }]
    }

    var options = {
        maintainAspectRatio: false,
        legend:{
            labels: {
                fontSize: 26
            }
        }
    }

    return (
        <>
            <Bar 
                data={data}
                options={options}
                height={400}
            />
        </>
    );
}