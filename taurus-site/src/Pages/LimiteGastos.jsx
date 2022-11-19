import React from "react";

import { useEffect, useState } from "react";
import NavBar from "../Components/NavBar";
import Footer from "../Components/Footer";
import Card from "../Components/CardLimiteGastos"
import Carousel from "../Components/Carousel";

import api from "../api";

function LimiteGastos() {

  const [cards, setCards] = useState([]);
  useEffect(() => {
          api.get("/").then((resposta) => {
          // setCards(resposta.data);
          setCards([
            {
              mes: "Janeiro",
              ano: "2022"
            },
            {
              mes: "Fevereiro",
              ano: "2022"
            },
            {
              mes: "Março",
              ano: "2022"
            }
          ]);
          })
        }, [])

  return (
    <>
      <NavBar />
      <Carousel
        card={
          cards.map((item) => (
            <Card
              mes={item.mes}
              ano={item.ano}
            />
        ))

      
      }
      >

      </Carousel>
      
      <Footer />
    </>
  );
}

export default LimiteGastos;
