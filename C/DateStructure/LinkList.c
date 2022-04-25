#include <stdio.h>
#include <stdlib.h>

typedef struct Node
{
	int data;
	struct Node *next;
}Node, *LinkList;

LinkList Initialist(int *data, int n)
{
    //����data��������, ����ͷ�ڵ㣬ͷ�ڵ㲻������
	Node *head = (Node *)malloc(sizeof(Node));
	Node *temp;
    Node *p = (Node *)malloc(sizeof(Node));
	p->data = data[0];
	p->next = NULL;
	head->next = p;
	for (int i = 1; i < n; i++)
	{
		temp = (Node *)malloc(sizeof(Node));
		temp->data = data[i];
		temp->next = NULL;
		p->next = temp;
		p = temp;
	}
    return head;
}

int Delete_MinNode(LinkList head)
{
    Node *p = head->next;
    int min = p->data;
    Node *po = p; //������Сֵ�ڵ㣬��ʼΪ��һ��
    while (p->next!=NULL)
    {
        if (min > p->next->data)
        {
            min = p->next->data;
            po = p;
            p = p->next;
        }
        else p = p->next;
    }
    //ɾ���ڵ�
    p = po->next;
    po->next = po->next->next;
    free(p);
}

LinkList intersetion(LinkList LA, LinkList LB){
	// ����������������Ľ���, ���ƻ�ԭ����
	Node *LC = NULL, *p, *temp;
	LA = LA->next;
	LB = LB->next;
	while (LA && LB)
	{
		if (LA->data == LB->data){
			if (!LC){
				LC = malloc(sizeof(Node));
				p = malloc(sizeof(Node));
				LC->next = p;
				p->data = LA->data;
			}
			else{
				temp = malloc(sizeof(Node));
				temp->data = LA->data;
				p->next = temp;
				p = temp;
			}
			LA = LA->next;
			LB = LB->next;
		}
		else if (LA->data > LB->data) LB = LB->next;
		else LA = LA->next;	
	}
	p->next = NULL;
	return LC;
}

LinkList intersetion2(LinkList LA, LinkList LB){
	// ����������������Ľ���, ������ԭ����
	Node *head=NULL, *p, *temp;
	LA = LA->next;
	LB = LB->next;
	while (LA && LB)
	{
		if (LA->data == LB->data){
			if (!head){
				head = LA;
				p = head;
				LA = LA->next;
			}
			else{
				p->next = LA;
				p = LA;
				LA = LA->next;
			}
			temp = LB;
			LB = LB->next;
			free(temp);
		}
		else if (LA->data > LB->data){
			temp = LB;
			LB = LB->next;
			free(temp);
		}
		else{
			temp = LA;
			LA = LA->next;
			free(temp);
		}
	}
	p->next = NULL; //�ض϶��ಿ��
	// �Ӹ�������ͷ�ڵ�
	Node *prehead = malloc(sizeof(Node));
	prehead->next = head;
	return prehead;
}

void Showlist(Node *head)
{
	Node *p = head->next;
	while(p!=NULL)
	{
		printf("%d ",p->data);
		p = p->next;
	}
	printf("\n");
}


int main()
{
	int arr[] = {1,3,4,5,7,8,10,15};
	int brr[] = {2,3,4,6,7,9,10};
	Node *headA = NULL;
	Node *headB = NULL;
	Node *headC = NULL;
	headA = Initialist(arr, sizeof(arr)/sizeof(arr[0]));
	headB = Initialist(brr, sizeof(brr)/sizeof(brr[0]));
	Showlist(headA);
	Showlist(headB);
	headC = intersetion(headA, headB);
	Showlist(headC);
	headC = intersetion2(headA, headB);
	Showlist(headC);
	return 0;
}