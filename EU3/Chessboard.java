package EU3;
public class Chessboard
{
    // Klassen fältet är själva "lådorna" där pjäserna ramlar ner på 
    public static class Field
    {
        private char row;
        private byte column;
        private Chesspiece piece = null;
        private boolean marked = false;
        
        //Själva fältet konstruktör
        public Field (char row, byte column) 
        { 
            this.row = row;
            this.column = column;
        } 
        
        // Lägga en pjäs på fältet
        public void put (Chesspiece piece) 
        {
            this.piece = piece;
        }
        
        // Ta av pjäsen från fältet eller döda en pjäs
        public Chesspiece take () 
        {   
            Chesspiece peice = this.piece;
            this.piece = null;
            return peice;
        }
        
        // Markera fältet
        public void mark () 
        {
            this.marked = true;
        }
        
        // Avmerka fältet
        public void unmark () 
        {
            this.marked = false;
        }
        
        // Hur det kommer printa ut markerade fält 
        public String toString ()
        {
            String s = (marked)? "xx" : "--";
            return (piece == null)? s : piece.toString ();
        }
    }
  
    // Brädans egenskaper
    public static final int NUMBER_OF_ROWS = 8;
    public static final int NUMBER_OF_COLUMNS = 8;
    public static final int FIRST_ROW = 'a';
    public static final int FIRST_COLUMN = 1;
    private Field[][] fields;
    
    // Shack brädan & Konstruktören för den
    public Chessboard ()
    {
        fields = new Field[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS]; //Objekt av typen static class Field 
        char row = 0;

        byte column = 0;
        for (int r = 0; r < NUMBER_OF_ROWS; r++)
        {
            row = (char) (FIRST_ROW + r);
            column = FIRST_COLUMN;
            for(int c = 0; c < NUMBER_OF_COLUMNS; c++)
            {
                fields[r][c] = new Field (row, column);
                column++;
            }
        }
    }

    // Hur shackbrädan kommer att printas ut i form av en string.
    public String toString () 
    {
        StringBuilder chessboard = new StringBuilder();
        chessboard.append("   1   2   3   4   5   6   7   8\n\n");
        for(int i = 0; i < NUMBER_OF_ROWS; i++)
        {
            char rowname = (char)(FIRST_ROW + i);
            chessboard.append(rowname).append("  ");
            for(int j = 0; j< NUMBER_OF_COLUMNS; j++)
            {
                chessboard.append(fields[i][j].toString()).append("  ");
            }
            chessboard.append("\n\n");
        }
        return chessboard.toString();
    }
    
    // Metoden som kollar ifall platsen jag rör på mig finns i brädan (Alltså om objektet field finns)
    public boolean isValidField (char row, byte column) 
    {
        return row >= 'a' && row <= 'h' && column >0 && column < NUMBER_OF_COLUMNS; // Fråga Fadil om varför det inte står lika med 8        
    }

    /*______________________________________________________HÄR SKAPAS ALLA PJÄSER_________________________________________________________*/
    // Abstract classen för alla pjäser. 
    public abstract class Chesspiece
    {
        private char color;
        // w - white, b - black
        private char name;
        // K - King, Q - Queen, R - Rook, B - Bishop, N - Knight,
        // P – Pawn

        // Pjäserna skapas UTANFÖR brädan
        protected char row = 0;
        protected byte column = -1;

        // Konstrukstör för en ny Chesspiece objekt, Fråga Fadil vad menas med protected
        protected Chesspiece (char color, char name) 
        {
            this.color = color;
            this.name = name;
        }

        //Printa ut pjäserna med färg + namn
        public String toString ()
        {
            return "" + color + name;
        }
       
        // Metoden kollar ifall pjäserna finns på brädan
        public boolean isOnBoard ()
        {
            return Chessboard.this.isValidField (row, column);
        }

        // Flytta en pjäs till en vald position
        public void moveTo (char row, byte column) throws NotValidFieldException
        {
            if (!Chessboard.this.isValidField (row, column))
                throw new NotValidFieldException ("bad field: " + row + column );
            this.row = row;
            this.column = column;
            int r = row - FIRST_ROW;
            int c = column - FIRST_COLUMN;
            Chessboard.this.fields[r][c].put (this);
        }

        // Dödar en pjäs
        public void moveOut () 
        {
            Chessboard.this.fields[row-FIRST_ROW][column-FIRST_COLUMN].take();
        }

        // En abstract void motod, jag kommer skapa metodens kropp när den extendas
        public abstract void markReachableFields ();
        public abstract void unmarkReachableFields ();
    }

