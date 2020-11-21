package EU3;
public class ReachableFieldsOnChessboard
{
    public static void main(String[]args) throws NotValidFieldException{
        // En shack bräda
        Chessboard chessboard = new Chessboard();
        
        // Alla pjäser
        Chessboard.Chesspiece[] pieces = new Chessboard.Chesspiece[6];
        pieces[0] = chessboard.new Pawn('w','P');
        pieces[1] = chessboard.new Rook('b','R');
        pieces[2] = chessboard.new Queen('w','Q');
        pieces[3] = chessboard.new Bishop('w', 'B');
        pieces[4] = chessboard.new King('b','K');


       // Visa alla pjäser och deras markeringar 
        for(Chessboard.Chesspiece piece : pieces)
        {
            System.out.println(chessboard);
            piece.moveTo('d',(byte)4);
            piece.markReachableFields();
            System.out.println(chessboard);
            piece.unmarkReachableFields();
            System.out.println(chessboard);
            piece.moveOut();
        }

 /*     pieces[1].moveTo('b', (byte)2);
        pieces[4].moveTo('c',(byte)2);
        pieces[1].markReachableFields();
        System.out.println(chessboard);
*/
    } 
}