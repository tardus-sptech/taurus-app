import express from 'express';
import { createInitialData } from './src/config/db/initialData.js';
import { connect } from './src/config/db/mongoDbConfig.js';
import checkToken from './src/config/auth/checkToken.js';
import { connectRabbitMq } from './src/config/rabbitmq/rabbitConfig.js';

const app = express();
const env = process.env;
const PORT = env.PORT || 8082;

connect();
createInitialData();
connectRabbitMq();

// app.use(checkToken);

app.get('/api/status', async (req, res) => {
    return res.status(200).json({
        service: 'Sales-API',
        status: "UP"
    });
});

app.listen(PORT, () => {
    console.info(`Server started successfully at port ${PORT}`);
})