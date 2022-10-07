import SpentService from "../service/SpentService.js";

class SpentController {
    async createSpent(req, res) {
        let spent = await SpentService.createSpent(req)
        return res.status(req.status).json(spent)
    }
    async findById(req, res) {
        let spent = await SpentService.findById(req)
        return res.status(req.status).json(spent)
    }
}

export default new SpentController();