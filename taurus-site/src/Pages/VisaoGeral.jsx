import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import Footer from "../Components/Footer";
import NavBar from "../Components/NavBar";
import ReactDOM from 'react-dom/client';
import { StyledEngineProvider } from '@mui/material/styles';
import BasicModal from "../Components/ModalLancamento";
import HighSpents from "../Components/HighSpents";
import api from "../api";

function VisaoGeral() {

    const navigate = useNavigate();

    var today = new Date(), time = today.getHours();
    var saudacao = time > 6 && time < 12 ? "Bom dia," : time < 18 ? "Boa tarde," : "Boa noite,";
    var icon = 6 < time && time < 18 ? "fa-sharp fa-solid fa-sun icontime" : "fa-sharp fa-solid fa-moon icontime";

    useEffect(() => { userData() }, []);
    useEffect(() => { listSpents() }, []);
    useEffect(() => { listGains() }, []);
    useEffect(() => { listGains2() }, []);

    const [name, setName] = useState('');
    const [balance, setBalance] = useState('');
    const [spents, setSpents] = useState([]);
    const [gains, setGains] = useState([]);
    const [transactions, setTransactions] = useState([]);

    var gasto = 0;
    var ganho = 0;

    const USER_URL = '/users';
    const SPENT_URL = '/spenties/user';
    const GAIN_URL = '/gains/user';
    const idUser = sessionStorage.getItem('id');

    const userData = async (e) => {
        try {
            const response = await api.get(`${USER_URL}/${idUser}`);
            setName(response.data.name);
            setBalance(Number(response.data.valueInAccount).toFixed(2));
        } catch (error) {
            console.error(error);
        }
    }

    const listSpents = async (e) => {

        try {
            const response = await api.get(`${SPENT_URL}/${idUser}`);
            setSpents(response.data);
        } catch (error) {
            console.error(error);
        }
    }
    spents.map((spents, index) => {

        (gasto += spents.value)

    })

    //
    const listGains = async (e) => {
        try {
            const response = await api.get(`${GAIN_URL}/${idUser}`);
            setGains(response.data);
        } catch (error) {
            console.error(error);
        }
    }

        const listGains2 = async (e) => {
            try {
                const response = await api.get(`${GAIN_URL}/${idUser}`);
                setTransactions(response.data);
            } catch (error) {
                console.error(error);
            }
        }

        gains.map((gains, index) => {

            ganho += gains.value

        })
        //
        const [category, setCategory] = useState([]);
        useEffect(() => {
            api.get(`/users/${idUser}`).then((resposta) => {
                setCategory(resposta.data);
                // console.log(resposta.data);
            })
        }, [])




        return (
            <>
                <NavBar />
                <main id="content">

                    <div id="first-container">
                        <div className="user-balence">

                            <div id="user-balance-header">
                                <div className="user-balance-identify">
                                    <span className="balance-title">{saudacao}</span>
                                    <span id="user-name">{name}<i className={icon}></i></span>
                                </div>

                                <div className="user-general-balance">
                                    <span className="balance-title">Saldo geral</span>
                                    <span id="money-balance">R$ <span id="balance">{balance}</span></span>
                                </div>
                            </div>

                            <div id="user-balance-footer">
                                <div className="user-balance-box" id="monthly-revenue">
                                    <span className="balance-title">Receita mensal</span>
                                    <span id="monthly-revenue-balance">R$ {Number(ganho).toFixed(2)}</span>
                                </div>
                                <div className="user-balance-box" id="monthly-expense">
                                    <span className="balance-title">Despesa mensal</span>
                                    <span id="monthly-expense-balance">R$ {Number(gasto).toFixed(2)}</span>
                                </div>
                                <div className="user-balance-box" id="reports">
                                    <span>
                                        <i className="fa-solid fa-chart-simple"></i>
                                        <span>Ver relatórios</span>
                                    </span>
                                </div>
                            </div>
                        </div>
                        <div className="balance-controls">
                            <BasicModal />
                        </div>
                    </div>


                    <div id="second-container">
                        <h1 className='title-container'>Últimas transações</h1>
                        <div className="high-spents">
                            {
                                transactions.map((transactions, index) => {
                                    return (
                                        <HighSpents
                                            key={transactions.id}
                                            name={transactions.name}
                                            value={transactions.value}
                                            date={transactions.created_at}
                                        />
                                    )
                                })
                            }
                        </div>
                    </div>
                </main>

                <Footer />
            </>
        );
}



export default VisaoGeral;