import React from "react";

import Pontos from "../assets/pontos.png";
import Faca from "../assets/faca.png";
import Casa from "../assets/casa.png";
import Lista from "../assets/list.png";
import NavBar from "../Components/NavBar";
import Footer from "../Components/Footer";

function Lancamentos() {
  return (
    <>
      <NavBar />
      <div className="corFundo">
        <span className="alinhamentoBox">
          <div className="tamanhoBox">
            <div className="titulos">
              <h3>Lançamentos</h3>
              <h3>Novembro</h3>
              <h3>Contas</h3>
            </div>
            <div className="gasto">
              <div className="gastoEspecifico">
                <div className="espacamento">
                  <img className="facaimglancamento" src={Faca} alt="" />
                </div>
                <div>Alimentação</div>
              </div>
              <div className="banco">
                <div>Itaú</div>
              </div>
              <div className="custo">
                <div>-300,00</div>
              </div>
            </div>
            <div className="gasto">
              <div className="gastoEspecifico">
                <div className="espacamento">
                  <img className="facaimglancamento" src={Casa} alt="" />
                </div>
                <div>Casa</div>
              </div>
              <div className="banco">
                <div>Itaú</div>
              </div>
              <div className="custo">
                <div>-400,00</div>
              </div>
            </div>
            <div className="gasto">
              <div className="gastoEspecifico">
                <div className="espacamento">
                  <img className="facaimglancamento" src={Lista} alt="" />
                </div>
                <div>Outros Gastos</div>
              </div>
              <div className="banco">
                <div>NuBank</div>
              </div>
              <div className="custo">
                <div>-300,00</div>
              </div>
            </div>
            <div className="gasto">
              <div className="gastoEspecifico">
                <div className="espacamento">
                  <img className="facaimglancamento" src={Pontos} alt="" />
                </div>
                <div>Receita</div>
              </div>
              <div className="banco">
                <div>Santander</div>
              </div>
              <div className="custo">
                <div>1800,00</div>
              </div>
            </div>
          </div>
        </span>
        <Footer />
      </div>
    </>
  );
}

export default Lancamentos;
