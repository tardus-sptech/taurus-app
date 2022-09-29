import bcrypt from "bcrypt";
import User from '../../modules/user/model/User.js';

export async function createInitialData() {
  try {
    await User.sync({ force: true });

    let password = await bcrypt.hash("123456", 10);
  
    await User.create({
      name: 'Renan Oliveira',
      cpf: '42048248298', 
      birthDate: Date.now(),
      email: 'renan.oliveira@taurus.com',
      password: password,
    });
  } catch(err) {
    console.log(err)
  }
}