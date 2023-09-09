#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
#include <limits.h>

int main() {
    int height = INT_MAX;
    int width = INT_MAX;

    int steps;
    scanf("%d", &steps);

    int a, b;
    for(int i = 0; i < steps ; i++){
        scanf("%d %d", &a, &b);
        if(a <= 0 && b <= 0)
            continue;
        if (a <= height)
            height = a;
        if (b <= width)
            width = b;
    }

    printf("%lu", (unsigned long) height * (unsigned long) width);
    return 0;
}
