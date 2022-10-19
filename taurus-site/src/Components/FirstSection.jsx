import "../App.css";
import Mulher from "../assets/croods-user-interface.png";
import User from "../assets/user3.png";

function FirstSection() {
  return (
    <>
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
            <div class="box-estrategia">
              <img src={User} alt="" class="user" />
              <span class="texto-user"> Metas conjuntas</span>
            </div>
            <div class="box-estrategia">
              <img src={User} alt="" class="user" />
              <span class="texto-user">Suporte ao Open Banking</span>
            </div>
            <div class="box-estrategia">
              <img src={User} alt="" class="user" />
              <span class="texto-user">Análise Financeira</span>
            </div>
          </div>
          <div class="all-boxes-two">
            <div class="box-estrategia">
              <img src={User} alt="" class="user" />
              <span class="texto-user">Sugestões aos usuários</span>
            </div>
            <div class="box-estrategia">
              <img src={User} alt="" class="user" />
              <span class="texto-user">Seu dinheiro salvo</span>
            </div>
            <div class="box-estrategia">
              <img src={User} alt="" class="user" />
              <span class="texto-user">Visualização sobre seus gastos</span>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default FirstSection;
