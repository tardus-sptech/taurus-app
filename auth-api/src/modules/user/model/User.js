import Sequelize from "sequelize";

import sequelize from "../../../config/db/dbConfig.js";

const User = sequelize.define(
  "user",
  {
    id: {
			type: Sequelize.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},
    name: {
			type: Sequelize.STRING,
			allowNull: false
		},
    cpf: {
			type: Sequelize.STRING,
			allowNull: false
		},
    birthDate: {
			type: Sequelize.DATE,
			allowNull: false
		},
    email: {
			type: Sequelize.STRING,
			allowNull: false
		},
    password: {
			type: Sequelize.STRING,
			allowNull: false
		},
  },
  {}
);

export default User;