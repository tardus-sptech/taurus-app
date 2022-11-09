import React from "react";
import {BrowserRouter, Routes, Route} from "react-router-dom";
import Index from "./Pages/Index";
import LoginSignIn from "./Pages/LoginSignIn";


function Routes(){
    return(
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Index/>} />
                <Route path="/login" element={LoginSignIn} />
            </Routes>
        </BrowserRouter>
    );
}

export default Routes;