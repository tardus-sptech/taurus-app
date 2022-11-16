import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Index from "./Pages/Index";
import LimiteGastos from "./Pages/LimiteGastos";
import LoginSignIn from "./Pages/LoginSignIn";


function Rotas(){
    return(
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Index/>} />
                <Route path="/login" element={<LoginSignIn />} />
                <Route path="/limite" element={<LimiteGastos />} />
            </Routes>
        </BrowserRouter>
    );
}

export default Rotas;