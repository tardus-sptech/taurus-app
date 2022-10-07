import Spent from "../../modules/finance/model/Spent.js";

export async function createInitialData() {
    await Spent.collection.drop();
    let firstSpent =  await Spent.create({
        spenties: [
            {
                spentId: 1001,
                value: 3200
            },
            {
                spentId: 1002,
                value: 4200
            },
            {
                spentId: 1003,
                value: 5200
            },
        ],
        user: {
            id: "ad8asd8ad8a9das9ad99",
            name: "User test1",
            email: "usertest@gmail.com"
        },
        status: 'CREATED',
        createdAt: new Date(),
        updatedAt: new Date()
    });
    let initialData = await Spent.find()
    console.info(`Initial data was created ${JSON.stringify(initialData, undefined, 4)}`)
}