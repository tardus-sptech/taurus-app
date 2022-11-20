import React, { useState } from "react";
import { Box, FormControl, InputLabel, MenuItem, Select, TextField, Grid } from "@mui/material";
import { useNavigate } from "react-router-dom";
import { useEffect } from "react";
import api from "../api";




const currencies = [
  {
    value: 'USD',
    label: '$',
  },
  {
    value: 'EUR',
    label: '€',
  },
  {
    value: 'BTC',
    label: '฿',
  },
  {
    value: 'JPY',
    label: '¥',
  },
];

function Form({ handleAdd, transactionsList, setTransactionsList }) {


  const [desc, setDesc] = useState("");
  const [amount, setAmount] = useState("");
  const [isExpense, setExpense] = useState(false);

  const [currency, setCurrency] = React.useState('EUR');




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

  const [teste, setTeste] = useState("");


  const navigate = useNavigate();

  const [name, setName] = useState("");
  const [value, setValue] = useState("");
  const [categoria, setCategoryId] = useState("");
  const [userId, setCuserId] = useState("");




  useEffect(() => {
    console.log("RESUMO DOS ESTADOS: ")
    console.log("name: ", name)
    console.log("value: ", value)
    console.log("categoryId: ", categoria)
    console.log("Teste: ", teste)


  }, [name, value, categoria, userId]);


  function adicionarTransacao2(evento) {
    const novaTransacao = {

      name: name,
      value: value,
      categoryId: categoria,
      userId: 1,
    }

    api.post("/spenties/", novaTransacao, {
      headers: {
        'Content-Type': 'application/json'
      }
    }).then((resposta) => {
      console.log(resposta.status)
    })
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
              SelectProps={{
                native: true,

              }}
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
          <div class="button r" id="button-1">
            <input type="checkbox" class="checkbox" value={teste} onChange={(e) => setTeste(e.target.value)} />
            <div class="knobs"></div>
            <div class="layer"></div>
          </div>
        </Grid>
        <Grid item md={12}>
        <button className="btn-adicionar" onClick={adicionarTransacao2} >ADICIONAR</button>
      </Grid>
    </Grid>
    </>
  );
};

export default Form;
