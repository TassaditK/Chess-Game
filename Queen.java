public class Queen extends Piece {
    public Queen(int x, int y, Player owner) {
        super(x, y, owner);
    }

    @Override
    public boolean isMoveAuthorized(Board board, Coordinates destination) {
        if (!board.isEmptyCell(destination) && board.getPiece(destination).sameColor(this))
            return false;
        if (getPosition() == destination)
            return false;
        if (!board.contains(destination))
            return false;
        return(board.sameDiagonalNothingBetween(getPosition(),destination)|| board.sameColumnNothingBetween(getPosition(),destination)
                    || board.sameLineNothingBetween(getPosition(),destination));

    }

    @Override
    public Type getType() {
        return Type.QUEEN;
    }

    @Override
    public int getValue() {
        return 9;
    }
}
