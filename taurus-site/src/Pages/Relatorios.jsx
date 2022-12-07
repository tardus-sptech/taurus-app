import React, {useState, useEffect} from "react";
import Footer from "../Components/Footer";
import NavBar from "../Components/NavBar";
import BarChart from "../Components/BarChart";
import HotSite from "../Components/BodyHotSite";
import api from "../api";
import '../style/relatorios.css'
import TableRelatorios from "../Components/TableRelatorios";

export default function Relatorios(){

    const SPENT_URL = '/spenties/user';
    const GAIN_URL = '/gains/user';
    const idUser = sessionStorage.getItem('id');
    const [active, setActive] = useState(true);
    const [spents, setSpents] = useState([]);

    useEffect(() => {listGains()}, [])

    const loadSpents = () => {
        listSpents();
        setActive(false);
    }

    const loadGains = () => {
        listGains();
        setActive(true);
    }

    const listSpents = async (e) => {

        try {
            const response = await api.get(`${SPENT_URL}/${idUser}`);
            setSpents(response.data);
            console.log(response.data)
        } catch (error) {
            console.error(error);
        }
    }

    const listGains = async (e) => {
        try {
            const response = await api.get(`${GAIN_URL}/${idUser}`);
            setSpents(response.data);
        } catch (error) {
            console.error(error);
        }
    }

    return(
        <>
            <NavBar />

                <div className="container-relatorios">

                    <div className="box-relatorios">

                        <div className="relatorios-header">
                            <h1 className="h1-header-relatorios">Relatórios</h1>
                            <h1 className="h1-header-relatorios month">Dezembro</h1>
                        </div>

                        <div className="relatorios-control">
                            <button 
                                className={active ? 'btn-relatorios-control active' : 'btn-relatorios-control'}
                                onClick={() => loadGains()}
                            >Receitas</button>

                            <button 
                                className={active ? 'btn-relatorios-control' : 'btn-relatorios-control active'}
                                onClick={() => loadSpents()}
                            >Despesas</button>
                        </div>

                        <div className="box-canvas">
                            <BarChart activeValue={active}/>
                        </div>

                        <div className="table-box">
                            <span>
                                <h1 className="title-table-relatorios">Detalhes</h1>
                            </span>

                            <div className="container-table">
                                <table className="table">
                                    <tr>
                                        <th>Período</th>
                                        <th>{active ? 'Entrada' : 'Saída'}</th>
                                    </tr>
                                    {
                                        spents.map((spents, index) => {
                                            return(
                                                <TableRelatorios 
                                                    key={spents.id}
                                                    date={spents.created_at}
                                                    value={active ? Number(spents.value) : Number(spents.value) * - 1}
                                                />
                                            )
                                        })
                                    }
                                </table>
                            </div>

                        </div>

                    </div>

                </div>

            <Footer /> 
        </>
    );
}