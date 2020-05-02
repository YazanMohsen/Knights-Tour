/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knightstour;

/**
 *
 * @author DELL3567
 */
public class KnightsTour {
    
    final int Dimension=6;
    final int DimensionSq=Dimension*Dimension;
    
    int Solution[][]=new int[Dimension][Dimension];
    boolean Solved;
    
    int []Xcoordinates={2,1,-1,-2,-2,-1,1,2};
    int []Ycoordinates={1,2,2,1,-1,-2,-2,-1};
    
    void Try(int Passing,int x,int y)
    {
     
        if(Passing>=DimensionSq )
        Solved=true;
        
        
        if( x>=Dimension || x<0 || y>=Dimension ||y<0)
        return  ;
        
        Solution[x][y]=Passing;
          
        for (int j = 0; j < 8; j++) 
        {    
        int u=x+Xcoordinates[j];
        int v=y+Ycoordinates[j];
        if(u<Dimension && u>=0 && v<Dimension &&v>=0&& Solution[u][v]==0)
           Try(Passing+1,u,v);
             
           }
       
      if(!Solved)
        Solution[x][y]=0;  
        
    }
   
    
    
    void Call()
    {
        
        Try(1,1,1);
        
        if(Solved)
            for (int i = Dimension-1; i >= 0; i--) 
            {
                System.out.println("");
                for (int j = 0; j < Dimension; j++) 
                {
                    System.out.print("|"+Solution[i][j]+"|\t");
                }
            }     

            
    }
    
    public static void main(String[] args) {
    
        new KnightsTour().Call();
    System.out.println();
        

    }
    
}
