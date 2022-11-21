import React from "react";
import { useNavigate } from "react-router-dom";
import "../style/footer.css"
import Logo from "../assets/taurus_-_logo.png";

function Footer() {
  const navigate = useNavigate();

  return (
    <>
        <footer className="footer-principal">
            <div id="texto_footer">
                <p>© 2022 Copyright: conture.com.br</p>
                <p>CNPJ n.º 01.008.131/0001-01 / Rua Haddock Lobo, nº 500, Consolação, São Paulo/SP - CEP 01414-000 - Conture. </p>
            </div>
        </footer>
    </>
);
}

export default Footer;
