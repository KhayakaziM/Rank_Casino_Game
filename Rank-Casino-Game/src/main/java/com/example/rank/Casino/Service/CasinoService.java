package com.example.rank.Casino.Service;

import com.example.rank.Casino.Entity.GameEntity;
import com.example.rank.Casino.Entity.PlayerEntity;
import com.example.rank.Casino.Entity.TransactionEntity;
import com.example.rank.Casino.Model.GameModel;
import com.example.rank.Casino.Model.PlayerBalance;
import com.example.rank.Casino.Model.PlayerModel;
import com.example.rank.Casino.Model.Score;

import java.util.List;

public interface CasinoService {

// add game,player and transactions
    GameEntity addNewGame(GameModel gameModel);
    PlayerEntity addPlayer(PlayerModel playerModel);
    TransactionEntity addPointScore(Score score);
    TransactionEntity deductPointScore(Score score);
//player current balance
    PlayerBalance getPlayerBalance(long player_id);
    List<TransactionEntity> getAllTransactionEntity();

    TransactionEntity getTransactioById(long transactionId);
}

