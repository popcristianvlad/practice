#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {

    int n, sum;
    scanf("%d", &n);
    sum = n%10 + n/10%10+ n/100%10 + n/1000%10 + n/10000%10;

    printf("%d", sum);
    return 0;
}
