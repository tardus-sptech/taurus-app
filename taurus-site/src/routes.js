import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Index from "./Pages/Index";
import Lancamentos from "./Pages/Lancamentos";
import LimiteGastos from "./Pages/LimiteGastos";
import LoginSignIn from "./Pages/LoginSignIn";
import Loading from "./Pages/Loading";
import VisaoGeral from "./Pages/VisaoGeral";
import EditarUsuario from "./Pages/VisualizarUsuario";


function Rotas(){
    return(
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Index/>} />
                <Route path="/login" element={<LoginSignIn />} />
                <Route path="/lancamentos" element={<Lancamentos />} />
                <Route path="/limite" element={<LimiteGastos />} />
                <Route path="/loading" element={<Loading />} />
                <Route path="/visaoGeral" element={<VisaoGeral />}/>
                <Route path="/conta" element={<EditarUsuario />}/>
            </Routes>
        </BrowserRouter>
    );
}

export default Rotas;