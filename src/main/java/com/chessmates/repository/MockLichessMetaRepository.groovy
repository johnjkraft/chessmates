package com.chessmates.repository

import com.google.common.collect.ImmutableMap
import org.apache.commons.lang3.tuple.ImmutablePair
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository

/**
 * Repository that simply logs instead of writing to a DB.
 */
@Repository
class MockLichessMetaRepository implements MetaDataRepository {
    Logger logger = LoggerFactory.getLogger(MockLichessMetaRepository)

    private latestPlayer
    private Map latestGamesForPlayers = new HashMap()

    void saveLatestPlayer(player) {
        logger.debug "(Mock) Saving player ${player}"
        latestPlayer = player
    }

    def getLatestPlayer() {
        logger.debug "(Mock) Fetching latest player"
        latestPlayer
    }

    void saveLatestGame(player, opponent, game) {
        logger.debug "(Mock) Saving latest game: ${game} for player: ${player} opponent: ${opponent}"
        latestGamesForPlayers.put(new ImmutablePair(player, opponent), game)
    }

    ImmutableMap<ImmutablePair, Object> getLatestGames() {
        logger.debug "(Mock) Fetching latest games"
        ImmutableMap.builder()
            .putAll(latestGamesForPlayers)
            .build()
    }

}
