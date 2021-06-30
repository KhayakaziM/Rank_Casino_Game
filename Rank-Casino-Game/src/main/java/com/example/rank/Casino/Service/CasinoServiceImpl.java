package com.example.rank.Casino.Service;

import com.example.rank.Casino.Entity.GameEntity;
import com.example.rank.Casino.Entity.PlayerEntity;
import com.example.rank.Casino.Entity.TransactionEntity;
import com.example.rank.Casino.ExceptionHandlers.ResourceNotFoundException;
import com.example.rank.Casino.Model.GameModel;
import com.example.rank.Casino.Model.PlayerBalance;
import com.example.rank.Casino.Model.PlayerModel;
import com.example.rank.Casino.Model.Score;
import com.example.rank.Casino.Repository.GameRepository;
import com.example.rank.Casino.Repository.PlayerRepository;
import com.example.rank.Casino.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CasinoServiceImpl implements CasinoService{

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public GameEntity addNewGame(GameModel gameModel) {
        GameEntity gameEntity=new GameEntity();
        gameEntity.setGameDesc(gameModel.getGameDesc());
        gameEntity.setGameType(gameModel.getGameType());
        gameEntity.setGameName(gameModel.getGameName());
        return gameRepository.save(gameEntity);
    }
    private final int initialPoints=10;

    @Override
    public PlayerEntity addPlayer(PlayerModel playerModel) {

        PlayerEntity playerEntity=new PlayerEntity();
        playerEntity.setFinalAmount(initialPoints);
        playerEntity.setPlayer_usersurname(playerModel.getPlayer_usersurname());
        playerEntity.setPlayer_username(playerModel.getPlayer_username());
        return playerRepository.save(playerEntity);
    }

    @Override
    public List<TransactionEntity> getAllTransactionEntity() {
        return this.transactionRepository.findAll();
    }
// get balance amount and
    @Override
    public TransactionEntity getTransactioById(long transactionId) {

        Optional<TransactionEntity> rankDb = this.transactionRepository.findById(transactionId);

        if(rankDb.isPresent()) {
            PlayerBalance playerBalance=new PlayerBalance();
            playerBalance.setBalance(rankDb.get().getAmount());
            playerBalance.setPlayer_Id(rankDb.get().getPlayer_Id());
            return rankDb.get();
        }else {
            throw new ResourceNotFoundException("Record not found with id : " + transactionId);
        }
    }

    // get balance amount and
    @Override
    public PlayerBalance getPlayerBalance(long player_id) {
        Optional<PlayerEntity> rankDb = this.playerRepository.findById(player_id);
        if(rankDb.isPresent()) {
            PlayerBalance playerBalance=new PlayerBalance();
            playerBalance.setBalance(rankDb.get().getFinalAmount());
            playerBalance.setPlayer_Id(rankDb.get().getPlayer_Id());
            return playerBalance;
        }else {
            throw new ResourceNotFoundException("player does not exist : " + player_id);
        }
    }

    @Override
    public TransactionEntity addPointScore(Score score) {
        Optional<TransactionEntity> rankDb = this.transactionRepository.findById(score.getPlayer_Id());

        Optional<PlayerEntity> playerDb = this.playerRepository.findById(score.getPlayer_Id());
        Optional<GameEntity> gameDb = this.gameRepository.findById(score.getGame_Id());
        if(gameDb.isPresent()) {
            if (playerDb.isPresent()) {
                TransactionEntity transactionEntity = new TransactionEntity();
                int addPoints=0;
                if(score.getPoints()!=0){
                    addPoints=Integer.valueOf(score.getPoints());
                    addPoints+=playerDb.get().getFinalAmount();
                    transactionEntity.setAmount_def(score.getPoints());
                    transactionEntity.setAmount(addPoints);

                }else{
                    throw new ResourceNotFoundException("score points amount required");
                }
                PlayerEntity playerEntityUpdate=playerDb.get();
                playerEntityUpdate.setFinalAmount(addPoints);
                transactionEntity.setPlayer_Id(score.getPlayer_Id());
                transactionEntity.setGame_Id(score.getGame_Id());
                transactionEntity.setTrans_desc(score.getScore_description());

                playerRepository.save(playerEntityUpdate);
                transactionRepository.save(transactionEntity);
                return transactionEntity;
            } else {
                throw new ResourceNotFoundException("Record not found with player ID : " + score.getPlayer_Id());
            }
        }else{
            throw new ResourceNotFoundException("Record not found with game  ID : " + score.getGame_Id());
        }
    }

    @Override
    public TransactionEntity deductPointScore(Score score) {

        Optional<PlayerEntity> playerDb = this.playerRepository.findById(score.getPlayer_Id());
        Optional<GameEntity> gameDb = this.gameRepository.findById(score.getGame_Id());
        if(gameDb.isPresent()) {
            if (playerDb.isPresent()) {
                TransactionEntity transactionEntity = new TransactionEntity();
                int addPoints=0;
                if(score.getPoints()!=0){
                    if(score.getPoints()<playerDb.get().getFinalAmount()){
                        addPoints = playerDb.get().getFinalAmount() - Integer.valueOf(score.getPoints());
                        transactionEntity.setAmount_def(score.getPoints());
                        transactionEntity.setAmount(addPoints);
                    }else{
                        throw new ResourceNotFoundException("Player has insufficient points : " + playerDb.get().getFinalAmount());
                    }
                }else{
                    throw new ResourceNotFoundException("score points amount required");
                }
                PlayerEntity playerEntityUpdate=playerDb.get();
                playerEntityUpdate.setFinalAmount(addPoints);
                transactionEntity.setPlayer_Id(score.getPlayer_Id());
                transactionEntity.setGame_Id(score.getGame_Id());
                transactionEntity.setTrans_desc(score.getScore_description());


                playerRepository.save(playerEntityUpdate);
                transactionRepository.save(transactionEntity);
                return transactionEntity;
            } else {
                throw new ResourceNotFoundException("Record not found with player ID : " + score.getPlayer_Id());
            }
        }else{
            throw new ResourceNotFoundException("Record not found with game  ID : " + score.getGame_Id());
        }
    }
}
