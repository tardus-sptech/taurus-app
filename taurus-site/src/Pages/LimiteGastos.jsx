import React from "react";

import { useEffect, useState } from "react";
import NavBar from "../Components/NavBar";
import Footer from "../Components/Footer";
import Card from "../Components/CardLimiteGastos";

import api from "../api";

function LimiteGastos() {
  const [cards, setCards] = useState([]);
  useEffect(() => {
    api.get("/limities/").then((resposta) => {
      setCards(resposta.data);
      console.log(resposta.data);
    });
  }, []);

  return (
    <>
      <NavBar />
      <Card ano={2022} />
      <Footer />
    </>
  );
}

export default LimiteGastos;
