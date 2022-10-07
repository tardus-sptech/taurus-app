import SpentRepository from "../repository/SpentRepository.js";
import { sendMessageToSpentValueUpdateQueue } from '../../spent/rabbitmq/spentUpdateValueSender.js'
import { CREATED, PENDING, REJECTED } from '../status/SpentStatus.js'
import SpentException from '../exception/SpentException.js'
import { BAD_REQUEST, SUCCESS } from '../../../config/constants/httpStatus.js'

class SpentService {
    async createSpent(req) {
        try {
            let spentData = req.body;
            this.validateSpentData(spentData);
            const { authUser } = req;
            let spent = this.createInitialSpentData(spentData, authUser);
            let createdSpent = await SpentRepository.save(spent);
            this.sendMessage(createdSpent);
            req.status = SUCCESS;
            return {
                createdSpent
            };
        } catch (err) {
            const status = err.status ? err.status : httpStatus.INTERNAL_SERVER_ERROR;
            req.status = BAD_REQUEST;
            return {
              message: err.message,
            };
        }
    }

    createInitialSpentData(spentData, authUser) {
        return {
          status: PENDING,
          user: authUser,
          createdAt: new Date(),
          updatedAt: new Date(),
          spenties: spentData.spenties,
        };
      }

    async findById(req) {
        try {
            const { id } = req.params;
            this.validateInformedId(id);
            const existingSpent = await SpentRepository.findById(id);
            if (!existingSpent) {
                throw new SpentException(BAD_REQUEST, "The spent was not found.")
            }
            req.status = SUCCESS;
            return {
                existingSpent
            };
        } catch (err) {
            const status = err.status ? err.status : httpStatus.INTERNAL_SERVER_ERROR;
            req.status = BAD_REQUEST;
            return {
              message: err.message,
            };
        }
    }

    validateInformedId(id) {
        if (!id) {
            throw new SpentException(BAD_REQUEST, 'The spent ID must be informed.')
        }
    }

    sendMessage(createdSpent) {
        const message = {
            spentiesId: createdSpent.id,
            spenties: createdSpent.spenties
        };
        sendMessageToSpentValueUpdateQueue(message);
    }
    async updateSpent(spentMessage) {
        try {
            const spent = JSON.parse(spentMessage);
            if (!spent.spentId && !spent.status) {
                let existingSpent = await SpentRepository.findById(spent.spentiesId);
                if (existingSpent && spent.status !== existingSpent.status) {
                    existingSpent.status = spent.status;
                    await SpentRepository.save(existingSpent);
                }
            } else {
                console.warn('The spent message was not complete.')
            }

        } catch (err) {
            console.error("Could not parse spent message from queue.");
            console.error(err.message)
        }
    }

    validateSpentData(data) {
        if (!data || !data.spenties) {
            throw new SpentException(BAD_REQUEST ,"The spenties must be informed.")
        }
    }
}

export default new SpentService();