import React, { useState } from "react";
import { Box, FormControl, InputLabel, MenuItem, Select, TextField, Grid } from "@mui/material";
import { useNavigate } from "react-router-dom";
import { useEffect } from "react";
import api from "../api";



function Form({ handleAdd, transactionsList, setTransactionsList }) {


  const [desc, setDesc] = useState("");
  const [amount, setAmount] = useState("");
  const [isExpense, setExpense] = useState(false);




  const generateID = () => Math.round(Math.random() * 1000);

  const handleSave = () => {
    if (!desc || !amount) {
      alert("Informe a descrição e o valor!");
      return;
    } else if (amount < 1) {
      alert("O valor tem que ser positivo!");
      return;
    }

    const transaction = {
      id: generateID(),
      desc: desc,
      amount: amount,
      expense: isExpense,
    };

    handleAdd(transaction);

    setDesc("");
    setAmount("");
  };



  const navigate = useNavigate();

  const [name, setName] = useState("");
  const [value, setValue] = useState("");
  const [categoria, setCategoryId] = useState("");
  const [userId, setCuserId] = useState("");

  const cb = document.querySelector('#eutestando');
  let idUsuario = sessionStorage.getItem('id');

  useEffect(() => {
    console.log("RESUMO DOS TRANSACAO: ")
    console.log("name: ", name)
    console.log("value: ", value)
    console.log("categoryId: ", categoria)


  }, [name, value, categoria, userId]);


  function adicionarTransacao2(evento) {
    const novaTransacao = {

      name: name,
      value: value  ,
      categoryId: categoria,
      userId: idUsuario,
    }

    if(cb.checked){
      api.post("/spenties/", novaTransacao, {
        headers: {
          'Content-Type': 'application/json'
        }
      }).then((resposta) => {
        console.log(resposta.status)
      })
    }else{
      api.post("/gains/", novaTransacao, {
        headers: {
          'Content-Type': 'application/json'
        }
      }).then((resposta) => {
        console.log(resposta.status)
      })
    }
  
  }


  const [category, setCategory] = useState([]);
  useEffect(() => {
    api.get("/categories/").then((resposta) => {
      setCategory(resposta.data);
      console.log(resposta.data);
    })
  }, [])

 


  return (
    <>
    <h2 className="title-modal">Cadastrar transação</h2>
      <Grid container spacing={1.6}>

        <Grid item md={12}>
          <TextField
            fullWidth
            label="Descrição"
            className="ipt-formLancamento"
            name="ipt_titulo"
            value={name}
            onChange={(e) => setName(e.target.value)}>
          </TextField>
        </Grid>
        <Grid item md={12}>
          <TextField
            fullWidth
            className="ipt-formLancamento"
            label="Valor"
            name="ipt_valor"
            id="ipt-formLancamento"
            variant="outlined"
            value={value}
            type="number"
            onChange={(e) => setValue(e.target.value)}>
          </TextField>
        </Grid>

        <Grid item md={12}>
          <FormControl fullWidth>
            <InputLabel id="demo-simple-select-label">Categoria</InputLabel>
            <Select
              className="combo-form"
              id="outlined-select-currency-native testere"
              label="Categoria"
              value={categoria}
              onChange={(e) => setCategoryId(e.target.value)}
              
            >
              {category.map((option) => (
                <MenuItem key={option.id} value={option.id}>
                  {option.description}
                </MenuItem>
              ))}
            </Select>
          </FormControl>
        </Grid>
        <Grid item md={12}>
          <div className="button r" id="button-1">
            <input type="checkbox" id="eutestando" className="checkbox" />
            <div className="knobs"></div>
            <div className="layer"></div>
          </div>
        </Grid>
        <Grid item md={12}>
        <button className="btn-adicionar" onClick={adicionarTransacao2}>ADICIONAR</button>
      </Grid>
    </Grid>
    </>
  );
};

export default Form;
