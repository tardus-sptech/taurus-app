import React, { useState } from "react";
import "../style/bodyHotSite.css";
import axios from "axios";
import FileDownload from "js-file-download";

function HotSite(props) {
  const [fileExport, setFileExport] = useState();

  function sendTxt() {
    axios({
      method: "post",
      url: `http://localhost:8081/api/spenties/user/file-txt`,
      headers: {
        "Content-Type": "text/form-data",
      },
      data: fileExport,
    })
      .then((res) => {
        if (res.status === 201) {
          alert("Item registrado na fila com sucesso!");
        }
      })
      .catch((err) => {
        console.error(err);
      });
  }

  function saveTxt() {
    axios({
      method: "post",
      url: `http://localhost:8081/api/spenties/user/file-txt/save`,
    })
      .then((res) => {
        alert(res.data);
      })
      .catch((err) => {
        console.error(err);
      });
  }

  function downloadTxt() {
    axios({
      method: "get",
      url: `http://localhost:8081/api/spenties/user/file-txt/${sessionStorage.getItem(
        "id"
      )}`,
      responseType: "blob", // Important,
    })
      .then((res) => {
        if (res.status === 200) {
          FileDownload(res.data, "relatorio.txt");
        }
      })
      .catch((err) => {
        console.error(err);
        alert("deu chabu");
      });
  }

  return (
    <>
      <div className="bodyFather">
        <label className="testeIpt">
          <input
            type="file"
            onChange={(e) => setFileExport(e.target.files[0])}
          />
        </label>
        <button className="btn-adicionar" onClick={() => sendTxt()}>
          Enviar
        </button>
        <button className="btn-adicionar" onClick={() => saveTxt()}>
          Salvar
        </button>
        <button className="btn-adicionar" onClick={() => downloadTxt()}>
          Importar relatórios
        </button>
      </div>
    </>
  );
}

export default HotSite;
