import "../App.css";

function Faq() {
  return (
    <>
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
    </>
  );
}

export default Faq;