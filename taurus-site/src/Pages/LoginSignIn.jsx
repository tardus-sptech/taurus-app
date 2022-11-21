import axios from 'axios';
import React, {useState} from 'react';
import { useNavigate } from 'react-router-dom';
import api from '../api';

function LoginSignIn(){


    const [checkPass, setCheckPass] = useState(false);

    function changeCheck() {
        checkPass ? setCheckPass(false) : setCheckPass(true);
    }

    const LOGIN_URL = '/users/login';
    const SIGN_IN_URL = '';

    const navigate = useNavigate();

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [success, setSuccess] = useState(false);

    const login = async (e) => {
        e.preventDefault();

        try {
            const response = await api.post(LOGIN_URL, 
                JSON.stringify({email, password}),
                {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }
            );
            console.log(JSON.stringify(response?.data));
            setEmail('');
            setPassword('');
            sessionStorage.setItem('id', response.data.id)
            navigate("/loading");
        } catch (error) {
            console.error(error);
        }
    }
    
    return(
        <>
            <main id="main_container">
            <div id="login-box">
                <div className="content-box">
    
                    <form id="form-box" onSubmit={login}>
                        <div className="header-form">
                            <h1 className="title-form">Login</h1>
                            <div className="social-icons"></div>
                        </div>
        
                        <div className="inpt-form">
                            <p className="inpt-name">Email</p>
                            <div className="inpt-box">
                                <i className="fa-solid fa-envelope"></i>
                                <input 
                                    id="email_login" 
                                    type="email" 
                                    placeholder="Digite seu email" 
                                    onChange={(e) => setEmail(e.target.value)}
                                    value={email}
                                    required
                                />
                            </div>
                        </div>
        
                        <div className="inpt-form">
                            <p className="inpt-name">Senha</p>
                            <div className="inpt-box">
                                <i className="fa-solid fa-lock"></i>
                                <input 
                                    id="senha_login" 
                                    type={checkPass ? 'text' : 'password'} 
                                    placeholder="Digite sua senha"
                                    onChange={(e) => setPassword(e.target.value)}
                                    value={password}
                                    required
                                />
                                {/* <i className="fa-solid fa-eye-slash" id="checkPass" onClick={checkPass(1)}></i>
                                <i className="fa-solid fa-eye" id="checkPass2" onClick={checkPass(2)}></i> */}
                                <i 
                                onClick={changeCheck}
                                className={checkPass ? 'fa-solid fa-eye' : 'fa-solid fa-eye-slash'} 
                                id="checkPass"    
                                ></i>
                            </div>
                        </div>
        
                        <button className="bnt-2" title="Entrar">Entrar</button>
        
                        <div className="another-text">
                            <label for="" className="lbl_checkbox">
                                <input type="checkbox" name="" id=""/>
                                <span className="checkbox-spn">Lembrar-me</span>
                            </label>
                            <div className="btn-3">Esqueci minha senha</div>
                        </div>
                    </form>
        
                    <div id="current_auth_box">
                        <div className="box">
                            <h1 className="title">Taurus</h1>
                            <img src="../imagens/taurus_-_logo 1.png" alt="" />
                            <button className="btn" onClick="test(1)">Cadastro</button>
                        </div>
                    </div>
                </div>
            </div>
            
            <div id="signUp-box" style={{display: 'none'}}>
                <div className="content-box sign-up">
                    <div id="form-box-signup">
                        <div className="header-form">
                            <h1 className="title-form">Cadastro</h1>
                            <div className="social-icons"></div>
                        </div>
        
                        <div className="inpt-form">
                            <p className="inpt-name">Nome</p>
                            <div className="inpt-box">
                                <i className="fa-solid fa-envelope"></i>
                                <input id="email_cadastro" type="text" placeholder="Digite seu nome"/>
                            </div>
                        </div>
        
                        <div className="inpt-form">
                            <p className="inpt-name">CPF</p>
                            <div className="inpt-box">
                                <i className="fa-solid fa-id-card"></i>
                                <input id="cnpj_cadastro" type="text"  placeholder="Digite seu CPF"/>
                            </div>
                        </div>
        
                        <div className="inpt-form">
                            <p className="inpt-name">Data de nascimento</p>
                            <div className="inpt-box">
                                <i className="fa-solid fa-building"></i>
                                <input id="empresa_cadastro" type="date" placeholder=""/>
                            </div>
                        </div>
        
                        <div className="inpt-form">
                            <p className="inpt-name">Senha</p>
                            <div className="inpt-box">
                                <i className="fa-solid fa-lock"></i>
                                <input id="senha_cadastro" type="email" placeholder="Digite sua senha"/>
                            </div>
                        </div>
        
                        <div className="inpt-form">
                            <p className="inpt-name">Confirme sua senha</p>
                            <div className="inpt-box">
                                <i className="fa-solid fa-lock"></i>
                                <input id="confirmacao_senha_cadastro" type="email" placeholder="Confirme sua senha"/>
                            </div>
                        </div>
        
                        <button className="bnt-2" title="CADASTRAR" onClick="cadastrar()">Cadastrar</button>
        
                    </div>
        
                    <div id="current_auth_box">
                        <div className="box">
                            <h1 className="title">Bem vindo ao cadastro!</h1>
                            <button className="btn" onClick="test(2)">Login</button>
                        </div>
                    </div>
        
                </div>
            </div>
        </main>
        </>
    );
}

export default LoginSignIn;