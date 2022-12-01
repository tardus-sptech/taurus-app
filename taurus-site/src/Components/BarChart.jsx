import React,{useState, useEffect} from "react";
import {Chart as ChartJs, BarElement, CategoryScale, LinearScale, Title, Legend, Tooltip} from 'chart.js';
import {Bar} from 'react-chartjs-2';
import api from "../api";

ChartJs.register(
    CategoryScale,
    LinearScale,
    BarElement,
    Title,
    Legend,
    Tooltip
)

export default function BarChart(){

    const [chart, setChart] = useState([]);
    const [chart2, setChart2] = useState([])

    const SPENT_URL = '/spenties/user';
    const GAIN_URL = '/gains/user';
    const idUser = sessionStorage.getItem('id');

    useEffect(() => {
        const listSpents = async (e) => {
            try {
                const response = await api.get(`${SPENT_URL}/${idUser}`);
                setChart(response.data);
            } catch (error) {
                console.error(error);
            }
        }

        const listGains = async (e) => {
            try {
                const response = await api.get(`${GAIN_URL}/${idUser}`);
                console.log(response.data)
                setChart2(response.data);
            } catch (error) {
                console.error(error);
            }
        }

        listSpents();
        listGains();
    }, [SPENT_URL, idUser, GAIN_URL])

    var data = {
        labels: chart?.map(x => x.name),
        datasets: [{
          label: `${(chart?.map.length) + 1} Gastos mapeados`,
          data: chart.map(x => Number(x.value) * -1),
          backgroundColor: [
            'rgba(255, 99, 132, 0.2)'
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