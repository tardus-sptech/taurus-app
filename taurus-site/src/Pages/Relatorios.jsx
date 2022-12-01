import React from "react";
import Footer from "../Components/Footer";
import NavBar from "../Components/NavBar";
import BarChart from "../Components/BarChart";

export default function Relatorios(){
    return(
        <>
            <NavBar />
                <div style={{width: '400px'}}>
                    <BarChart />
                </div>
            <Footer /> 
        </>
    );
}