import React from "react";
import { useNavigate } from "react-router-dom";
import Logo from "../assets/taurus_-_logo.png";

function Footer() {
  const navigate = useNavigate();

  return (
    <>
      <footer className="footer">
        <img className="navbar_img" src={Logo} alt="" />
        <h1 className="footer_logo">Taurus</h1>
      </footer>
    </>
  );
}

export default Footer;
