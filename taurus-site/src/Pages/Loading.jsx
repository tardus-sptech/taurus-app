import React from 'react';
import {useNavigate} from "react-router-dom";

function Loading(){

    const navigate = useNavigate();

    return(
        <>
            <main className="main_container">
                <div>
                    <div className="center_container">
                        <img className="logo_magna" src="taurus-logo-white.png" alt=""/>
                        <img className="gif_loading" src="Eclipse-1.1s-200px.gif" alt=""/>
                    </div>
    
                    <div className="welcome_div">
                        <span className="welcome_user_spn" id="welcome_user_spn_id">
                            Bem vindo(a)! <span id="user_name"></span>
                        </span>
                    </div>
                </div>
            </main>
            <footer className="footer"> 
                <div className="content-footer">
                    <span>TAURUS - PERSONAL FINANCE &copy; 2022</span>
                </div>
            </footer>
        </>
    );
}

export default Loading;