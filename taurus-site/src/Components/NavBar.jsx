import "../App.css";
import Logo from "../assets/teste.png";

function NavBar() {
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
    </>
  );
}

export default NavBar;
