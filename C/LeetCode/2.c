/* 
���������ǿ� ��������ʾ�����Ǹ�������������ÿλ���ֶ��ǰ���?����?�ķ�ʽ�洢�ģ�����ÿ���ڵ�ֻ�ܴ洢?һλ?���֡�

���㽫��������ӣ�������ͬ��ʽ����һ����ʾ�͵�����


 */
#include <stdio.h>
#include <stdlib.h>

typedef struct ListNode {
    int val;
    struct ListNode *next;
}Node;

Node *Creat(int a[], int n)
{
    //����һ���������飬��������ͷ�ڵ�
    Node *head = (Node *)malloc(sizeof(Node));
    Node *p, *q = head;
    for (int i = 0; i < n; i++)
    {
        p = (Node *)malloc(sizeof(Node));
        p->val = a[i];
        q->next = p;
        q = p;
    }
    p->next = NULL;
    return head;
}


struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2){
    int more=0;
    int t, n1, n2;
    struct ListNode* l3=NULL;
    struct ListNode* ls=NULL;
    struct ListNode* tmp=NULL;
    while(l1 || l2 ){
        n1 = l1?l1->val:0;
        n2 = l2?l2->val:0;
        t = n1 + n2 + more;
        more = t/10;
        t = t%10;
        tmp = malloc(sizeof(struct ListNode));
        tmp->val = t;
        tmp->next = NULL;
        if(l1) l1 = l1->next;
        if(l2) l2 = l2->next;
        if(!l3) {
            l3 = tmp;
            ls = l3;
            continue;
        }
        ls->next = tmp;
        ls = tmp;
    }
    if (more!=0){
        tmp = malloc(sizeof(struct ListNode));
        tmp->val = more;
        tmp->next = NULL;
        ls->next = tmp;
    }

    return l3;
}

void Show(Node *head)
{   //��������ͷ�ڵ㣬��ӡ���нڵ�ֵ
    Node *p = head;
    while (p!=NULL)
    {
        printf("%d",p->val);
        p = p->next;
    }
    printf("\n");
}

int main(int argc, char const *argv[])
{
    int A[] = {9,9,9,9,9,9,9};
    int B[] = {9,9,9,9};
    Node *la = Creat(A, 7);
    Node *lb = Creat(B, 4);
    la = addTwoNumbers(la->next, lb->next);
    Show(la);
    return 0;
}
