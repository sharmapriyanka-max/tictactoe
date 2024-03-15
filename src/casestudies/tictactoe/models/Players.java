package casestudies.tictactoe.models;

import java.util.Scanner;

public class Players {
    private Long id;
    private String name;
    private Symbols symbol;
    private PlayerType playertype;
    private Scanner scanner;

    public Players(Long id,String name,Symbols symbol,PlayerType playertype)
    {
        this.id=id;
        this.name=name;
        this.symbol=symbol;
        this.playertype=playertype;
        this.scanner=new Scanner(System.in);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbols getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbols symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayertype() {
        return playertype;
    }

    public void setPlayertype(PlayerType playertype) {
        this.playertype = playertype;
    }

    public Move makeMove(Board board) {
        System.out.println("please enter the row number");
        int row=scanner.nextInt();

        System.out.println("please enter column number");
        int column=scanner.nextInt();

        return new Move(new Cell(row,column),this);
    }
}
