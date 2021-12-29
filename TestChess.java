public class TestChess{
	public static void test(String filename,boolean result){
		System.out.println("test : "+filename);
		if(result == true) System.out.println("pass"); else System.out.println("fail");
	}


	public static void main(String[] args) {


		boolean resultTest;
		/* Test de déplacements autorisés selon les regles de pièces */
		System.out.println("--------------Authorized moves-------------");


		// test the king's authorized movements
		resultTest = testAuthorizedMove("boardConfigurationFiles/KingsOnly.txt", new Coordinates(3,0), new Coordinates(3,2));
		test(" Kings",resultTest);

		// test the pawns's authorized moves
		test(" white pawn1",testAuthorizedMove("boardConfigurationFiles/Pawns.txt",new Coordinates(1,1), new Coordinates(1,2)));
		test("white pawn2",!testAuthorizedMove("boardConfigurationFiles/Pawns.txt",new Coordinates(1,1),new Coordinates(1,4)));
		test("white pawn3",testAuthorizedMove("boardConfigurationFiles/Pawns.txt",new Coordinates(4,1),new Coordinates(4,2)));
		test("white pawn4",!testAuthorizedMove("boardConfigurationFiles/Pawns.txt",new Coordinates(5,1),new Coordinates(5,5)));
		test("white pawn5",testAuthorizedMove("boardConfigurationFiles/Pawns.txt",new Coordinates(5,1),new Coordinates(5,2)));
		test("white pawn6",testAuthorizedMove("boardConfigurationFiles/Pawns.txt",new Coordinates(6,1),new Coordinates(6,3)));
		test("white pawn7",testAuthorizedMove("boardConfigurationFiles/Pawns.txt",new Coordinates(7,1),new Coordinates(7,2)));
		test("white pawn8",!testAuthorizedMove("boardConfigurationFiles/Pawns.txt",new Coordinates(7,1),new Coordinates(7,5)));


		test("black pawn1",testAuthorizedMove("boardConfigurationFiles/Pawns.txt",new Coordinates(0,6),new Coordinates(0,5)));
		test("black pawn2",testAuthorizedMove("boardConfigurationFiles/Pawns.txt",new Coordinates(1,6),new Coordinates(1,5)));
		test("black pawn2",!testAuthorizedMove("boardConfigurationFiles/Pawns.txt",new Coordinates(1,6),new Coordinates(0,7)));
		test("black pawn3",testAuthorizedMove("boardConfigurationFiles/Pawns.txt",new Coordinates(2,6),new Coordinates(2,5)));
		test("black pawn4",testAuthorizedMove("boardConfigurationFiles/Pawns.txt",new Coordinates(3,6),new Coordinates(3,5)));
		test("black pawn5",testAuthorizedMove("boardConfigurationFiles/Pawns.txt",new Coordinates(4,6),new Coordinates(4,4)));
		test("black pawn6",testAuthorizedMove("boardConfigurationFiles/Pawns.txt",new Coordinates(5,6),new Coordinates(5,5)));
		test("black pawn7",testAuthorizedMove("boardConfigurationFiles/Pawns.txt",new Coordinates(6,6),new Coordinates(6,5)));
		test("black pawn8",testAuthorizedMove("boardConfigurationFiles/Pawns.txt",new Coordinates(7,6),new Coordinates(7,4)));




		// test the knights's authorized moves
		test("white knight1",testAuthorizedMove("boardConfigurationFiles/Knights.txt",new Coordinates(1,0),new Coordinates(2,2)));
		test("white knight1 second test",!testAuthorizedMove("boardConfigurationFiles/Knights.txt",new Coordinates(1,0),new Coordinates(2,1)));
		test("white knight2",testAuthorizedMove("boardConfigurationFiles/Knights.txt",new Coordinates(6,0),new Coordinates(5,2)));
		test("black knight1",testAuthorizedMove("boardConfigurationFiles/Knights.txt",new Coordinates(1,7),new Coordinates(2,5)));
		test("black knight1 second test",testAuthorizedMove("boardConfigurationFiles/Knights.txt",new Coordinates(1,7),new Coordinates(3,6)));
		test("black knight2",testAuthorizedMove("boardConfigurationFiles/Knights.txt",new Coordinates(6,7),new Coordinates(5,5)));

		//test the Rook's authorized moves
		test("white Rook1",testAuthorizedMove("boardConfigurationFiles/Rooks.txt",new Coordinates(7,0),new Coordinates(5,0)));
		test("white Rook1 second test",testAuthorizedMove("boardConfigurationFiles/Rooks.txt",new Coordinates(7,0),new Coordinates(7,2)));
		test("black Rook1",testAuthorizedMove("boardConfigurationFiles/Rooks.txt",new Coordinates(7,7),new Coordinates(4,7)));
		test("black Rook1 second test",testAuthorizedMove("boardConfigurationFiles/Rooks.txt",new Coordinates(7,7),new Coordinates(7,5)));

		// test the Queens's authorized moves
		test("white Queen",testAuthorizedMove("boardConfigurationFiles/Queens.txt",new Coordinates(4,0),new Coordinates(4,2)));
		test("white Queen second test",testAuthorizedMove("boardConfigurationFiles/Queens.txt",new Coordinates(4,0),new Coordinates(2,2)));
		test("black Queen",testAuthorizedMove("boardConfigurationFiles/Queens.txt",new Coordinates(4,7),new Coordinates(4,5)));
		test("black Queen second test",testAuthorizedMove("boardConfigurationFiles/Queens.txt",new Coordinates(4,7),new Coordinates(2,5)));


		// test the Bishops's authorized moves
		test("white bishop1",testAuthorizedMove("boardConfigurationFiles/Bishops.txt",new Coordinates(2,0),new Coordinates(4,2)));
		test("white bishop1 second test",!testAuthorizedMove("boardConfigurationFiles/Bishops.txt",new Coordinates(2,0),new Coordinates(2,1)));
		test("white bishop2",testAuthorizedMove("boardConfigurationFiles/Bishops.txt",new Coordinates(5,0),new Coordinates(3,2)));
		test("white bishop2 second test ",!testAuthorizedMove("boardConfigurationFiles/Bishops.txt",new Coordinates(5,0),new Coordinates(4,0)));
		test("test bishop2 third test",testAuthorizedMove("boardConfigurationFiles/Bishops.txt",new Coordinates(5,0),new Coordinates(0,5)));





		/* Test de déplacements jouables sur l'échiquier actuel, selon les regles du jeu*/
		System.out.println("------------playable moves------------");


        test("pawn test 1 ",testPlayableMove("boardConfigurationFiles/FullBoard.txt",new Coordinates(3, 1), new Coordinates(3, 2)));
        test("pawn test 2 ",testPlayableMove("boardConfigurationFiles/FullBoard.txt",new Coordinates(3, 1), new Coordinates(3, 3)));

        // test the Knights's playable moves
        test("knight test 1",testPlayableMove("boardConfigurationFiles/Knights.txt",new Coordinates(1,0),new Coordinates(2,2)));
        test("knight test 2 ",!testPlayableMove("boardConfigurationFiles/Knights.txt",new Coordinates(1,7),new Coordinates(3,6)));

        // test the rooks's playable moves
        test(" Rook 1",testPlayableMove("boardConfigurationFiles/Rooks.txt",new Coordinates(0,0),new Coordinates(1,0)));
        test(" Rook 2",testPlayableMove("boardConfigurationFiles/Rooks.txt",new Coordinates(7,0),new Coordinates(5,0)));
        test(" Rook 2 second test",testPlayableMove("boardConfigurationFiles/Rooks.txt",new Coordinates(7,0),new Coordinates(7,2)));

        // test the Queens's playable moves
        test(" Queen 1",testPlayableMove("boardConfigurationFiles/Queens.txt",new Coordinates(4,0),new Coordinates(4,2)));
        test(" Queen 1 second test",testPlayableMove("boardConfigurationFiles/Queens.txt",new Coordinates(4,0),new Coordinates(2,2)));


        // test the Bishops's playable moves
        test(" bishop1",testPlayableMove("boardConfigurationFiles/Bishops.txt",new Coordinates(2,0),new Coordinates(4,2)));
        test(" bishop1 second test",!testPlayableMove("boardConfigurationFiles/Bishops.txt",new Coordinates(2,0),new Coordinates(2,1)));
        test(" bishop2",testPlayableMove("boardConfigurationFiles/Bishops.txt",new Coordinates(5,0),new Coordinates(3,2)));
        test(" bishop2 second test ",!testPlayableMove("boardConfigurationFiles/Bishops.txt",new Coordinates(5,0),new Coordinates(4,0)));
        test("test bishop2 third test",testPlayableMove("boardConfigurationFiles/Bishops.txt",new Coordinates(5,0),new Coordinates(0,5)));




        /*  Tests de la mise en échec */
        System.out.println("---------Check--------- ");
        test("test check 1",testIsCheck("boardConfigurationFiles/testCheck.txt",ChessColor.WHITE));
        test("test check 2",!testIsCheck("boardConfigurationFiles/testCheck.txt",ChessColor.BLACK));

		/*  Tests de la Echec et mat "isCheckMate()" */

        System.out.println("----------------Check Mate---------------------------");
        test("test check Mate 1",!testIsCheckMate("boardConfigurationFiles/testCheck.txt",ChessColor.BLACK));
        test("test check Mate 2",testIsCheckMate("boardConfigurationFiles/testCheck.txt",ChessColor.WHITE));


        /*  Tests pours le calcul des points en fin de partie */
	}





	public static boolean testAuthorizedMove(String filename, Coordinates origin, Coordinates destination) {
		ChessUI ui = new ChessUI();
		Board testBoard = new Board(filename, new Human(ui, ChessColor.WHITE), new Human(ui, ChessColor.BLACK));
		Piece testPiece = testBoard.getPiece(origin);
		if(testPiece == null) {
			System.out.println("No Piece at :"+origin);
			return false;
		}
		return testPiece.isMoveAuthorized(testBoard, destination);
	}


	public static boolean testPlayableMove(String fileName, Coordinates origin, Coordinates destination) {
		ChessUI ui = new ChessUI();
		GameUI g = new GameUI(ui, fileName, new Human(ui, ChessColor.WHITE), new Human(ui, ChessColor.BLACK));

		Piece testPiece = g.getBoard().getPiece(origin);
		if(testPiece == null) {
			System.out.println("No Piece at :"+origin);
			return false;
		}
		return g.isMovePlayable(new Move(g.getBoard(), origin, destination));
	}

	public static boolean testIsCheck(String fileName, ChessColor color) {
		ChessUI ui = new ChessUI();
		Human white = new Human(ui,ChessColor.WHITE);
		Human black = new Human(ui, ChessColor.BLACK);
		GameUI g = new GameUI(ui, fileName,white,black);
		if(color == ChessColor.WHITE)
			return g.isCheck(white);
		else return g.isCheck(black);
	}




	public static boolean testIsCheckMate(String fileName, ChessColor color) {
		ChessUI ui = new ChessUI();
		Human white = new Human(ui,ChessColor.WHITE);
		Human black = new Human(ui, ChessColor.BLACK);
		GameUI g = new GameUI(ui, fileName,white,black);
		if(color == ChessColor.WHITE)
			return g.isCheck(white) && g.isCheckMate(white);
		else return g.isCheck(black) && g.isCheckMate(black);
	}


}

