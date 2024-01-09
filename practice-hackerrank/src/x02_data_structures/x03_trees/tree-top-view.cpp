#include<bits/stdc++.h>

using namespace std;

class Node {
    public:
        int data;
        Node *left;
        Node *right;
        Node(int d) {
            data = d;
            left = NULL;
            right = NULL;
        }
};

class Solution {
    public:
  		Node* insert(Node* root, int data) {
            if(root == NULL) {
                return new Node(data);
            } else {
                Node* cur;
                if(data <= root->data) {
                    cur = insert(root->left, data);
                    root->left = cur;
                } else {
                    cur = insert(root->right, data);
                    root->right = cur;
               }

               return root;
           }
        }

        void go_left(node *root){
            if(root != NULL){
                go_left(root->left);
                printf("%d ", root->data);
            }
        }

        void go_right(node *root){
            if(root != NULL){
                printf("%d ", root->data);
                go_right(root->right);
            }
        }

        void top_view(node * root){
            if(root != NULL){
                go_left(root->left);
                printf("%d ", root->data);
                go_right(root->right);
            }
        }
};

int main() {

    Solution myTree;
    Node* root = NULL;

    int t;
    int data;

    std::cin >> t;

    while(t-- > 0) {
        std::cin >> data;
        root = myTree.insert(root, data);
    }

	myTree.topView(root);
    return 0;
}
