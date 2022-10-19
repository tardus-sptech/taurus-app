import Check from "../assets/check.png";
import Check2 from "../assets/check2.png";

import "../App.css";

function Precos() {
  return (
    <>
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
    </>
  );
}

export default Precos;
