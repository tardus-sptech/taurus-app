import BarraLimite from "./BarraLimite";
import api from "../api";
import { useEffect, useState } from "react";

function CardLimiteGastos(props){
    
    const [bars, setBars] = useState([]);
        useEffect(() => {
          api.get("/").then((resposta) => {

          setBars([
            {
                categoria:"Alimentação",
                gasto:"200",
                total:"400"
            },
            {
                categoria:"Casa",
                gasto:"230",
                total:"300"
            },
            {
                categoria:"Lazer",
                gasto:"20",
                total:"100"
            }
          ]);
          })
        }, [])

    return(
        <>
              <div className="corFundo">
        <div className="size-limite">
          <div className="card-limite">
            <div className="limite-boxes">
              <div className="box-limite">
                <div className="titulo-limite">
                  <h3>Limite de Gastos</h3>
                  <h4>{props.mes} {props.ano}</h4>
                </div>
                <div className="limites">
                {bars.map((item) => (
                    <BarraLimite
                    categoria={item.categoria}
                    gasto={item.gasto}
                        total={item.total}
                    />
                    ))}
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
        </>
    )
}

export default CardLimiteGastos;