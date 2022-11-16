import React from "react";
import { useNavigate } from "react-router-dom";
import Logo from "../assets/taurus_-_logo.png";
import Config from "../assets/pngegg (1).png";
import User2 from "../assets/user.png";

function Lancamentos() {
  const navigate = useNavigate();
  function navigateLimite() {
    navigate("/limite");
  }

  return (
    <>
      <nav className="navbar">
        <img className="navbar_img" src={Logo} alt="" />
        <h1 className="navbar_logo">Taurus</h1>
        <div className="navbar_menu">
          <div className="navbar_item">
            <div className="navbar_links_logado">Visão Geral</div>
          </div>
          <div className="navbar_item">
            <div className="navbar_links_logado">Lançamentos</div>
          </div>
          <div className="navbar_item">
            <div className="navbar_links_logado" onClick={navigateLimite}>
              Limite de Gastos
            </div>
          </div>
          <div className="navbar_user">
            <img className="navbar_img_user" src={Config} alt="" />
          </div>
          <div className="navbar_user">
            <img className="navbar_img_user" src={User2} alt="" />
          </div>
        </div>
      </nav>
    </>
  );
}

export default Lancamentos;
