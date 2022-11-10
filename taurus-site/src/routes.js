import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Index from "./Pages/Index";
import LoginSignIn from "./Pages/LoginSignIn";


function Rotas(){
    return(
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Index/>} />
                <Route path="/login" element={<LoginSignIn />} />
            </Routes>
        </BrowserRouter>
    );
}

export default Rotas;