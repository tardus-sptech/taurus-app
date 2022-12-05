import React, { useState } from "react";
import { Box, FormControl, InputLabel, MenuItem, Select, TextField, Grid } from "@mui/material";
import { useNavigate } from "react-router-dom";
import { useEffect } from "react";
import api from "../api";



function FormLimite({ handleAdd, transactionsList, setTransactionsList }) {


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

  const [value, setValue] = useState("");
  const [categoria, setCategoryId] = useState("");
  const [userId, setCuserId] = useState("");


  const cb = document.querySelector('#eutestando');

  let idUsuario = sessionStorage.getItem('id');

  useEffect(() => {
    console.log("RESUMO DOS TRANSACAO: ")
    console.log("value: ", value)
    console.log("categoryId: ", categoria)


  }, [value, categoria, userId]);



  const adicionarLimite = async (e) => {


    const novoLimite = {
      categorySpent: value,
      categoryId: categoria,
      userId: idUsuario,

    }

      try {
        if (value <= 0) {
          window.alert('O valor precisa ser positivo!');
          return false;
        }

        const response = await api.post("/limities/", novoLimite, 
            {
              headers: {
                  'Content-Type': 'application/json'
              }
            }
        )
        console.log(response?.data);
      } catch (error) {
        console.error(error);
        window.alert('Erro ao tentar realizar o cadastro');
        return false;
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
    <><form onSubmit={adicionarLimite}>
      <h2 className="title-modal">Cadastrar Limite</h2>
      <Grid container spacing={1.6}>
        <Grid item md={12}>
          <TextField
            fullWidth
            className="ipt-formLancamento"
            label="Valor de Limite"
            name="ipt_valor"
            id="ipt-formLancamento"
            variant="outlined"
            value={value}
            required
            type="number"
            onChange={(e) => setValue(e.target.value)}>
          </TextField>
        </Grid>

        <Grid item md={12}>
          <FormControl fullWidth>
            <InputLabel id="demo-simple-select-label">Categoria</InputLabel>
            <Select
              labelId="demo-simple-select-label"
              id="demo-simple-select"
              value={categoria}
              label="Categoria"
              required
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
          <button className="btn-adicionar">ADICIONAR</button>
        </Grid>
      </Grid>
    </form>
    </>
  );
};

export default FormLimite;
