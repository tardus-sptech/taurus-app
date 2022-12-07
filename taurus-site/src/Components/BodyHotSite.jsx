import React, { useState } from "react";
import "../style/bodyHotSite.css";
import axios from "axios";
import FileDownload from "js-file-download";

function HotSite(props) {
  const [fileExport, setFileExport] = useState();

  function sendTxt() {
    console.log(fileExport)
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
          setFileExport(null);
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

      <div className="box-file">
        <div className="bodyFather">
          <div class="upload">
            <div class="upload__inner">
              <label for="upload-voorbereiding" class="upload__label">{fileExport == null ? "Clique ou arraste para inserir" : fileExport.name}
              <input id="gol" type="file" class="upload__input" onChange={(e) => setFileExport(e.target.files[0])}/>
              </label>
            </div>
          </div>
          <div className="buttons-file">
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
        </div>
      </div>
    </>
  );
}

export default HotSite;
