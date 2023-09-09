#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

void swap(long double *i1, long double *i2){
    long double aux = *i1;
    *i1 = *i2;
    *i2 = aux;
}

int main() {
    long long int testCases, N, K;
    long long int count;
    long double i1, i2;
    scanf("%lli", &testCases);
    for(int i=0; i<testCases; i++){
        count = 0;
        scanf("%lli %lli", &N, &K);
        long long int delta = N*N - 4 * N * K;
        if(delta > 0){
            i1 = (N - sqrt(delta))/2;
            i2 = (N + sqrt(delta))/2;
            if(i1 > i2)
                swap(&i1, &i2);

            if(i1 > 0 && i1 < N) {
                count += i1;
            }

            if(i2 > 0 && i2 < N) {
                count += N - i2;
            }
        }else{
            count += N - 1;
        }
        printf("%lli\n", count);
    }
    return 0;
}
