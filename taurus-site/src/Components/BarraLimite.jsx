import Faca from "../assets/faca.png";
import Casa from "../assets/casa.png";

function BarraLimite(props){
    return(
        <>
             <div className="preco" >
                <img className="facaimg" src={Casa} alt="" />
                <div className="titulo-pergunta">{props.categoria}</div>
                <span className="titulo-resposta">{props.gasto} de {props.total}</span>
                </div>
            <div className="barra">
                <div className="barra-vazia">
                <div className="barra-gasto" 
                style={{background:"red", height:"10px", width:`${props.gasto*100/props.total}%`}}>
            </div>
                </div>
            </div>
        </>
    )
}

export default BarraLimite;