import React from "react";
import Footer from "../Components/Footer";
import NavBar from "../Components/NavBar";
import BarChart from "../Components/BarChart";
import HotSite from "../Components/BodyHotSite";

export default function Hotsite(){
    return(
        <>
            <NavBar />
                {/* <div style={{width: '400px'}}>
                    <BarChart />
                </div> */}
                <HotSite />
            <Footer /> 
        </>
    );
}