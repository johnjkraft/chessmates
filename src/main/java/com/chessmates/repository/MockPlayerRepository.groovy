package com.chessmates.repository

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository

/**
 * Repository that simply logs instead of writing to a DB.
 */
@Repository
class MockPlayerRepository implements PlayerRepository {
    Logger logger = LoggerFactory.getLogger(MockPlayerRepository)

    private Map store = new HashMap()

    @Override
    void save(player) {
        logger.debug "(Mock) Saving player: ${player}"
        store.put(player.id, player)
    }

    @Override
    find(String playerId) {
        logger.debug "(Mock) Fetching player: ${playerId}"
        store.get(playerId)
    }

    @Override
    List findAll() {
        new ArrayList(store.values())
    }
}
