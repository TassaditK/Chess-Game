public class Pawn extends Piece {
    public Pawn(int x, int y, Player owner) {
        super(x, y, owner);
    }

    @Override
    public boolean isMoveAuthorized(Board board, Coordinates destination) {
        if(getPosition() == destination)    return false;
        if(! board.isEmptyCell(destination) && board.getPiece(destination).getColor().equals(this.getColor()))  return false;
        int Destination = getOwner().getColor().equals(ChessColor.WHITE) ? 1: -1;
        int dx = destination.getX() - getPosition().getX();
        int dy = destination.getY() - getPosition().getY();
        if(dx == 0){
            if( ! board.isEmptyCell(destination))   return  false;
            if(Math.abs(dy) == 2){
                int x = getOwner().getColor() == ChessColor.WHITE ? 1:6;
                return getY() == x && dy == Destination*2;
            }
            return dy == Destination;
        }
        else{
            return dy == Destination && (!board.getPiece(destination).sameColor(this)) && Math.abs(dx)==1 && (!board.isEmptyCell(destination));
        }

    }

    @Override
    public Type getType() {
        return Type.PAWN;
    }

    @Override
    public int getValue() {
        return 1;
    }
}
