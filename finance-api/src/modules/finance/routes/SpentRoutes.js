import { Router } from "express";
import SpentController from "../controller/SpentController.js";

const router = new Router();

router.post("/api/finance/spenties", SpentController.createSpent)
router.get("/api/finance/spenties/:id", SpentController.findById)
router.get("/api/finance/spenties", SpentController.findAll)

export default router;