import BarraLimite from "./BarraLimite";
import api from "../api";
import { useEffect, useState } from "react";
import ModalLimite from "./ModalLimite";

function CardLimiteGastos(props) {
  const id = sessionStorage.getItem("id");
  const [bars, setBars] = useState([]);
  useEffect(() => {
    api.get(`/limities/user/${id}`).then((resposta) => {
      setBars(resposta.data);
      console.log(resposta.data);
    });
  }, []);

  return (
    <>
      <div className="corFundo">
        <div className="size-limite">
          <div className="card-limite">
            <div className="limite-boxes">
              <div className="box-limite">
                <div className="titulo-limite">
                  <h3>Limite de Gastos</h3>
                  <h4>
                    {props.mes} {props.ano}
                  </h4>
                  <ModalLimite />
                </div>
                <div className="limites">
                  {bars.map((item) => (
                    <BarraLimite
                      categoria={item.category.description}
                      gasto={item.categorySpent}
                      total={200}
                    />
                  ))}
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default CardLimiteGastos;
