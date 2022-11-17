import React from "react";

import Logo from "../assets/taurus_-_logo.png";
import Barra from "../assets/barra.png";
import Faca from "../assets/faca.png";
import Casa from "../assets/casa.png";
import Barra2 from "../assets/barravazia.png";
import NavBar from "../Components/NavBar";
import Footer from "../Components/Footer";

function LimiteGastos() {
  return (
    <>
      <NavBar />
      <div className="corFundo">
        <div className="size-limite">
          <div className="card-limite">
            <div className="limite-boxes">
              <div className="box-limite">
                <div className="titulo-limite">
                  <h3>Limite de Gastos</h3>
                  <h4>Novembro 2022</h4>
                </div>
                <div className="limites">
                  <div className="preco">
                    <img className="facaimg" src={Faca} alt="" />
                    <div className="titulo-pergunta">Alimentação</div>
                    <span className="titulo-resposta">200,00 de 200,00</span>
                  </div>
                  <div className="barra">
                    <img className="barraimg" src={Barra} alt="" />
                  </div>
                </div>
                <div className="limites">
                  <div className="preco">
                    <img className="facaimg" src={Casa} alt="" />
                    <div className="titulo-pergunta">Alimentação</div>
                    <span className="titulo-resposta">0,00 de 200,00</span>
                  </div>
                  <div className="barra">
                    <img className="barraimg" src={Barra2} alt="" />
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <Footer />
      </div>
    </>
  );
}

export default LimiteGastos;
