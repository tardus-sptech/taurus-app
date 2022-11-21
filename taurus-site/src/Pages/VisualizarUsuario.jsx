import { TextField } from "@mui/material";
import React from "react";
import { useNavigate } from "react-router-dom";
import Footer from "../Components/Footer";
import NavBar from "../Components/NavBar";

function VisualizarUsuario() {
  const navigate = useNavigate();
  const name = sessionStorage.getItem("name");

  const email = sessionStorage.getItem("email");

  return (
    <>
      <NavBar />
      <main id="user-content">
        <div id="user-container">
          <TextField disabled label="Nome">
            {name}
          </TextField>
          <TextField disabled label="Email">
            {email}
          </TextField>
        </div>
      </main>
      <Footer />
    </>
  );
}

export default VisualizarUsuario;
