#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <string.h>
using namespace std;

#define MAX_LENGTH 1000

struct nod{
    char data;
    struct nod *next;
};

void push(struct nod **queue, struct nod *node){
    if(*queue == NULL){
        *queue = node;
        (*queue)->next = NULL;
    }else{
        struct nod *aux = *queue;
        *queue = node;
        (*queue)->next = aux;
    }
}

struct nod *pop(struct nod **queue){
    if(*queue == NULL)
        return NULL;
    struct nod *aux = (*queue)->next;
    struct nod *ret = *queue;
    *queue = aux;
    return ret;
}

bool check(char *sequence, int length){
    struct nod *queue = (struct nod *)malloc(sizeof(struct nod));
    queue = NULL;
    for(int i=0; i<length; i++){
         if(sequence[i] == '(' || sequence[i]=='[' || sequence[i]=='{'){
            struct nod *node = (struct nod *)malloc(sizeof(struct nod));
            node->data = sequence[i];
            push(&queue, node);
        }else{
            struct nod *node = pop(&queue);
            if(node == NULL)
                return false;
            if(sequence[i] == ')')
                if(node->data != '(')
                    return false;
            if(sequence[i] == ']')
                if(node->data != '[')
                    return false;
            if(sequence[i] == '}')
                if(node->data != '{')
                    return false;
        }
    }
    if(queue == NULL)
        return true;
    else
        return false;
}

int main() {
    int test_cases;
    char *sequence = (char *)malloc(MAX_LENGTH*sizeof(char));
    scanf("%d", &test_cases);
    for(int i=0; i<test_cases; i++){
        scanf("%s", sequence);
        if(check(sequence, strlen(sequence)))
            printf("YES\n");
        else
            printf("NO\n");
    }
    return 0;
}