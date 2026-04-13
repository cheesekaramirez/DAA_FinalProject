package code;
public class Levenshtein {

    String m, n;

    public Levenshtein(String m, String n) {
        this.m = m;
        this.n = n;
    }

    public int minEditDist() {
        int[][] T = new int[m.length()+1][n.length()+1];
        for(int i = 0;i<m.length()+1;i++)
        {
            for(int j = 0;j<n.length()+1;j++)
            {
                if(i==0 && j==0){
                    T[i][j] = 0;
                }
                else if(i==0){
                    T[i][j] = T[i][j-1]+1;
                }
                else if(j==0){
                    T[i][j] = T[i-1][j]+1;
                }else if(m.charAt(i-1)==n.charAt(j-1)){
                    T[i][j] = T[i-1][j-1];
                }else {
                    T[i][j] = 1+min(T [i] [j-1],
                       T [i-1] [j], 
                       T [i-1] [j-1]);
                }
            }
            
        }
       
        return T[m.length()][n.length()];
    }

    public int min(int val1, int val2, int val3){
        int arr[] = {val1,val2,val3};
        int min=val1;
        for(int i=0; i<arr.length;i++){
            if (arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }
    public void display(){
        System.out.printf("\nComparing the distance between the strings: %s and %s",m,n);
        System.out.printf("\nThe minimum edit distance between the strings: %s and %s is %d",m,n,minEditDist());
        System.out.println();
    }

}
