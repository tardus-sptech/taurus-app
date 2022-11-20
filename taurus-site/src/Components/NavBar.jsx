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
                  <button onClick={() => navigate("/visaoGeral")}>Visão Geral</button>
                </li>
                <li className="nav-item">
                  <button onClick={() => navigate("/lancamentos")}>Lançamentos</button>
                </li>
                <li className="nav-item">
                  <button onClick={() => navigate("/relatorios")}>Relatórios</button>
                </li>
                <li className="nav-item">
                  <button onClick={() => navigate("/limite")}>Limite de gastos</button>
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