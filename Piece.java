import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Piece{
    protected Coordinates position;
    protected Player owner;

    
    public Piece(int x, int y, Player owner){
        this.position = new Coordinates(x, y);
        this.owner = owner;
    }


    public enum Type {
        KING,
        QUEEN,
        ROOK,
        BISHOP,
        KNIGHT,
        PAWN
    }

    public void setPosition(Coordinates destination){
        this.position = destination;
    }
    
    public Player getOwner(){
	return this.owner;
    }

    public ChessColor getColor(){
	return this.owner.getColor();
    }

    public Coordinates getPosition(){
	return position;
    }

    public int getX(){
	return position.getX();
    }
    
    public int getY(){
	return position.getY();
    }

    public List<Move> getAllMoves(Board board) {
        List<Move> allMoves = new ArrayList<>();
        for(Coordinates coordinates: board.getAllCoordinates()){
            if(this.isMoveAuthorized(board,coordinates)){
                allMoves.add(new Move(board,position,coordinates));
            }
        }
        return allMoves;

    }

    public boolean sameColor(Piece piece){
	    return this.getColor().equals(piece.getColor()) ;
    }

    public abstract boolean isMoveAuthorized(Board board, Coordinates destination);

    public abstract Type getType();
    public abstract int getValue();
    


}
