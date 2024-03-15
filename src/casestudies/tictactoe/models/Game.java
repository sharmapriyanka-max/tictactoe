package casestudies.tictactoe.models;

import Exceptions.BotCountException;
import Exceptions.PlayersCountException;
import Exceptions.SymbolCountException;
import casestudies.tictactoe.strategies.WinningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    private List<Players> players;
    private Board board;
    private List<Move> moves;
    private GameState gamestate;
    private Players winner;
    private int nextPlayerTurnIndex;
    private List<WinningStrategy> winningStrategies;

    private Game(int dimensions,List<Players> players,List<WinningStrategy> winningStrategies)
    {
        board=new Board(dimensions);
        this.players=players;
        this.winningStrategies=winningStrategies;
        this.moves=new ArrayList<>();
        this.gamestate= GameState.IN_PROGRESS;
        this.nextPlayerTurnIndex=0;




    }

    public static Builder getBuilder()
    {
        return new Builder();
    }

    public void displayBoard() {
        this.board.displayBoard();
    }

    public void makeMove() {
        Players currentPlayer=players.get(nextPlayerTurnIndex);
        System.out.println("it is" + currentPlayer.getName()+ "'s move");
        Move move=currentPlayer.makeMove(board);
        System.out.println(currentPlayer.getName()+ "has made a move at" + move.getCells().getRow()+" , "+move.getCells().getCol() );
        if(!ValidateMove(move))
        {
            System.out.println("It's an invalid move");
            return;
        }
        int row=move.getCells().getRow();
        int col=move.getCells().getCol();

        Cell actualCellOfBoard=board.getCells().get(row).get(col);
        actualCellOfBoard.setCellstate(CellState.FILLED);
        actualCellOfBoard.setPlayer(currentPlayer);
        Move actualMove=new Move(actualCellOfBoard,currentPlayer);
        moves.add(actualMove);
        nextPlayerTurnIndex+=1;
        nextPlayerTurnIndex%=players.size();
        if (checkWinner(move))
        {
            setGamestate(GameState.WIN);
            setWinner(currentPlayer);

        }
        if(moves.size()== board.getSize()* board.getSize())
        {
            setGamestate(GameState.DRAW);
            System.out.println("Game has been drawn");
        }
    }

    private boolean checkWinner(Move move) {
        for(WinningStrategy winningStrategy:winningStrategies)
        {
            if(winningStrategy.checkWinner(board,move))
            {
                return true;
            }
        }
        return false;
    }

    private boolean ValidateMove(Move move) {
        int row=move.getCells().getRow();
        int col=move.getCells().getCol();

        if(row<0 || row>board.getSize())
        {
            return false;
        }
        if(col<0 || col> board.getSize())
        {
            return false;
        }
        if(board.getCells().get(row).get(col).getCellstate().equals(CellState.FILLED))
        {
            return false;
        }
        return true;
    }

    public static class Builder{
        private int dimensions;
        private List<Players> players;
        private List<WinningStrategy> winningStrategies;

        public Game Build() throws PlayersCountException,BotCountException,SymbolCountException
        {
            validate();
            return new Game(dimensions,players,winningStrategies);
        }
        private void validate() throws PlayersCountException ,BotCountException, SymbolCountException {

            validatePlayersCount();
            //validateBotCount();
           // validateSymbolCount();
        }
        private void validatePlayersCount() throws PlayersCountException
        {
            if(players.size()!=dimensions-1)
                throw new PlayersCountException();

        }
        private void validateBotCount() throws BotCountException {
            int count=0;
            for(Players player : players)
            {
                if(player.getPlayertype().equals (PlayerType.BOT))
                {
                    count++;
                }
            }
            if(count>1)
            {
                throw new BotCountException();
            }

        }
        private void validateSymbolCount() throws SymbolCountException {
            HashMap<Character,Integer> symbolCount=new HashMap<>();
            for(Players player : players) {
                if (!symbolCount.containsKey(player.getSymbol().getaChar())) {
                    symbolCount.put(player.getSymbol().getaChar(), 0);
                }

                symbolCount.put(player.getSymbol().getaChar(),symbolCount.get(player.getSymbol().getaChar())+1);

                if(symbolCount.get(player.getSymbol().getaChar())>1)
                {
                    throw new SymbolCountException();
                }
            }

        }

        public Builder setDimensions(int dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        public Builder setPlayers(List<Players> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }
    }

    public List<Players> getPlayers() {
        return players;
    }

    public void setPlayers(List<Players> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameState getGamestate() {
        return gamestate;
    }

    public void setGamestate(GameState gamestate) {
        this.gamestate = gamestate;
    }

    public Players getWinner() {
        return winner;
    }

    public void setWinner(Players winner) {
        this.winner = winner;
    }

    public int getNextPlayerTurnIndex() {
        return nextPlayerTurnIndex;
    }

    public void setNextPlayerTurnIndex(int nextPlayerTurnIndex) {
        this.nextPlayerTurnIndex = nextPlayerTurnIndex;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }
}
