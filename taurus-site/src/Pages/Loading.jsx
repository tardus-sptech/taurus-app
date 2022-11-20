import React, {useEffect, useState} from 'react';
import {useNavigate} from "react-router-dom";
import gifLoading from "../assets/gifLoading.gif";
import logoTaurus from "../assets/taurus-logo-white.png";
import "../style/loading.css";

function Loading(){

    const navigate = useNavigate();

    const name = sessionStorage.getItem('name');

    useEffect(() => {loading()}, [])

    const [animation, setAnimation] = useState(false);
    const [display, setDisplay] = useState(false);

    function loading() {
        setTimeout(() => {
            setAnimation(true);
            setTimeout(() => {
                setDisplay(true);
                setTimeout(() => {
                    navigate("/visaoGeral");
                }, 3000);
            }, 1200);
        }, 5000);
    }

    return(
        <>
            <div id='loadingDiv'>
                <div className="main_container">
                    <div>
                        <div className="center_container">
                            <img className="logo_magna" src={logoTaurus} alt=""/>
                            <img className="gif_loading" src={gifLoading} alt=""/>
                        </div>
        
                        <div className="welcome_div">
                            <span 
                            className="welcome_user_spn" 
                            id="welcome_user_spn_id"
                            style={
                                {
                                    animation: animation ? 'fadeIn 2s' : '', 
                                    display: display ? 'block' : 'none'
                                }
                            }
                            >
                                Bem vindo(a), <span id="user_name">{name}</span>!
                            </span>
                        </div>
                    </div>
                </div>
                <footer className="footer"> 
                    <div className="content-footer">
                        <span>TAURUS - PERSONAL FINANCE &copy; 2022</span>
                    </div>
                </footer>
            </div>
        </>
    );
}

export default Loading;