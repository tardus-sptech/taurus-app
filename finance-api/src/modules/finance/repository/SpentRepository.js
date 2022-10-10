import Spent from '../model/Spent.js'

class SpentRepository {
    async save(spent) {
        try {
            return await Spent.create(spent);
        } catch (error) {
            console.error(error.message);
            return null;
        }
    }
    async findById(id) {
        try {
            return await Spent.findById(id);
        } catch (error) {
            console.error(error.message);
            return null;
        }
    }
    async findAll() {
        try {
            return await Spent.find();
        } catch (error) {
            console.error(error.message);
            return null;
        }
    }
    async findBySpentId() {
        try {
            return await Spent.find({ "spenties.spentId": Number(spentId) });
        } catch (error) {
            console.error(error.message);
            return null;
        }
    }
}

export default new SpentRepository();