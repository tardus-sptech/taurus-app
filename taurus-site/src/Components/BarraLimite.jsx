import Faca from "../assets/faca.png";
import Casa from "../assets/casa.png";
import api from "../api";
import { useEffect, useState } from "react";



function BarraLimite(props) {

    const [gasto, setGasto] = useState([]);

    const id = sessionStorage.getItem("id");
    useEffect(() => {
        api.get(`/spenties/user/sum/${props.idCategoria}/${id}`).then((resposta) => {
            setGasto(resposta.data);
            console.log(resposta.data);
        })
    }, []);


    return (
        <>
            <div className="div-limite">
                <div className="preco" >
                    <div className="titulo-pergunta">{props.categoria}</div>
                    <span className="titulo-resposta">R$ {Number(gasto).toFixed(2)} de {Number(props.total).toFixed(2)}</span>
                </div>
                <div className="barra">
                    <div className="barra-vazia" style={{ borderRadius: "30px" }}>
                        <div className="barra-gasto"
                            style={{ background: "#8e3be1", borderRadius: "30px", height: "100%", width: `${gasto * 100 / props.total}%` }}>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}

export default BarraLimite;