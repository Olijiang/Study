#include <stdio.h>
#include <stdlib.h>
#define maxsize 8
#define MAX 100


typedef struct ArcNode
{	//�߽ڵ�
	int vex; //��ǰ��ָ��Ľڵ���Ϣ
	int cost; //�ߴ���
	struct ArcNode *nextarc;	//��һ����
}ArcNode;

typedef struct
{	//����ڵ�
	int vex;	//��������
	ArcNode *firstarc;	// ��������ĵ�һ����
}VNode;

typedef struct
{
	//�ڽӱ�
	VNode Adjlist[maxsize];	//��������
	int v,e; //��ǰ����Ķ������ͱ���
}AGraph;	

typedef struct
{
	int cost;
	int vex;
}HeapNode;

int DiEdge[maxsize][maxsize]={
	{MAX,2,3,1,MAX,MAX,MAX,MAX},
	{MAX,MAX,MAX,MAX,MAX,4,MAX,MAX},
	{MAX,MAX,MAX,MAX,4,MAX,MAX,MAX},
	{MAX,MAX,MAX,MAX,2,4,MAX,MAX},
	{MAX,MAX,MAX,MAX,MAX,MAX,1,MAX},
	{MAX,MAX,MAX,MAX,MAX,MAX,3,3},
	{MAX,MAX,MAX,MAX,MAX,MAX,MAX,MAX},
	{MAX,MAX,MAX,MAX,MAX,MAX,MAX,MAX}};

/* 
	1	5	7
0		3	6
	2	4
 */



