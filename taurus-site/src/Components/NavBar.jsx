import React from "react";
import { useNavigate } from "react-router-dom";
import logoTaurusWhite from "../assets/taurus-logo-white.png";

function NavBar() {
  const navigate = useNavigate();
  
  return (
    <>
      <header className="header">
            <div className="taurus-logo">
                <img src={logoTaurusWhite} alt=""/>
            </div>
            <nav className="nav-bar">
                <li className="nav-item">
                  <a onClick={() => navigate("/visaoGeral")}>Visão Geral</a>
                </li>
                <li className="nav-item">
                  <a onClick={() => navigate("/lancamentos")}>Lançamentos</a>
                </li>
                <li className="nav-item">
                  <a onClick={() => navigate("/relatorios")}>Relatórios</a>
                </li>
                <li className="nav-item">
                  <a onClick={() => navigate("/limite")}>Limite de gastos</a>
                </li>
            </nav>
            <div className="header-icons">
                <i className="fa-solid fa-user"></i>
                <i className="fa-solid fa-gear"></i>
            </div>
      </header>
    </>
  );
}

export default NavBar;