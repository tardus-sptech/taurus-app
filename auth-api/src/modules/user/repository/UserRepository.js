import User from "../model/User";

class UserRepository {

  async findByEmail(email) {
    try {
      return await User.findOne({ where: email });
    } catch (err) {
      console.error(err.message);
      return null;
    }
  }
}

export default new UserRepository();