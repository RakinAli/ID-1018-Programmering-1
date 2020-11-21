package Ov3;
class DenKortasteVagen 
{
      public static int[] mellanstationer(double [] a, double[][] b, double[] c)
      { 
           int[] index = new int [2];
           double kortväg =  a[1] + b[1][1] +c[1];
           for(int stationA = 1; stationA< a.length; stationA++)
           {
                for(int stationB = 1; stationB < c.length; stationB++)
                {
                     if ( kortväg >= a[stationA] + b[stationA][stationB] + c[stationB])
                     {
                          kortväg = a[stationA] + b[stationA][stationB] + c[stationB];
                          index[0] = stationA;
                          index[1] = stationB;
                     }
                }
           }
           return index;
      }

      // langd returnerar längden av den kortaste vägen. 
      public static double langd (double[] a, double[][]b, double[]c)
      {
           // Start värdet
           double minstaVäg =  a[1] + b[1][1] +c[1];
         
           // Loopa igenom alla vägar
           for(int stationerA = 1; stationerA< a.length; stationerA++)
           {
                for(int stationerB = 1; stationerB < c.length; stationerB++)
                {
                     if (minstaVäg > a[stationerA] + b[stationerA][stationerB] +c[stationerB])
                     minstaVäg = a[stationerA] + b[stationerA][stationerB] +c[stationerB];
                }
           }
           return minstaVäg;
      }
}