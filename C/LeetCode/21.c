/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 * ��������������ϲ�Ϊһ���µ� ���� �������ء���������ͨ��ƴ�Ӹ�����������������нڵ���ɵġ� 
 */

#include <stdio.h>
#include <stdlib.h>


typedef struct ListNode {
      int val;
      struct ListNode *next;
}Node;

void add_data(Node **tail, int *data, int n)
{
	Node *p = NULL;
	for (int i = 0; i < n; ++i)
	{
		p = (Node *)malloc(sizeof(Node));
		p->val = data[i];
		p->next = (*tail)->next;
		(*tail)->next = p;
		(*tail) = p;
	}
}


struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2){

	struct ListNode *a = l1, *b = l2, *t, *pa;
	while(a!= NULL && b != NULL) 
	{
		if(a->val > b->val) //a>b,��a���뵽b����
		{
            pa = a;
            a = a->next;
            pa->next = b->next;
			b->next = pa;
            b = b->next;
		}
		else//��b���뵽a����
		{
			pa = b;
            b = b->next;
            pa->next = a->next;
            a->next = pa;
            a = a->next;
		}
	}
    if(l1->val > l2->val) return l1;
    else return l2;
}


int main(int argc, char const *argv[])
{
    int A[] = {1,3,4};
    int B[] = {1,2,4};

    return 0;  
}
