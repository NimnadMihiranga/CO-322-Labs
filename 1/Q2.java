public static int powerSum(int X, int N) {
    // Write your code here
        int count = 0;
        for(int i = (int)Math.pow(X,(float)1/N); i>0; i--){
            //if(Math.pow(X,N)>X)break;
            for(int j = (int)Math.pow(X-Math.pow(i,N),(float)1/N); j>0; j--){
                if(Math.pow(i,N) + Math.pow(j,N) == X) {
                    count++;
                    System.out.printf("%d %d\n",i,j);}
                if(Math.pow(i,N) + Math.pow(j,N) < X) break;
            }
            
        }
        return count;
        public static int sum(int total, int pow, int num){
            int val = total - Math.pow(num,pow);
            if(val==0)return 1;
            if(val<0) return 0;
            
            return sum(val,pow,num+1) + sum(val,pow,num-1);
        }
        return sum(X,N,1);
    }

}