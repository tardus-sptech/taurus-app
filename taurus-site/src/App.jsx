import "./App.css";
import Logo from "./assets/teste.png";
import Mulher from "./assets/croods-user-interface.png";
import Facebook from "./assets/facebook.png";
import Instagram from "./assets/instagram.png";
import Twitter from "./assets/twitter.png";
import User from "./assets/user3.png";
import Check from "./assets/check.png";
import Check2 from "./assets/check2.png";

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

      <div class="size-faq">
        <div class="card-faq">
          <div class="titulo-faq">
            <h3>FAQ</h3>
            <h4>Algumas perguntas que já nos fizeram</h4>
          </div>
          <div class="faq-boxes">
            <div class="box-faq">
              <div class="titulo-pergunta">
                A Taurus vende dados financeiros para parceiros?
              </div>
              <span class="titulo-resposta">
                Nunca. Nós da Taurus lucramos apenas com a sua assinatura
              </span>
            </div>
            <div class="box-faq">
              <div class="titulo-pergunta">
                A integração com o Open Banking é segura?
              </div>
              <span class="titulo-resposta">
                Sim. O Open Banking é regulamentado pelo Banco Central e é
                alinhado com a Lei Geral de proteção de dados.
              </span>
            </div>
            <div class="box-faq">
              <div class="titulo-pergunta">
                É necessário adicionar cartão de crédito para usar o teste de 15
                dias?
              </div>
              <span class="titulo-resposta">
                Não será solicitado nenhum dado de pagamento para o teste. Só
                será necessário caso queira adquirir nosso serviço.
              </span>
            </div>
          </div>
          <div class="faq-boxes-two">
            <div class="box-faq">
              <div class="titulo-pergunta">
                Posso fazer metas financeiras com quantas pessoas?
              </div>
              <span class="titulo-resposta">
                Com quantas você quiser! A Taurus oferece esse serviço para que
                possa chegar em suas metas da maneira que quiser.
              </span>
            </div>
            <div class="box-faq">
              <div class="titulo-pergunta">
                Os recursos da Taurus podem ser usados pelo celular?
              </div>
              <span class="titulo-resposta">
                Sim, todos os serviços oferecidos na web poderão ser acessados
                pelas plataformas Android e IOS
              </span>
            </div>
            <div class="box-faq">
              <div class="titulo-pergunta">
                A Taurus oferece produtos fora do plano pago?
              </div>
              <span class="titulo-resposta">
                Não. Todos os serviços que oferecemos estarão disponíveis na
                descrição do plano adquirido.
              </span>
            </div>
          </div>
        </div>
      </div>

      <div class="size-preco">
        <div class="card-preco">
          <div class="titulo-preco">
            <h3>Preço</h3>
            <h4 class="alinhamento-texto">
              Aqui você encontra o acesso aos nossos 3 planos, cada um deles
              <p>tem suas respectivas funcionalidades, aproveite.</p>
            </h4>
          </div>
          <div class="preco-boxes">
            <div class="box-preco">
              <span class="titulo-teste">
                <h2 class="nome-preco">TESTE</h2>
                <span class="titulo-descricao-preco">
                  Teste gratuito por 15 dias.
                </span>
              </span>
              <div class="periodo">
                <h1>GRÁTIS</h1>
                <h5>por 15 dias</h5>
              </div>
              <div class="logos-desc">
                <div class="funcionalidade">
                  <img src={Check} alt="" class="img-check" />
                  <h5>Análise Financeira</h5>
                </div>
                <div class="funcionalidade">
                  <img src={Check} alt="" class="img-check" />
                  <h5>Visualização de gastos</h5>
                </div>
                <div class="funcionalidade">
                  <img src={Check} alt="" class="img-check" />
                  <h5>Cadastros de gastos</h5>
                </div>
                <div class="funcionalidade">
                  <img src={Check2} alt="" class="img-check" />
                  <h5>Suporte Open Banking</h5>
                </div>
                <div class="funcionalidade">
                  <img src={Check2} alt="" class="img-check" />
                  <h5>Metas Conjuntas</h5>
                </div>
                <div class="alinhamento-button">
                  <button class="button-preco">ADIQUIRIR</button>
                </div>
              </div>
            </div>
            <div class="box-preco-meio">
              <span class="titulo-teste-meio">
                <h2 class="nome-preco-meio">APRIMORADO</h2>
                <span class="titulo-descricao-preco-meio">
                  Acesso à todas funcionalidades.
                </span>
              </span>
              <div class="periodo-meio">
                <h1>20,90</h1>
                <h5>R$ por mês</h5>
              </div>
              <div class="logos-desc-meio">
                <div class="funcionalidade-meio">
                  <img src={Check} alt="" class="img-check-meio" />
                  <h5>Análise Financeira</h5>
                </div>
                <div class="funcionalidade-meio">
                  <img src={Check} alt="" class="img-check-meio" />
                  <h5>Visualização de gastos</h5>
                </div>
                <div class="funcionalidade-meio">
                  <img src={Check} alt="" class="img-check-meio" />
                  <h5>Cadastros de gastos</h5>
                </div>
                <div class="funcionalidade-meio">
                  <img src={Check} alt="" class="img-check-meio" />
                  <h5>Suporte Open Banking</h5>
                </div>
                <div class="funcionalidade-meio">
                  <img src={Check} alt="" class="img-check-meio" />
                  <h5>Metas Conjuntas</h5>
                </div>
                <div class="funcionalidade-meio">
                  <img src={Check} alt="" class="img-check-meio" />
                  <h5>Sem limite para metas conjuntas</h5>
                </div>
                <div class="alinhamento-button-meio">
                  <button class="button-preco-meio">ADIQUIRIR</button>
                </div>
              </div>
            </div>
            <div class="box-preco">
              <span class="titulo-teste">
                <h2 class="nome-preco">PADRÃO</h2>
                <span class="titulo-descricao-preco">
                  Diversas funcionalidades e custo benefício.
                </span>
              </span>
              <div class="periodo">
                <h1>12,90</h1>
                <h5>R$ por mês</h5>
              </div>
              <div class="logos-desc">
                <div class="funcionalidade">
                  <img src={Check} alt="" class="img-check" />
                  <h5>Análise Financeira</h5>
                </div>
                <div class="funcionalidade">
                  <img src={Check} alt="" class="img-check" />
                  <h5>Visualização de gastos</h5>
                </div>
                <div class="funcionalidade">
                  <img src={Check} alt="" class="img-check" />
                  <h5>Cadastros de gastos</h5>
                </div>
                <div class="funcionalidade">
                  <img src={Check} alt="" class="img-check" />
                  <h5>Suporte Open Banking</h5>
                </div>
                <div class="funcionalidade">
                  <img src={Check} alt="" class="img-check" />
                  <h5>Metas Conjuntas</h5>
                </div>
                <div class="alinhamento-button">
                  <button class="button-preco">ADIQUIRIR</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div class="footer_container">
        <div class="footer_links">
          <div class="footer_link--wrapper">
            <div class="footer_link--items">
              <h2>Taurus</h2>
              <a href="/sign__up">Simplicidade é a chave</a>
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
