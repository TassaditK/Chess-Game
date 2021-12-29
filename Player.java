
import java.util.List;
import java.util.stream.Collectors;

public abstract class Player{
    protected ChessColor color;
    private int score;
    private King king;
    private boolean isCheck;
    private  boolean isCheckMate;

    public Player(ChessColor color){
        this.color = color;
        this.score = 0;
        isCheck= false;
        isCheckMate= false;
    }

    public ChessColor getColor(){
	    return color;
    }

    public int getScore(){
	    return score;
    }

    public void addToScore(int value){
        score +=value;
    }
    
    public void removeFromScore(int value){
        score -= value;
    }
    
    public abstract FromTo getFromTo(GameUI gameUI);

    public Piece getKing(){
        return king;
    }
    
    public void setKing(King king){
        this.king = king;
    }

    public boolean isCheck() { return isCheck; }
    public boolean isCheckMate() { return isCheckMate; }
    public void setCheck(){ isCheck = true; }
    public void unSetCheck(){ isCheck = false; }
    public void setCheckMate(){ isCheckMate=true;}
    public void unsetCheckMate(){isCheckMate = false;}
    
    public List<Move> getAllMoves(Board board) {
        return board.getPieces().stream()
                .map(p -> p.getAllMoves(board).stream())
                .flatMap(m->m).collect(Collectors.toList());

    }

    @Override
    public String toString(){
        return getColor().toString();
    }
}
