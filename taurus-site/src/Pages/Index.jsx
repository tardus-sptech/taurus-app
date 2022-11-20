import React from "react";
import {useNavigate} from "react-router-dom";
import Logo from "../assets/taurus_-_logo.png"
import Mulher from "../assets/croods-user-interface.png"
import User from "../assets/user3.png"
import Check from "../assets/check.png"
import Check2 from "../assets/check2.png"
import Facebook from "../assets/facebook.png"
import Twitter from "../assets/twitter.png"
import Instagram from "../assets/instagram.png"
import { useEffect } from "react";
import { useState } from "react";
import api from "../api";

function Index() {

  const navigate = useNavigate();

//   const [name, setName] = useState("");
//     const [value, setValue] = useState("");
//     const [categoryId, setCategoryId] = useState("");
//     const [userId, setCuserId] = useState("");
    

  
  
//   useEffect(() => {
//     console.log("RESUMO DOS ESTADOS: ")
//     console.log("name: ", name)
//     console.log("value: ", value)
//     console.log("categoryId: ", categoryId)

// }, [name, value, categoryId, userId]);

//   function adicionarTransacao(evento) {
//     evento.preventDefault();
//    console.log("EVENTO: ", evento)

   
//     const novaTransacao = {
   
//   categoryId: 1,     // acessando input "ipt_genero" do formulário através do atributo "name" para obter seu valor
//   name: evento.target.ipt_titulo.value,     // acessando input "ipt_titulo" do formulário através do atributo "name" para obter seu valor
//   value: evento.target.ipt_valor.value,   // acessando input "ipt_artista" do formulário através do atributo "name" para obter seu valor
//   userId: 1,
// }
//   console.log("NOVO TRANSAÇÃO:", novaTransacao);

//         api.post("/spenties/").then("", novaTransacao )
//         .then((res) => console.log("res: ", res))
//         .catch((error) => console.error(error))

//   }
  return (
    <>
      <nav className="navbar">
        <img className="navbar_img" src={Logo} alt="" />
        <h1 className="navbar_logo">Taurus</h1>
        <div className="navbar_menu">
          <div className="navbar_item">
            <div className="navbar_links" id="home_page">
              Início
            </div>
          </div>
          <div className="navbar_item">
            <div className="navbar_links" id="sobre_page">
              Produto
            </div>
          </div>
          <div className="navbar_item">
            <div className="navbar_links" id="servico_page">
              Preço
            </div>
          </div>
          <div className="navbar_item">
            <div className="navbar_links" id="servico_page">
              Contato
            </div>
          </div>
          <div className="navbar_item">
            <div onClick={() => navigate("/login")} className="navbar_links" id="login_page">
              Login
            </div>
          </div>
          <div className="navbar_btn">
            <div onClick={() => navigate("/login")} className="button" id="cadastro_page">
              Cadastro
            </div>
          </div>
        </div>
      </nav>
      <div className="main-login">
        <div className="right-login">
          <div className="card-login">
            <h2>Sua ajuda financeira está aqui</h2>
            <h4>Faça a utilização gratuita do nosso produto por 15 dias.</h4>
            <button className="btn-login">Cadastro</button>
          </div>
        </div>
        <div className="left-login">
          <img src={Mulher} className="left-login-image" alt="Imagem Mulher" />
        </div>
      </div>

      <div className="size-estrategia">
        <div className="card-estrategia">
          <h3>Nossa Estratégia</h3>
          <h4>
            Vamos trazer organização financeira com simplicidade para a sua
            realidade.
          </h4>
          <div className="all-boxes">
            <div className="box-estrategia">
              <img src={User} alt="" className="user" />
              <span className="texto-user"> Metas conjuntas</span>
            </div>
            <div className="box-estrategia">
              <img src={User} alt="" className="user" />
              <span className="texto-user">Suporte ao Open Banking</span>
            </div>
            <div className="box-estrategia">
              <img src={User} alt="" className="user" />
              <span className="texto-user">Análise Financeira</span>
            </div>
          </div>
          <div className="all-boxes-two">
            <div className="box-estrategia">
              <img src={User} alt="" className="user" />
              <span className="texto-user">Sugestões aos usuários</span>
            </div>
            <div className="box-estrategia">
              <img src={User} alt="" className="user" />
              <span className="texto-user">Seu dinheiro salvo</span>
            </div>
            <div className="box-estrategia">
              <img src={User} alt="" className="user" />
              <span className="texto-user">Visualização sobre seus gastos</span>
            </div>
          </div>
        </div>
      </div>
      <div className="size-faq">
        <div className="card-faq">
          <div className="titulo-faq">
            <h3>FAQ</h3>
            <h4>Algumas perguntas que já nos fizeram</h4>
          </div>
          <div className="faq-boxes">
            <div className="box-faq">
              <div className="titulo-pergunta">
                A Taurus vende dados financeiros para parceiros?
              </div>
              <span className="titulo-resposta">
                Nunca. Nós da Taurus lucramos apenas com a sua assinatura
              </span>
            </div>
            <div className="box-faq">
              <div className="titulo-pergunta">
                A integração com o Open Banking é segura?
              </div>
              <span className="titulo-resposta">
                Sim. O Open Banking é regulamentado pelo Banco Central e é
                alinhado com a Lei Geral de proteção de dados.
              </span>
            </div>
            <div className="box-faq">
              <div className="titulo-pergunta">
                É necessário adicionar cartão de crédito para usar o teste de 15
                dias?
              </div>
              <span className="titulo-resposta">
                Não será solicitado nenhum dado de pagamento para o teste. Só
                será necessário caso queira adquirir nosso serviço.
              </span>
            </div>
          </div>
          <div className="faq-boxes-two">
            <div className="box-faq">
              <div className="titulo-pergunta">
                Posso fazer metas financeiras com quantas pessoas?
              </div>
              <span className="titulo-resposta">
                Com quantas você quiser! A Taurus oferece esse serviço para que
                possa chegar em suas metas da maneira que quiser.
              </span>
            </div>
            <div className="box-faq">
              <div className="titulo-pergunta">
                Os recursos da Taurus podem ser usados pelo celular?
              </div>
              <span className="titulo-resposta">
                Sim, todos os serviços oferecidos na web poderão ser acessados
                pelas plataformas Android e IOS
              </span>
            </div>
            <div className="box-faq">
              <div className="titulo-pergunta">
                A Taurus oferece produtos fora do plano pago?
              </div>
              <span className="titulo-resposta">
                Não. Todos os serviços que oferecemos estarão disponíveis na
                descrição do plano adquirido.
              </span>
            </div>
          </div>
        </div>
      </div>
      <div className="size-preco">
        <div className="card-preco">
          <div className="titulo-preco">
            <h3>Preço</h3>
            <h4 className="alinhamento-texto">
              Aqui você encontra o acesso aos nossos 3 planos, cada um deles
              <p>tem suas respectivas funcionalidades, aproveite.</p>
            </h4>
          </div>
          <div className="preco-boxes">
            <div className="box-preco">
              <span className="titulo-teste">
                <h2 className="nome-preco">TESTE</h2>
                <span className="titulo-descricao-preco">
                  Teste gratuito por 15 dias.
                </span>
              </span>
              <div className="periodo">
                <h1>GRÁTIS</h1>
                <h5>por 15 dias</h5>
              </div>
              <div className="logos-desc">
                <div className="funcionalidade">
                  <img src={Check} alt="" className="img-check" />
                  <h5>Análise Financeira</h5>
                </div>
                <div className="funcionalidade">
                  <img src={Check} alt="" className="img-check" />
                  <h5>Visualização de gastos</h5>
                </div>
                <div className="funcionalidade">
                  <img src={Check} alt="" className="img-check" />
                  <h5>Cadastros de gastos</h5>
                </div>
                <div className="funcionalidade">
                  <img src={Check2} alt="" className="img-check" />
                  <h5>Suporte Open Banking</h5>
                </div>
                <div className="funcionalidade">
                  <img src={Check2} alt="" className="img-check" />
                  <h5>Metas Conjuntas</h5>
                </div>
                <div className="alinhamento-button">
                  <button className="button-preco">ADIQUIRIR</button>
                </div>
              </div>
            </div>
            <div className="box-preco-meio">
              <span className="titulo-teste-meio">
                <h2 className="nome-preco-meio">APRIMORADO</h2>
                <span className="titulo-descricao-preco-meio">
                  Acesso à todas funcionalidades.
                </span>
              </span>
              <div className="periodo-meio">
                <h1>20,90</h1>
                <h5>R$ por mês</h5>
              </div>
              <div className="logos-desc-meio">
                <div className="funcionalidade-meio">
                  <img src={Check} alt="" className="img-check-meio" />
                  <h5>Análise Financeira</h5>
                </div>
                <div className="funcionalidade-meio">
                  <img src={Check} alt="" className="img-check-meio" />
                  <h5>Visualização de gastos</h5>
                </div>
                <div className="funcionalidade-meio">
                  <img src={Check} alt="" className="img-check-meio" />
                  <h5>Cadastros de gastos</h5>
                </div>
                <div className="funcionalidade-meio">
                  <img src={Check} alt="" className="img-check-meio" />
                  <h5>Suporte Open Banking</h5>
                </div>
                <div className="funcionalidade-meio">
                  <img src={Check} alt="" className="img-check-meio" />
                  <h5>Metas Conjuntas</h5>
                </div>
                <div className="funcionalidade-meio">
                  <img src={Check} alt="" className="img-check-meio" />
                  <h5>Sem limite para metas conjuntas</h5>
                </div>
                <div className="alinhamento-button-meio">
                  <button className="button-preco-meio">ADIQUIRIR</button>
                </div>
              </div>
            </div>
            <div className="box-preco">
              <span className="titulo-teste">
                <h2 className="nome-preco">PADRÃO</h2>
                <span className="titulo-descricao-preco">
                  Diversas funcionalidades e custo benefício.
                </span>
              </span>
              <div className="periodo">
                <h1>12,90</h1>
                <h5>R$ por mês</h5>
              </div>
              <div className="logos-desc">
                <div className="funcionalidade">
                  <img src={Check} alt="" className="img-check" />
                  <h5>Análise Financeira</h5>
                </div>
                <div className="funcionalidade">
                  <img src={Check} alt="" className="img-check" />
                  <h5>Visualização de gastos</h5>
                </div>
                <div className="funcionalidade">
                  <img src={Check} alt="" className="img-check" />
                  <h5>Cadastros de gastos</h5>
                </div>
                <div className="funcionalidade">
                  <img src={Check} alt="" className="img-check" />
                  <h5>Suporte Open Banking</h5>
                </div>
                <div className="funcionalidade">
                  <img src={Check} alt="" className="img-check" />
                  <h5>Metas Conjuntas</h5>
                </div>
                <div className="alinhamento-button">
                  <button className="button-preco">ADIQUIRIR</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div className="main-login-informado">
        <div className="right-login-informado">
          <div className="card-login-informado">
            <h2>Se mantenha informado</h2>
            <h4>
              Enviaremos noticias sobre o mercado financeiro, aviso de promoções
              e diversas dicas relacionadas ao uso do nosso sistema.
            </h4>
          </div>
        </div>
        <div className="left-login-informado">
          <input
            type="text"
            className="ipt-login-informado"
            placeholder="Digite seu Email"
          />
          <button className="btn-login-informado">Increver</button>
        </div>
      </div>
      <div className="footer_container">
        <div className="footer_links">
          <div className="footer_link--wrapper">
            <div className="footer_link--items">
              <h2>Taurus</h2>
              <a href="/sign__up">Simplicidade é a chave</a>
              <div className="logos">
                <a href="/">
                  <img className="footer_img" src={Facebook} alt="" />
                </a>
                <a href="/">
                  <img className="footer_img" src={Instagram} alt="" />
                </a>
                <a href="/">
                  <img className="footer_img" src={Twitter} alt="" />
                </a>
              </div>
            </div>
            <div className="footer_link--items">
              <h2>Contato</h2>
              <a href="/">Sobre nós</a>
              <a href="/">Contato</a>
              <a href="/">Produto</a>
            </div>
          </div>
          <div className="footer_link--wrapper">
            <div className="footer_link--items">
              <h2>Features</h2>
              <a href="/">Organização Financeira</a>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default Index;
