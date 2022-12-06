import BarraLimite from "./BarraLimite";
import api from "../api";
import { useEffect, useState } from "react";
import ModalLimite from "./ModalLimite";

function CardLimiteGastos(props) {
  const id = sessionStorage.getItem("id");

  const teste = 0;

  const [bars, setBars] = useState([]);
  const [teste1, setTeste] = useState([]);
  useEffect(() => {
    api.get(`/limities/user/${id}`).then((resposta) => {
      setBars(resposta.data);
      console.log(resposta.data);
    });
  }, []);
  

  return (
    <>
        <div className="size-limite">
          <div className="card-limite">
            <div className="limite-boxes">
              <div className="box-limite">
                <div className="titulo-limite">
                  Limite de Gastos
                  <ModalLimite />
                </div>
                <div className="limites">
                  {bars.map((item) => (
                    <BarraLimite
                      categoria={item.category.description}
                      idCategoria={item.category.id}
                      total={item.categorySpent}
                    />
                  ))}
                </div>
              </div>
            </div>
          </div>
        </div>
    </>
  );
}

export default CardLimiteGastos;
