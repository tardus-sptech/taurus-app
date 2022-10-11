import express from 'express';
import { createInitialData } from './src/config/db/initialData.js';
import { connectMongoDb } from './src/config/db/mongoDbConfig.js';
import checkToken from './src/config/auth/checkToken.js';
import { connectRabbitMq } from './src/config/rabbitmq/rabbitConfig.js';
import spentRoutes from './src/modules/finance/routes/SpentRoutes.js';

const app = express();
const env = process.env;
const PORT = env.PORT || 8082;
const CONTAINER_ENV = "container";
const THREE_MINUTES = 180000;

startApplication();

async function startApplication() {
    if (CONTAINER_ENV === env.NODE_ENV) {
        console.info("Waiting for RabbitMQ and MongoDB containers to start...")
        setInterval(() => {
            connectMongoDb();
            connectRabbitMq();
        }, THREE_MINUTES)
    } else {
        connectMongoDb();
        createInitialData();
        connectRabbitMq();
    }
}

app.use(express.json());

app.get("/api/initial-data", async (req, res) => {
    await createInitialData();
    return res.json({ message: "Data created." })
})

app.use(checkToken); 
app.use(spentRoutes);


app.get('/api/status', async (req, res) => {
    return res.status(200).json({
        service: 'Sales-API',
        status: "UP"
    });
});

app.listen(PORT, () => {
    console.info(`Server started successfully at port ${PORT}`);
})