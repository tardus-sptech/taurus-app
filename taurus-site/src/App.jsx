import "./App.css";
import Logo from "./assets/teste.png";
import Mulher from "./assets/croods-user-interface.png";
import Facebook from "./assets/facebook.png";
import Instagram from "./assets/instagram.png";
import Twitter from "./assets/twitter.png";
import User from "./assets/user3.png";

function App() {
  return (
    <>
      <nav class="navbar">
        <img class="navbar_img" src={Logo} alt="" />
        <h1 class="navbar_logo">Taurus</h1>
        <ul class="navbar_menu">
          <li class="navbar_item">
            <a href="./Home/index.html" class="navbar_links" id="home_page">
              Início
            </a>
          </li>
          <li class="navbar_item">
            <a href="./Home/index.html" class="navbar_links" id="sobre_page">
              Produto
            </a>
          </li>
          <li class="navbar_item">
            <a href="./Home/index.html" class="navbar_links" id="servico_page">
              Preço
            </a>
          </li>
          <li class="navbar_item">
            <a href="./Home/index.html" class="navbar_links" id="servico_page">
              Contato
            </a>
          </li>
          <li class="navbar_item">
            <a href="./login.html" class="navbar_links" id="login_page">
              Login
            </a>
          </li>
          <li class="navbar_btn">
            <a href="./cadastro.html" class="button" id="cadastro_page">
              Cadastro
            </a>
          </li>
        </ul>
      </nav>

      <div class="main-login">
        <div class="right-login">
          <div class="card-login">
            <h2>Sua ajuda financeira está aqui</h2>
            <h4>Faça a utilização gratuita do nosso produto por 15 dias.</h4>
            <button class="btn-login">Cadastro</button>
          </div>
        </div>
        <div class="left-login">
          <img src={Mulher} class="left-login-image" alt="Imagem Mulher" />
        </div>
      </div>

      <div class="size-estrategia">
        <div class="card-estrategia">
          <h3>Nossa Estratégia</h3>
          <h4>
            Vamos trazer organização financeira com simplicidade para a sua
            realidade.
          </h4>
          <div class="all-boxes">
            <div class="box-estrategia"><img src={User} alt="" class="user" /><span class="texto-user"> Metas conjuntas</span></div>
            <div class="box-estrategia"><img src={User} alt="" class="user" /> <span class="texto-user">Suporte ao Open Banking</span></div>
            <div class="box-estrategia"><img src={User} alt="" class="user" /> <span class="texto-user">Análise Financeira</span></div>
          </div>
          <div class="all-boxes-two">
            <div class="box-estrategia"><img src={User} alt="" class="user" /> <span class="texto-user">Sugestões aos usuários</span></div>
            <div class="box-estrategia"><img src={User} alt="" class="user" /> <span class="texto-user">Seu dinheiro salvo</span></div>
            <div class="box-estrategia"><img src={User} alt="" class="user" /> <span class="texto-user">Visualização sobre seus gastos</span></div>
          </div>
        </div>
      </div>

      <div class="footer_container">
        <div class="footer_links">
          <div class="footer_link--wrapper">
            <div class="footer_link--items">
              <h2>Taurus</h2>
              <a href="/sign__up">Simplicidade é a chave</a>{" "}
              <div class="logos">
                <a href="/">
                  <img class="footer_img" src={Facebook} alt="" />
                </a>
                <a href="/">
                  <img class="footer_img" src={Instagram} alt="" />
                </a>
                <a href="/">
                  <img class="footer_img" src={Twitter} alt="" />
                </a>
              </div>
            </div>
            <div class="footer_link--items">
              <h2>Contato</h2>
              <a href="/">Sobre nós</a>
              <a href="/">Contato</a>
              <a href="/">Produto</a>
            </div>
          </div>
          <div class="footer_link--wrapper">
            <div class="footer_link--items">
              <h2>Features</h2>
              <a href="/">Organização Financeira</a>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default App;
