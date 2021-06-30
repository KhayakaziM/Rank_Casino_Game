package com.example.rank.Casino.Controller;

import com.example.rank.Casino.Entity.GameEntity;
import com.example.rank.Casino.Entity.PlayerEntity;
import com.example.rank.Casino.Entity.TransactionEntity;
import com.example.rank.Casino.Model.GameModel;
import com.example.rank.Casino.Model.PlayerBalance;
import com.example.rank.Casino.Model.PlayerModel;
import com.example.rank.Casino.Model.Score;
import com.example.rank.Casino.Service.CasinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CasinoController {
    @Autowired
    private CasinoService casinoService;

    @PostMapping("/casino/new-game")
    public ResponseEntity<GameEntity> addNewGame(@RequestBody GameModel gameModel ){
        return ResponseEntity.ok().body(this.casinoService.addNewGame(gameModel));
    }
    @PostMapping("/casino/add-player")
    public ResponseEntity<PlayerEntity> addPlayer(@RequestBody PlayerModel playerModel){
        return ResponseEntity.ok().body(this.casinoService.addPlayer(playerModel));
    }

    @GetMapping("/casino/player/{player-id}")
    public ResponseEntity<PlayerBalance> getPlayerBalance(@PathVariable long player_id){
        return ResponseEntity.ok().body(casinoService.getPlayerBalance(player_id));
    }


    @PostMapping("/casino/player-won")
    public ResponseEntity<TransactionEntity> addPointScore(@RequestBody Score score){
        return ResponseEntity.ok().body(this.casinoService.addPointScore(score));
    }

    @PostMapping("/casino/player_loose")
    public ResponseEntity<TransactionEntity> deductPointScore(@RequestBody Score score){
        return ResponseEntity.ok().body(this.casinoService.deductPointScore(score));
    }

    @GetMapping("/casino")
    public ResponseEntity<List<TransactionEntity>> getAllTransactionEntity(){
        return ResponseEntity.ok().body(casinoService.getAllTransactionEntity());
    }
}