    // Bonde, dem dära värdelösa pjäserna 
    public class Pawn extends Chesspiece
    {
        // Konstruktör ifall jag skapar en objekt av denna klass
        public Pawn (char color, char name)
        {
            super (color, name);
        }
      
        // Den kan endast gå rak fram 
        public void markReachableFields ()
        {
        byte col = (byte) (column + 1);
            if (Chessboard.this.isValidField (row, col))
            {
                int r = row - FIRST_ROW;
                int c = col - FIRST_COLUMN;
                Chessboard.this.fields[r][c].mark ();
            }
        }
        public void unmarkReachableFields ()
        {
            byte col = (byte) (column + 1);
            if (Chessboard.this.isValidField (row, col))
            {
                int r = row - FIRST_ROW;
                int c = col - FIRST_COLUMN;
                Chessboard.this.fields[r][c].unmark ();
            }
        }
    }
  
    // Den där tornet som rör sig antingeh helt åt sidan eller helt rak
    public class Rook extends Chesspiece 
    {
        // Konstruktör ifall jag gör objekt ur denna klass
        public Rook (char color, char name)
        {
            super(color,name);
        }

        // Ska markera allt allt framför och till sidan om. Hur tower gör sig
        public void markReachableFields()
        {
            // Gå igenom ALLA KOLUMNER till Sidan om  dig
            for(byte col = 1; col <= 8; col++)
            {
                if(Chessboard.this.isValidField(row, col) && (col!= column) ) // Måste röra pjäsen
                {
                    int r = row - FIRST_ROW;
                    int c = col- FIRST_COLUMN;
                    Chessboard.this.fields[r][c].mark();
                }
            }
            // Gå igenom ALLA RADER framför och bakom dig
            for(char ro = 'a'; ro<='h'; ro++)
            {
                if(Chessboard.this.isValidField(ro, column)&& (ro!= row) ) // Måste röra pjäsen 
                {
                    int r = ro - FIRST_ROW;
                    int c = column - FIRST_COLUMN;
                    Chessboard.this.fields[r][c].mark();
                }
            }
        }
        
        public void unmarkReachableFields() // Copy paste:a koden ovanför och lägg unmark();
        {
            for(byte col = 1; col <= 8; col++)
            {
                if(Chessboard.this.isValidField(row, col) && (col!= column) )
                {
                    int r = row - FIRST_ROW;
                    int c = col- FIRST_COLUMN;
                    Chessboard.this.fields[r][c].unmark();
                }
            }

            for(char ro = 'a'; ro<='h'; ro++)
            {
                if(Chessboard.this.isValidField(ro, column)&& (ro!= row) )
                {
                    int r = ro - FIRST_ROW;
                    int c = column - FIRST_COLUMN;
                    Chessboard.this.fields[r][c].unmark();
                }
            }
        }
    }
  
    // Hästen. Den som rör sig som en L formaten
    public class Knight extends Chesspiece 
    {
        //Konstruktör
        public Knight(char color, char name)
        {
            super(color, name);
        }
        
        // Alla möjliga sätt den kan röra sig på 
        int [] x = {1,2,2,1,-1,-2,-2,-1,1,2}; // ---- Youtube 

        public void markReachableFields() 
        {
            for(int i=0; i<8; i++)
            {
                if(Chessboard.this.isValidField((char)(row + x[i]),(byte) (column + x[i+2])))
                {
                    int r = (char) (row+ x[i]) - FIRST_ROW;
                    int c = (byte) (column + x[i+2]) - FIRST_COLUMN;
                    Chessboard.this.fields[r][c].mark();
                }
            }
        }
        public void unmarkReachableFields()
        {
            for(int i=0; i<8; i++)
            {
                if(Chessboard.this.isValidField((char)(row + x[i]),(byte) (column + x[i+2])))
                {
                    int r = (char) (row+ x[i]) - FIRST_ROW;
                    int c = (byte) (column + x[i+2]) - FIRST_COLUMN;
                    Chessboard.this.fields[r][c].unmark();
                }
            }
        }
    }
   
    // Den som rör sig som en X
    public class Bishop extends Chesspiece 
    {
        //Konstruktör ifall jag skapar en objekt ur denna klass.
        public Bishop(char color, char name)
        {
            super(color,name);
        }
        
        int[] q = {1,1,-1,-1,1};
        
