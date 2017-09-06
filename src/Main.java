class Solution {
    public int solution(int[] A) {

        int min = 0;

        int P = 0;
        int Q = -1;
        int R = -1;

        for (int i = 1; i < A.length; i++){
            if (Q == -1 && A[i] >= A[i-1]) {
                Q = i-1;
            }
            if ((Q >= 0 && R == -1) && (A[i] <= A[i-1] || i + 1 == A.length)) {
                if (A[i] <= A[i-1]){
                    R = i - 1;
                }else{
                    R = i;
                }

                int localMin =  min(A[P]-A[Q], A[R]-A[Q]);
                if(min < localMin){
                    min = localMin;
                }
                P = i - 1;
                Q = -1;
                R = -1;
            }
        }
        return min;
    }

    public int min(int a, int b){
        return a > b ? b : a;
    }
}