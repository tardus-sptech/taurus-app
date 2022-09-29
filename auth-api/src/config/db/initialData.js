import bcrypt from "bcrypt";
import User from '../../modules/user/model/User.js';
import moment from 'moment'
import sequelize from "./dbConfig.js";
import pg from 'pg';

export async function createInitialData() {
  try {
    await User.sync({ force: true });

    let password = await bcrypt.hash("123456", 10);
    const start = '2018-06-10T21:00:00-04:00';
const end = '2018-06-10T23:00:00-04:00';
const noconversion = moment.utc(start).format('MM/DD/YYYY');
const converted = moment(end).format('MM/DD/YYYY');
    await User.create({
      name: 'Renan Oliveira',
      cpf: '42048248298', 
      birthDate: converted,
      email: 'renan.oliveira@taurus.com',
      password: password,
    });

    await User.create({
      name: 'Pedro Henrique',
      cpf: '22048248291', 
      birthDate: '2021-09-07',
      email: 'pedro.henrique@taurus.com',
      password: password,
    });

  } catch(err) {
    console.log(err)
  }
}