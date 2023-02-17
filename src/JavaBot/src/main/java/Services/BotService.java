package Services;

import Enums.*;
import Models.*;

import java.util.*;
import java.util.stream.*;

public class BotService {
    private GameObject bot;
    private PlayerAction playerAction;
    private GameState gameState;

    public BotService() {
        this.playerAction = new PlayerAction();
        this.gameState = new GameState();
    }


    public GameObject getBot() {
        return this.bot;
    }

    public void setBot(GameObject bot) {
        this.bot = bot;
    }

    public PlayerAction getPlayerAction() {
        return this.playerAction;
    }

    public void setPlayerAction(PlayerAction playerAction) {
        this.playerAction = playerAction;
    }

    public void computeNextPlayerAction(PlayerAction playerAction) {
        playerAction.action = PlayerActions.STOP;
        var foodList = gameState.getGameObjects().stream().filter(item -> item.getGameObjectType() == ObjectTypes.FOOD).sorted(Comparator.comparing(item -> getDistanceBetween(bot, item))).collect(Collectors.toList());
        if (!gameState.getGameObjects().isEmpty()) {
            var playerList = gameState.getPlayerGameObjects().stream().sorted(Comparator.comparing(item -> getDistanceBetween(bot, item))).collect(Collectors.toList());
            var nearestPlayer = playerList.get(1);
            var nearestFood = foodList.get(0);
            var sizeDiffOfNP = bot.size - nearestPlayer.size;
            if (bot.size < 40 && (getDistanceBetween(bot, nearestPlayer) > bot.size + nearestPlayer.size + 200)) {
                System.out.println("kemek ngab");
                playerAction.heading = getHeadingBetween(nearestFood);
                playerAction.action = PlayerActions.FORWARD;
            } else {
                playerAction.heading = getHeadingBetween(nearestPlayer);
                if (bot.size < nearestPlayer.size) {
                    if (getDistanceBetween(bot, nearestPlayer) > bot.size + nearestPlayer.size + 70) {
                        System.out.println("coba tembak");
                        playerAction.heading = getHeadingBetween(nearestPlayer);
                        playerAction.action = PlayerActions.FIRETORPEDOES;
                    } else {
                        System.out.println("kabur ngab");
                        playerAction.heading = -getHeadingBetween(nearestPlayer);
                        playerAction.action = PlayerActions.FORWARD;
                    }
                } else {
                    if (getDistanceBetween(bot, nearestPlayer) > bot.size + nearestPlayer.size + 70) {
                        System.out.println("deketin");
                        playerAction.heading = getHeadingBetween(nearestPlayer);
                        playerAction.action = PlayerActions.FORWARD;
                    } else {
                        if (getDistanceBetween(bot, nearestPlayer) < bot.size + nearestPlayer.size + 70) {
                            System.out.println("tembak ngares");
                            playerAction.heading = getHeadingBetween(nearestPlayer);
                            playerAction.action = PlayerActions.FIRETORPEDOES;
                            if(getDistanceBetween(bot, nearestPlayer) < bot.size + nearestPlayer.size + 50) {
                                System.out.println("serbu ngares");
                                playerAction.heading = getHeadingBetween(nearestPlayer);
                                playerAction.action = PlayerActions.STARTAFTERBURNER;
                                }
                            else{
                                System.out.println("selaw dulu");
                                playerAction.heading = getHeadingBetween(nearestPlayer);
                                playerAction.action = PlayerActions.STOPAFTERBURNER;
                                }

                        }
                    }
                }
            }

            this.playerAction = playerAction;
        }
    }
    public GameState getGameState() {
        return this.gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
        updateSelfState();
    }

    private void updateSelfState() {
        Optional<GameObject> optionalBot = gameState.getPlayerGameObjects().stream().filter(gameObject -> gameObject.id.equals(bot.id)).findAny();
        optionalBot.ifPresent(bot -> this.bot = bot);
    }

    private double getDistanceBetween(GameObject object1, GameObject object2) {
        var triangleX = Math.abs(object1.getPosition().x - object2.getPosition().x);
        var triangleY = Math.abs(object1.getPosition().y - object2.getPosition().y);
        return Math.sqrt(triangleX * triangleX + triangleY * triangleY);
    }

    private int getHeadingBetween(GameObject otherObject) {
        var direction = toDegrees(Math.atan2(otherObject.getPosition().y - bot.getPosition().y,
                otherObject.getPosition().x - bot.getPosition().x));
        return (direction + 360) % 360;
    }

    private int toDegrees(double v) {
        return (int) (v * (180 / Math.PI));
    }


}
