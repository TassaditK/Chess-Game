public class Rook extends Piece {
    public Rook(int x, int y, Player owner) {
        super(x, y, owner);
    }

    @Override
    public boolean isMoveAuthorized(Board board, Coordinates destination) {
        if (getPosition() == destination)
            return false;
        if (!board.isEmptyCell(destination) && board.getPiece(destination).sameColor(this))
            return false;
        if (!board.contains(destination))   return false;
        return( board.sameColumnNothingBetween(getPosition(),destination)
                || board.sameLineNothingBetween(getPosition(),destination));

    }

    @Override
    public Type getType() {
        return Type.ROOK;
    }

    @Override
    public int getValue() {
        return 5;
    }
}