AGraph *InitAGraph()
{
	//����һ���ڽӱ�ṹ��ͼ
	//printf("Begain InitAGraph\n");
	AGraph *G = (AGraph *)malloc(sizeof(AGraph));
	ArcNode *tb = (ArcNode *)malloc(sizeof(ArcNode));
	ArcNode *tn = NULL;
	G->e = G->v = 0;
	for (int i = 0; i < maxsize; ++i)
	{
		G->v++;
		G->Adjlist[i].vex = i;
		G->Adjlist[i].firstarc = NULL;
		for (int j = 0; j < maxsize; ++j)
			if (DiEdge[i][j]<MAX)
			{	// ���ߴ���,�½�һ���ڵ�
				G->e++;
				tn = (ArcNode *)malloc(sizeof(ArcNode));
				tn->vex = j;
				tn->cost = DiEdge[i][j];
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

void DispalyAGraph(AGraph *G)
{
	// ����ڽӱ�ṹ��ͼ
	ArcNode *t = NULL;
	for (int i = 0; i < maxsize; ++i)
	{
		printf("%d---", G->Adjlist[i].vex);
		t = G->Adjlist[i].firstarc;
		while(t!=NULL)
		{
			printf("-%d(%d)", t->vex, t->cost);
			t = t->nextarc;
		}
		printf("\n");
	}
	printf("-------------over\n");
}

void MDFS(int v, int j)
{
	// �ڽӾ�����ȱ���
	// Ѱ������֮���·��
	static int visit[maxsize];
	static int d=0;
	static int path[maxsize];
	static int top=-1;
	visit[v]=1;
	
	path[++top] = v;
	if (v==j)
	{	
		printf("%d->%d  ", path[0],j);
		printf("Lenth:%d  ",d);
		printf("Path:");
		for (int i = 0; i <= d; i++)
			printf("%d ",path[i]);
		printf("\n");
	}
	d++;
	for (int i = 0; i < maxsize; i++)
	{
		if (DiEdge[v][i]!=0 && visit[i]==0)
			MDFS(i, j);
	}
	top--;
	d--;
	
}

int MDFS1(int v, int j)
{   // �����ڽӾ���ı���
	// ������·�����򷵻س��ȡ��������ڣ��򷵻�-1
	static int visit[maxsize];
	static int d=0;   //��¼��������
	static int result=-1;	//��¼�������
	if(result!=-1) return result; 	//�ضϱ���
	if(v == j) result = d;
	d++;
	visit[v] = 1;
	for(int k=0; k<maxsize; k++)
		if(DiEdge[v][k] && !visit[k])
			MDFS1(k, j);
	d--;
	return result;
}

void DFS(AGraph *G, int v)
{
	//v��ʾ������ʼ��
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


int DetectCircle(AGraph *G, int v)
{
	// ����DFS �������ͼ���Ƿ���ڻ�·;
	static int visit[maxsize];
	static int finished[maxsize];
	static int flag = 0;	//���λ

	if (flag) return 1;	//flag ���ڶԱ������н�֧����������ֱ�ӷ��أ����ټ�������
	ArcNode *p = G->Adjlist[v].firstarc;
	visit[v] = 1;
	finished[v] = 1; // finished[i]=1 ��ʾ���ڱ��ֱ���֮�У��ٴη��ʵ��Լ�˵�����ڻ�·
	//printf("%d ",v);
	while(p!=NULL)
	{	
		if (finished[p->vex]==1)
		{
			flag=1; 	// ͬһ���ڵ㱻�ٴη��ʣ� ˵�����ڻ�·��
			return 1;	// �Ѽ�⵽��·ֱ�ӷ��أ�
		}
		if(visit[p->vex]==0)
		{
			DetectCircle(G,p->vex);
			finished[p->vex]=0;
		}
		p = p->nextarc;
	}
	return flag;
}


int DetectPath(AGraph *G, int v, int j, int L)
{
	//��� i�� j ��֮���Ƿ���ڳ���Ϊ L ��·�� 
	//���û��� DFS �㷨
	
	static int visit[maxsize];
	static int path[maxsize];
	static int d = 0;	//d Ϊ�Ѿ�������·�����ȣ���ʼΪ 0;
	static int flag = 0;
	//if(flag) return flag;
	ArcNode *p = G->Adjlist[v].firstarc;
	path[d] = v;
	if (v==j && d==L)	//d==L ���i j֮�䳤��Ϊ L ��·���� d==d ������� i j ֮������·����
	{
		for (int i = 0; i <= d; i++)
			printf("%d ",path[i]);
		printf("\n");
		flag = 1;
	}
	visit[v] = 1;
	d++;
	while(p!=NULL)
	{
		//if (!visit[p->vex] || p->vex==j)	//����Ƿ���� j �Ļ�·�������ڣ��������ص� j����ʱvisit�϶����Ϊ1����Ҫǿ�Ʒ��ʣ�
			//DetectPath(G,p->vex,j,L);
		
		if (!visit[p->vex])		//��� v j ��ͬʱ��·��
			DetectPath(G,p->vex,j,L);
			
		p = p->nextarc;
	}
	//�˳�ʱ��visit�ͷ�
	visit[v]=0;
	--d;
	return flag;
} 


void TopoSort(AGraph *G, int v)
{	//���������������
	static int visit[maxsize];
	static int TPstack[maxsize]; 	//����ջ
	static int top = 0;
	ArcNode *p = G->Adjlist[v].firstarc;
	visit[v] = 1;
	while (p!=NULL)
	{
		if (!visit[p->vex])
			TopoSort(G, p->vex);
		p = p->nextarc;
	}

	TPstack[top++] = v;	//�ݹ��˳��ڵ�ʱ�ڵ���ջ��ջ����Ϊ����������
	if (top==maxsize)
	{
		printf("TopoSort:");
		for (int i = maxsize-1; i >= 0; i--)
			printf("%d ", TPstack[i]);
	}
}

void SHeapUpAdjust(HeapNode* Heap, int k)
{	//С���ѵ���Ԫ�ص��ϸ�����,k�ϸ�Ԫ��λ��
	int i=k, j=k/2;
	HeapNode temp = Heap[k];
	while (j>0)
	{
		if (temp.cost < Heap[j].cost)
		{
			Heap[i] = Heap[j];
			i = j;		//�������ڵ��Ƿ���Ҫ�ϸ�
			j = j/2;
		}
		else break;
	}
	Heap[i] = temp;
}

void SHeapDownAdjust(HeapNode* Heap, int k, int h)
{   // С���ѵ���Ԫ�ص��³����̣�k: Ҫ������Ԫ��λ��;  h: �ѵ��ܳ���
	int i = k, j = 2*k;
	HeapNode temp = Heap[i];
	while(j<=h)
	{
		if (j<h && Heap[j].cost > Heap[j+1].cost) j++;
		if (temp.cost > Heap[j].cost)
		{
			Heap[i] = Heap[j];
			i = j;
			j = 2*j;
		}
		else break;
	}
	Heap[i] = temp;
}

void HeapDijkstra(AGraph *G, int v)
{	
	int dist[maxsize], path[maxsize], isJoin[maxsize];
	int num = 0; //������Ч�ڵ����
	int pos; //��λ�ڵ��ڶ��е�λ��
	ArcNode *p;
	HeapNode heap[maxsize+1]; 
	for (int i = 0; i < maxsize+1; i++) //��ʼ������
	{
		if (i<maxsize)
		{
			dist[i] = MAX;
			path[i] = -1;
			isJoin[i] = 0;
		}
		heap[i].cost=MAX; // ��ʼcostΪMAX	
		heap[i].vex = -1;	// �ڵ��ʼ��Ϊ-1
	}
	dist[v] = 0;
	path[v] = -1;
	isJoin[v] = 1;
	for (int i = 0; i < G->v - 1; ++i)
	{
		/* 
		˼·�� ����һ���ѶԱ߰�Ȩֵ���ж����򣬶��ڽڵ�Ϊ{node;cost}������cost����
		���⣺������ɺ�ߵ�λ�÷����˱仯������Ȩֵ��ζ�λ����Ӧ�ıߣ�������Ϊ����(������Ǳ�����)
		ʱ�临�Ӷȣ�
		 */
		p = G->Adjlist[v].firstarc;
		while (p!=NULL)	// �ڵ����
		{
			if(isJoin[p->vex]) //�����Ѽ��룬����
			{
				p=p->nextarc; 
				continue;
			}
			pos = 0;
			for (int k = 1; k < num+1; k++) //��λ�ڵ���heap�е�λ��
			{
				if(heap[k].vex==p->vex)
				{
					pos = k;
					break;
				}
			}
			if(pos && p->cost + dist[v] < heap[pos].cost)//��������p->vex����v��p->vex + dist[v] �ľ���С���ִ���룬����Ȩֵ
			{
				heap[pos].cost =  p->cost+dist[v];
				path[p->vex] = v;	//��¼��·��
			}
			if(!pos)	// ������p->vex �㣬 ��Ч�ڵ���num+1������λ�������½ڵ�
			{
				heap[++num].vex = p->vex;
				heap[num].cost = p->cost + dist[v];
				path[p->vex] = v;
			}
			SHeapUpAdjust(heap, num);	// �ѵ��ϸ�
			p=p->nextarc; 
		}
		dist[heap[1].vex] = heap[1].cost;	
		v = heap[1].vex; 	// �ԶѶ��ڵ㿪ʼ��һ��
		isJoin[v] = 1;
		heap[1] = heap[num--]; 	//�����Ѷ��ڵ㣬��Ч�ڵ���-1
		SHeapDownAdjust(heap, 1, num); 	//�Ѷ��³�
	}
}

void Dijkstra(int v)
{
	//DiEdgeΪ�������ͼ
	int dist[maxsize];
	int path[maxsize];
	int isJoin[maxsize];
	for (int i = 0; i < maxsize; i++)
	{
		dist[i] = MAX;
		path[i] = -1;
		isJoin[i] = 0;
	}
	
	dist[v] = 0;
	path[v] = -1;
	isJoin[v] = 1;
	int n = v, min = MAX;
	for (int i = 0; i < maxsize-1; ++i)
	{
		for (int i = 0; i < maxsize; ++i)//��������Ȩֵ
			if(dist[n] + DiEdge[n][i]<dist[i] && !isJoin[i]) //�ڵ�n��i�ľ���+��ʼ�ڵ㵽n�ľ���<��ʼ�ڵ㵽i�ľ���
			{
				dist[i] = DiEdge[n][i] + dist[n];	// ����dist�� ����С��
				path[i] = n;	// ·����n��i
			}
		min = MAX;
		for (int i = 0; i < maxsize; ++i) //�ҵ�Ȩֵ��С��һ�� Ȼ�����
			if (dist[i]<min && !isJoin[i]) 
			{
				min = dist[i];
				n = i;
			}
		isJoin[n] = 1;
	}
}

int main()
{
	AGraph *G = InitAGraph();

	DispalyAGraph(G);
	//DFS(G, 0);
	//MDFS(0, 6);
	//printf("lenth��%d \n", MDFS1(0,6));
	printf("Have Path?:%s\n",(DetectPath(G, 0, 4, 2))?"YES":"NO");
	printf("Have Circuit?:%s\n",(DetectCircle(G, 0))?"YES":"NO");
	TopoSort(G, 0);
	Dijkstra(0);
	HeapDijkstra(G, 0);
	return 0;
}