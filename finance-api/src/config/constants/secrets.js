const env = process.env;

export const API_SECRET = env.API_SECRET 
? env.API_SECRET 
: "YXV0aC1hcGktc2VjcmV0LWRldi10YXVydXM=";

export const MONGO_DB_URL = env.MONGO_DB_URL 
? env.MONGO_DB_URL 
: "mongodb://admin:root@localhost:27017";

export const RABBIT_MQ_URL = env.RABBIT_MQ_URL 
? env.RABBIT_MQ_URL 
: "amqp://localhost:5672";