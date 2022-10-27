package com.example._11_1_cluedosbmvc_datelist.logic;

import com.example._11_1_cluedosbmvc_datelist.logic.GameLogic;
import com.example._11_1_cluedosbmvc_datelist.models.classes.Crime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameLogicTest {

    Crime suggestion;
    Crime secret;
    GameLogic gameLogic;
    int numberOfSuggestions;
    int maxNumberOfSuggestions = 0;


    @BeforeEach
    private void setupBeforeEachTEst() {
        gameLogic = new GameLogic();
        suggestion = new Crime();
        secret = new Crime();
    }

    @Test
    void setupNewGame() {
    }

    @Test
    void ActorSuggestionEqualToSecretAndHistoryWon() {
        secret.setActor(0);
        secret.setWeapon(0);
        secret.setScene(0);

        suggestion.setActor(0);
        suggestion.setWeapon(0);
        suggestion.setScene(0);

        assertEquals(true, gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestions, maxNumberOfSuggestions));
        assertEquals("won", secret.getHistory().get(secret.getHistory().size() - 1));
    }

    @Test
    void ActorSuggestionNotEqualToSecret() {
        secret.setActor(1);
        secret.setWeapon(0);
        secret.setScene(0);

        suggestion.setActor(0);
        suggestion.setWeapon(0);
        suggestion.setScene(0);

        assertEquals(false, gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestions, maxNumberOfSuggestions));
    }

    @Test
    void ActorWeaponSceneNotEqualThenReturnFalseAndHistory0() {
        secret.setActor(1);
        secret.setWeapon(1);
        secret.setScene(1);

        suggestion.setActor(0);
        suggestion.setWeapon(0);
        suggestion.setScene(0);

        assertEquals(false, gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestions, maxNumberOfSuggestions));
        assertEquals("0", secret.getHistory().get(secret.getHistory().size() - 1));
    }

    @Test
    void ActorEqualWeaponSceneNotEqualThenReturnFalseAndHistory1() {
        secret.setActor(0);
        secret.setWeapon(1);
        secret.setScene(1);

        suggestion.setActor(0);
        suggestion.setWeapon(0);
        suggestion.setScene(0);

        assertEquals(false, gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestions, maxNumberOfSuggestions));
        assertEquals("1", secret.getHistory().get(secret.getHistory().size() - 1));
    }

    @Test
    void WeaponEqualActorSceneNotEqualThenReturnFalseAndHistory1() {
        secret.setActor(1);
        secret.setWeapon(0);
        secret.setScene(1);

        suggestion.setActor(0);
        suggestion.setWeapon(0);
        suggestion.setScene(0);

        assertEquals(false, gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestions, maxNumberOfSuggestions));
        assertEquals("1", secret.getHistory().get(secret.getHistory().size() - 1));
    }

    @Test
    void SceneEqualWeaponSceneNotEqualThenReturnFalseAndHistory1() {
        secret.setActor(1);
        secret.setWeapon(1);
        secret.setScene(0);

        suggestion.setActor(0);
        suggestion.setWeapon(0);
        suggestion.setScene(0);

        assertEquals(false, gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestions, maxNumberOfSuggestions));
        assertEquals("1", secret.getHistory().get(secret.getHistory().size() - 1));
    }

    @Test
    void ActorWeaponEqualSceneNotEqualThenReturnFalseAndHistory2() {
        secret.setActor(0);
        secret.setWeapon(0);
        secret.setScene(1);

        suggestion.setActor(0);
        suggestion.setWeapon(0);
        suggestion.setScene(0);

        assertEquals(false, gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestions, maxNumberOfSuggestions));
        assertEquals("2", secret.getHistory().get(secret.getHistory().size() - 1));
    }

    @Test
    void ActorSceneEqualWeaponNotEqualThenReturnFalseAndHistory2() {
        secret.setActor(0);
        secret.setWeapon(1);
        secret.setScene(0);

        suggestion.setActor(0);
        suggestion.setWeapon(0);
        suggestion.setScene(0);

        assertEquals(false, gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestions, maxNumberOfSuggestions));
        assertEquals("2", secret.getHistory().get(secret.getHistory().size() - 1));
    }

    @Test
    void WeaponSceneEqualActorNotEqualThenReturnFalseAndHistory2() {
        secret.setActor(1);
        secret.setWeapon(0);
        secret.setScene(0);

        suggestion.setActor(0);
        suggestion.setWeapon(0);
        suggestion.setScene(0);

        assertEquals(false, gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestions, maxNumberOfSuggestions));
        assertEquals("2", secret.getHistory().get(secret.getHistory().size() - 1));
    }

    @Test
    void MaxNumberOfSuggestionReachedAndNotWinThenReturnFalseAndHistoryNoneLeft() {
        secret.setActor(1);
        secret.setWeapon(0);
        secret.setScene(0);

        suggestion.setActor(0);
        suggestion.setWeapon(0);
        suggestion.setScene(0);

        numberOfSuggestions = 9;

        assertEquals(false, gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestions, maxNumberOfSuggestions));
        assertEquals("lost", secret.getHistory().get(secret.getHistory().size() - 1));
    }


}


