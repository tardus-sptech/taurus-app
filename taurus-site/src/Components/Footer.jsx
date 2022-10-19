import Facebook from "../assets/facebook.png";
import Instagram from "../assets/instagram.png";
import Twitter from "../assets/twitter.png";

import "../App.css";

function Footer() {
  return (
    <>
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

export default Footer;