        public void markReachableFields()
        {
            for(int i = 1; i<8; i++)
            {
                for(int j=0; j<4; j++)
                {
                    if(Chessboard.this.isValidField((char)(row + i*q[j]),(byte) (column + i*q[j+1])))
                    {
                        int r = (char) (row + i*q[j]) - FIRST_ROW;
                        int c = (byte)(column + i*q[j+1]) - FIRST_COLUMN;
                        Chessboard.this.fields[r][c].mark();
                    }
                }
            }
        }
        public void unmarkReachableFields()
        {
            for(int i = 1; i<8; i++)
            {
                for(int j=0; j<4; j++)
                {
                    if(Chessboard.this.isValidField((char)(row + i*q[j]),(byte) (column + i*q[j+1])))
                    {
                        int r = (char) (row + i*q[j]) - FIRST_ROW;
                        int c = (byte)(column + i*q[j+1]) - FIRST_COLUMN;
                        Chessboard.this.fields[r][c].unmark();
                    }
                }
            }
        }
    }
  
    // MVP pjäsen
    public class Queen extends Chesspiece 
    {
        //Konstruktör ifall jag skapar en Queen
        public Queen (char color, char name)
        {
            super(color,name);
        }
        
        int[] z = {1,1,-1,-1,1};
        
        public void markReachableFields()
        {
            // Copy paste hela ROOK
            for(byte col = 1; col <=8; col++)
            {
                if(Chessboard.this.isValidField(row, col) && (col != column))
                {
                    int r = row - FIRST_ROW;
                    int c = column - FIRST_COLUMN;
                    Chessboard.this.fields[r][c].mark();
                }
            }

            for(char ro = 'a'; ro<= 'h'; ro++)
            {
                if(Chessboard.this.isValidField(ro, column) && (ro !=row))
                {
                    int r = ro - FIRST_ROW;
                    int c = column - FIRST_COLUMN;
                    Chessboard.this.fields[r][c].mark();
                }
            }
          
            // Copy Paste hela Bishop
            for(int i = 1; i<8; i++)
            {
                for(int j =0; j<4; j++)
                {
                    if(Chessboard.this.isValidField((char)(row + i*z[j]),(byte) (column+ i*z[j+1])))
                    {
                        int r = (char) (row + i*z[j]) - FIRST_ROW;
                        int c = (byte) (column+i*z[j+1]) - FIRST_COLUMN;
                        Chessboard.this.fields[r][c].mark();
                    }
                }
            }

        }

        public void unmarkReachableFields()
        {
            for(byte col = 1; col <=8; col++)
            {
                if(Chessboard.this.isValidField(row, col) && (col != column))
                {
                    int r = row - FIRST_ROW;
                    int c = column - FIRST_COLUMN;
                    Chessboard.this.fields[r][c].unmark();
                }
            }

            for(char ro = 'a'; ro<= 'h'; ro++)
            {
                if(Chessboard.this.isValidField(ro, column) && (ro !=row))
                {
                    int r = ro - FIRST_ROW;
                    int c = column - FIRST_COLUMN;
                    Chessboard.this.fields[r][c].unmark();
                }
            }

            for(int i = 1; i <8; i++)
            {
                for(int j =0; j<4; j++)
                {
                    if(Chessboard.this.isValidField((char)(row + i*z[j]),(byte) (column+ i*z[j+1])))
                    {
                        int r = (char) (row + i*z[j]) - FIRST_ROW;
                        int c = (byte) (column+i*z[j+1]) - FIRST_COLUMN;
                        Chessboard.this.fields[r][c].unmark();
                    }
                }
            }            
        }
    }
  
    // Kungen. Kan endast röra sig på en plats
    public class King extends Chesspiece 
    {
        public King(char color, char name )
        {
            super(color, name);
        }

        int[] temp = {0,1,1,1,0,-1,-1,-1,0,1};
        public void markReachableFields()
        {
            for(int i = 0; i < 8;i++)
            {
                if(Chessboard.this.isValidField((char)(row + temp[i]),(byte)(column + temp[i+2])))
                {
                    int r = (char) (row + temp[i])- FIRST_ROW;
                    int c = (byte)(column + temp[i+2])-FIRST_COLUMN;
                    Chessboard.this.fields[r][c].mark();           
                }
            }

        }
        public void unmarkReachableFields()
        {
            for(int i = 0; i < 8;i++)
            {
                if(Chessboard.this.isValidField((char)(row + temp[i]),(byte)(column + temp[i+2])))
                {
                    int r = (char) (row + temp[i]) - FIRST_ROW;
                    int c = (byte)(column + temp[i+2])-FIRST_COLUMN;
                    Chessboard.this.fields[r][c].unmark();           
                }
            } 
        }
    }    
}