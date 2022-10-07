import { Router } from "express";
import SpentController from "../controller/SpentController.js";

const router = new Router();

router.post("/api/finance/spent/create", SpentController.createSpent)
router.get("/api/finance/spent/:id", SpentController.findById)

export default router;