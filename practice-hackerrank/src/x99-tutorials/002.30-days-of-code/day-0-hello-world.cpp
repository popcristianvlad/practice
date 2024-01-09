#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
   char *inputStream = (char *)malloc(100*sizeof(char));
   gets(inputStream);
   printf("Hello, World.\n%s", inputStream);
   return 0;
}
