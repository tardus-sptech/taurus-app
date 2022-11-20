import React, { useState } from "react";
const Form = ({ handleAdd, transactionsList, setTransactionsList }) => {
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

  return (
    <>
      <container className="container-form">
        <inputContent>
          
          <input className="ipt-formLancamento" placeholder="Titulo" value={desc} onChange={(e) => setDesc(e.target.value)} />
        </inputContent>
        <inputContent>
          
          <input 
            className="ipt-formLancamento"
            placeholder="Valor"
            value={amount}
            type="number"
            onChange={(e) => setAmount(e.target.value)}
          />
        </inputContent>
        <radioGroup>
          <input className="ipt-formLancamento"
            type="radio"
            id="rIncome"
            defaultChecked
            name="group1"
            onChange={() => setExpense(!isExpense)}
          />
          <input
            type="radio"
            id="rExpenses"
            name="group1"
            onChange={() => setExpense(!isExpense)}
          />
        </radioGroup>
        <inputContent>
          
          <input value={desc} onChange={(e) => setDesc(e.target.value)} />
        </inputContent>
        <button onClick={handleSave}>ADICIONAR</button>
      </container>
    </>
  );
};

export default Form;
