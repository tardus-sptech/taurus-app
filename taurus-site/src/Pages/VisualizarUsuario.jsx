import { Button, Grid, TextField } from "@mui/material";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import Footer from "../Components/Footer";
import NavBar from "../Components/NavBar";
import api from "../api";

function VisualizarUsuario() {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [senha, setSenha] = useState("");

  const USER_URL = "/users";
  const idUser = sessionStorage.getItem("id");

  useEffect(() => {
    userData();
  }, []);

  const userData = async (e) => {
    try {
      const response = await api.get(`${USER_URL}/${idUser}`);
      setName(response.data.name);
      setEmail(response.data.email);
      setSenha(response.data.password);
    } catch (error) {
      console.error(error);
    }
  };

  function atualizarSenha() {
    const novaSenha = {
      name: name,
    };
    const personId = idUser;
    api.put(`/users/alterar/${personId}`, novaSenha);
  }

  return (
    <>
      <NavBar />
      <main id="user-content">
        <Grid container id="user-container">
          <Grid item lg={6}>
            <TextField label="Nome" onInput={(evento) => setName(evento.target.value)} color="secondary" value={name}  />
          </Grid>
          <Grid item lg={12}>
            <TextField color="secondary" label="Email" value={email} />
          </Grid>
            <input type="text" />
        </Grid>
        <Button onClick={atualizarSenha}>Trocar Senha</Button>
      </main>
      <Footer />
    </>
  );
}

export default VisualizarUsuario;
