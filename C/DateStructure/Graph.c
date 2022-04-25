#include <stdio.h>
#include <stdlib.h>
#define maxsize 6

//��������Ҫ�����ڽӱ������ �� ͼ����ȱ���DFS ͼ�Ŀ�ȱ���BDF

//ͼΪ����Ȩֵ����ͼ


typedef struct ArcNode
{	//�߽ڵ�
	int vex; //��ǰ��ָ��Ľڵ���Ϣ
	struct ArcNode *nextarc;	//��һ����
}ArcNode;

typedef struct
{	//����ڵ�
	int vex;	//��������
	ArcNode *firstarc;	// ��������ĵ�һ����
}VNode;
typedef struct
{
	VNode Adjlist[maxsize];	//��������
	int v,e; //��ǰ����Ķ������ͱ���
}AGraph;	//�ڽӱ�

int UnEdge[maxsize][maxsize]={
	//����
	{0,1,1,0,0,0},
	{1,0,1,0,1,0},
	{1,1,0,1,0,0},
	{0,0,1,0,0,1},
	{0,1,0,0,0,0},
	{0,0,0,1,0,0}};


AGraph *InitAGraph()
{
	//����һ���ڽӱ�ͼ
	//printf("Begain InitAGraph\n");
	AGraph *G = (AGraph *)malloc(sizeof(AGraph));
	ArcNode *tb = (ArcNode *)malloc(sizeof(ArcNode));
	ArcNode *tn = NULL;
	for (int i = 0; i < maxsize; ++i)
	{
		G->Adjlist[i].vex = i;
		G->Adjlist[i].firstarc = NULL;
		for (int j = 0; j < maxsize; ++j)
			if (UnEdge[i][j]>=1)
			{	// ���ߴ���,�½�һ���ڵ�
				tn = (ArcNode *)malloc(sizeof(ArcNode));
				tn->vex = j;
				tn->nextarc=NULL;
				if (G->Adjlist[i].firstarc==NULL)
				{
					G->Adjlist[i].firstarc = tn;
					tb = G->Adjlist[i].firstarc;
					//printf("now insert %d behind %d \n", G->Adjlist[i].firstarc->vex,G.Vex[i]);
				}
				else
				{
					tb->nextarc = tn;
					tb = tb->nextarc;
					//printf("now insert %d behind %d \n", tb->nextarc->vex,G.Vex[i]);
				}
			}
	}
	return G;
}

void Display(AGraph *G)
{
	// ����ڽӱ�
	ArcNode *t = NULL;
	for (int i = 0; i < maxsize; ++i)
	{
		printf("%d---", G->Adjlist[i].vex);
		t = G->Adjlist[i].firstarc;
		while(t!=NULL)
		{
			printf("-%d", t->vex);
			t = t->nextarc;
		}
		printf("\n");
	}
	printf("-------------over\n");
}

void DFS(AGraph *G, int v)
{
	static int Visit[maxsize] = {0};
	ArcNode *p = G->Adjlist[v].firstarc;
	Visit[v] = 1;
	printf("%d-", G->Adjlist[v].vex);// visit()
	while(p!=NULL)
	{
		if (!Visit[p->vex] )
			DFS(G,p->vex);
		p = p->nextarc;
	}
}


void DFS1(AGraph *G, int v)
{
	//�ǵݹ�
	static int Visit[maxsize] = {0};
	ArcNode *p = NULL;
	int stack[maxsize], top=-1;
	Visit[v] = 1;
	stack[++top] = v;
	printf("%d-", G->Adjlist[v].vex);// visit()
	while(top!=-1) //ջ��ʱֱ��return ������ѭ������
	{
		p = G->Adjlist[stack[top]].firstarc;
		while(p!=NULL && Visit[p->vex])	//Ҫȷ��p���ָ���ָ�� ���ܶ�����ʣ���Ȼ����
			p = p->nextarc; //����ָ���ָ��

		if (p==NULL)
			top--;
		else
		{
			stack[++top] = p->vex;
			printf("%d-", p->vex);// visit()
			Visit[p->vex] = 1;
		}
	}
}

void BFS(AGraph *G, int v)
{
	static int Visit[maxsize+1] = {0};
	int queue[maxsize], front = 0, rear = 0;
	queue[rear++] = G->Adjlist[v].vex;
	Visit[v] = 1;
	ArcNode *p = NULL;
	while(front<rear)
	{
		p = G->Adjlist[queue[front]].firstarc;//������ͷ�ڵ�ĵ�һ����
		printf("%d-", queue[front++]); //���ʶ�ͷ�ڵ�

		while(p!=NULL) //���ճ��ӵĽڵ����������ӽڵ���ӣ��Ѿ����������
		{
			if (!Visit[p->vex])
			{
				Visit[p->vex] = 1;
				queue[rear++] = p->vex;
			}
			p = p->nextarc;
		}
	}
	//printf("The last%d\n", queue[front]);
}

int DetectLoop(AGraph *G, int v)
{
	static int visit[maxsize];
	static int edge, vertex;
	ArcNode *p = G->Adjlist[v].firstarc;
	visit[v] = 1;
	vertex++;	// �Ƕ���
	while(p!=NULL)
	{
		edge++;	//�Ǳ�
		if(visit[p->vex]==0)
			DetectLoop(G, p->vex);
		p = p->nextarc;
	}
	//printf(" %d %d ||", edge, vertex);
	if(edge/2 >= vertex) 
		return 1;
	return 0;
}

int DetectLoop2(AGraph *G, int v, int pre)
{
	static int visit[maxsize];
	static int flag;
	
	if(flag) return flag;
	ArcNode *p = G->Adjlist[v].firstarc;
	visit[v] = 1;
	while(p!=NULL)
	{
		if(p->vex!=pre && visit[p->vex]) flag = 1;
		if(!visit[p->vex]) DetectLoop2(G, p->vex, v);
		p = p->nextarc;
	}
	return flag;
}

int main()
{

	AGraph *G = InitAGraph();
	Display(G);
	if(DetectLoop(G,0)) printf("DetectLoop:YES\n");
	if(DetectLoop2(G,0,-1)) printf("DetectLoop2:YES");
	return 0;
}



