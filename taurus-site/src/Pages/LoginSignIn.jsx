import React from 'react';

function LoginSignIn(){


    function checkPass(x) {
        var eyeSlash = document.getElementById('checkPass');
        var eye = document.getElementById('checkPass2')
        var inpt = document.getElementById('senha_login');
    
        if(x == 1){
            eyeSlash.style.display = 'none';
            eye.style.display = 'block';
            inpt.type = 'text';
        }else{
            eye.style.display = 'none';
            eyeSlash.style.display = 'block';
            inpt.type = 'password';
        }
    }




    return(
        <>
            <main id="main_container">
            <div id="login-box">
                <div className="content-box">
    
                    <div id="form-box">
                        <div className="header-form">
                            <h1 className="title-form">Login</h1>
                            <div className="social-icons"></div>
                        </div>
        
                        <div className="inpt-form">
                            <p className="inpt-name">Email</p>
                            <div className="inpt-box">
                                <i className="fa-solid fa-envelope"></i>
                                <input id="email_login" type="email" placeholder="Digite seu email"/>
                            </div>
                        </div>
        
                        <div className="inpt-form">
                            <p className="inpt-name">Senha</p>
                            <div className="inpt-box">
                                <i className="fa-solid fa-lock"></i>
                                <input id="senha_login" type="password" placeholder="Digite sua senha"/>
                                <i className="fa-solid fa-eye-slash" id="checkPass" onClick={checkPass(1)}></i>
                                <i className="fa-solid fa-eye" id="checkPass2" onClick={checkPass(2)}></i>
                            </div>
                        </div>
        
                        <button className="bnt-2" title="Entrar" onClick="entrar()">Entrar</button>
        
                        <div className="another-text">
                            <label for="" className="lbl_checkbox">
                                <input type="checkbox" name="" id=""/>
                                <span className="checkbox-spn">Lembrar-me</span>
                            </label>
                            <a href="#" className="btn-3">Esqueci minha senha</a>
                        </div>
                    </div>
        
                    <div id="current_auth_box">
                        <div className="box">
                            <h1 className="title">Taurus</h1>
                            <img src="../imagens/taurus_-_logo 1.png" alt="" />
                            <button className="btn" onClick="test(1)">Cadastro</button>
                        </div>
                    </div>
                </div>
            </div>
            
            <div id="signUp-box" style="display: none;">
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