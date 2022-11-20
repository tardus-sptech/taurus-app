import React, { useState } from "react";

import Dialog from "@mui/material/Dialog";
import Button from "@mui/material/Button";
import Typography from "@mui/material/Typography";

import Pontos from "../assets/pontos.png";
import Faca from "../assets/faca.png";
import Casa from "../assets/casa.png";
import Lista from "../assets/list.png";
import NavBar from "../Components/NavBar";
import Footer from "../Components/Footer";
import Teste from "./NovoLancamento";
import SimpleDialogDemo from "./teste";


function Lancamentos(props) {
  const handleOpen = () => setOpen(true);
  const [open, setOpen] = React.useState(false);
  const [selectedValue, setSelectedValue] = React.useState();

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = (value) => {
    setOpen(false);
    setSelectedValue(value);
  };

  return (
    <>
      <NavBar />
      <div className="corFundo">
        <span className="alinhamentoBox">
          <div className="tamanhoBox">
            <div className="titulos">
              <h3>
                Lançamentos
                <Button onClick={handleOpen} className="btnLancamento">
                  +
                </Button>
              </h3>
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
            <div>
              <Typography variant="subtitle1" component="div">
                Selected: {selectedValue}
              </Typography>
              <br />
              <Teste
                selectedValue={selectedValue}
                open={open}
                onClose={handleClose}
              />
            </div>
          </div>
        </span>
        <Footer />
      </div>
    </>
  );
}

export default Lancamentos;
