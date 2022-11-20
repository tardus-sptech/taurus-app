import React from "react";
import { useNavigate } from "react-router-dom";
import Footer from "../Components/Footer";
import NavBar from "../Components/NavBar";
import ReactDOM from 'react-dom/client';
import { StyledEngineProvider } from '@mui/material/styles';
import BasicModal from "../Components/ModalLancamento";

function VisaoGeral() {

    const navigate = useNavigate();
    const name = sessionStorage.getItem('name');

    var today = new Date(), time = today.getHours();
    var saudacao = time < 12 ? "Bom dia," : time < 18 ? "Boa tarde," : "Boa noite,";
    var icon = time < 18 ? "fa-sharp fa-solid fa-sun icontime" : "fa-sharp fa-solid fa-moon icontime";


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
                                <span id="money-balance">R$ <span id="balance">1.800,00</span></span>
                            </div>
                        </div>

                        <div id="user-balance-footer">
                            <div className="user-balance-box" id="monthly-revenue">
                                <span className="balance-title">Receita mensal</span>
                                <span id="monthly-revenue-balance">R$ 1.500,00</span>
                            </div>
                            <div className="user-balance-box" id="monthly-expense">
                                <span className="balance-title">Despesa mensal</span>
                                <span id="monthly-expense-balance">R$ 1.500,00</span>
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
                        <i className="fa-solid fa-circle-plus" id="plus-button"></i>
                        <i className="fa-solid fa-circle-minus" id="minus-button"></i>
                        <i className="fa-solid fa-right-left" id="swap-button"></i>

                        <BasicModal />

                    </div>
                </div>


                <div id="second-container">
                    <div id="left-div">
                        <div className="my-accounts">
                            <h1 className="title-container">Minhas contas</h1>
                            <div id="accounts-list">
                                <div className="account-user">
                                    <img src="./img/nubank-logo.png" alt="" className="bank-image-account" />
                                    <span>
                                        <span id="account-name">Renan Oliveira</span>
                                        <span id="type-account">Conta Corrente</span>
                                    </span>
                                    <span id="account-balance">R$ 500,00</span>
                                </div>
                            </div>
                        </div>
                        <div className="credit-cards">
                            <h1 className="title-container">Cartões de crédito</h1>
                            <div id="credit-card-list">

                                <div className="credit-card-user">
                                    <div className="credit-card-header">
                                        <img src="./img/nubank-logo.png" alt="" className="bank-image-account" />
                                        <span>
                                            <span className="bank-name">Nubank</span>
                                            <span>Cartão de crédito</span>
                                        </span>
                                    </div>
                                    <div className="credit-card-footer">
                                        <span>
                                            <span>Disponível</span>
                                            <span className="credit-avaliable">R$ 2.350,00</span>
                                        </span>
                                        <span>
                                            <span>Fatura</span>
                                            <span className="credit-bill">R$ 0,00</span>
                                        </span>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div id="right-div">
                        <div className="sign-details">
                            <h1 id="sign-details"></h1>
                        </div>
                        <div className="mouth-balance"></div>
                        <div className="high-spents"></div>
                        <div className="month-limits"></div>
                    </div>
                </div>

            </main>

            <Footer />
        </>
    );
}

export default VisaoGeral;