import express from "express";
import { createInitialData } from "./src/config/db/initialData.js";
import userRoutes from './src/modules/user/routes/UserRoute.js'
import checkToken from "./src/config/auth/checkToken.js";

const app = express();
const env = process.env;
const PORT = env.PORT || 8080;

createInitialData();

app.use(express.json());
app.use(userRoutes);
app.use(checkToken);

app.get("/api/status", (req, res) => {
  return res.status(200).json({
    service: "Auth-API",
    status: "UP",
    httpStatus: "200",
  });
});

app.listen(PORT, () => {
  console.info(`Server started sucessfully at port ${PORT}`);
});
