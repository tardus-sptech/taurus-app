import { TextField } from "@mui/material";
import React from "react";
import { useNavigate } from "react-router-dom";
import Footer from "../Components/Footer";
import NavBar from "../Components/NavBar";

function VisualizarUsuario() {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');

  const USER_URL = '/users';
  const idUser = sessionStorage.getItem('id');

  useEffect( () => {userData()}, []);

  const userData = async (e) => {
      try {
          const response = await api.get(`${USER_URL}/${idUser}`);
          setName(response.data.name);
          setEmail(response.data.email);
      } catch (error) {
          console.error(error);
      }
  }

  return (
    <>
      <NavBar />
      <main id="user-content">
        <div id="user-container">
          <TextField disabled label="Nome">
            {name}
          </TextField>
          <TextField disabled label="Email">
            {email}
          </TextField>
        </div>
      </main>
      <Footer />
    </>
  );
}

export default VisualizarUsuario;
